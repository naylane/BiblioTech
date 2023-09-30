package model;

import dao.DAO;
import dao.loan.LoanDAO;
import dao.loan.LoanDAOImpl;
import dao.reader.ReaderDAOImpl;
import exceptions.BookException;
import exceptions.LoanException;
import exceptions.UsersException;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Librarian extends User{
    Report report = new Report();
    public Boolean block; // diz se o bibliotecario está bloqueado ou não: false - não e true - sim
    LoanDAOImpl loanDAO = new LoanDAOImpl();
    public String cargo = "Bibliotecario";

    public Librarian(long id, String name, String pin, String phone, Residence address) {
        super(id, name, pin, phone, address);}

    public Boolean getBlock(){
        if(block){ //block == true
            return true;
        }else{
            return false;
        }}

    public void blockLibrarian(Librarian librarian) throws UsersException {
        librarian.block = true;
    }

    public void unlockLibrarian(Librarian librarian) throws UsersException {
        librarian.block = false;
    }

    public long generateId(long idLoan){ //gerar automaticamente o id do emprestimo
        return idLoan +=1;
    }

    public LocalDate dateToday(){ // pega a data de hoje
        return LocalDate.now();
    }

    public LocalDate dateEnd(LocalDate datetoday){ //data final com prazo de 10 dias
        return datetoday.plusDays(10);
    }

    public void registerLoan(Reader reader, Book book) throws BookException, LoanException { // registrar emprestimo de leitor
        if(book.getQuantityAvailable() == 0){ //se tem livro disponivel
            throw new BookException(BookException.NotAvailable);}
        else{
            if(book.getResevationQueue().isEmpty()){  //retorna true se a fila estiver vazia e false se tiver um elemento ao menos tiver uma pessoa
                if(reader.getBlock()){ //retorna true se estiver block
                    throw new LoanException(LoanException.UserBlock);}
                else{
                    // Gera automaticamente o ID do empréstimo
                    long loanId = loanDAO.getNextId();
                    LocalDate dateLoan = dateToday(); //diz a data do dia atual ou seja, a data do emprestimo
                    // Calcule a data de devolução (10 dias a partir da data de empréstimo)
                    LocalDate dateDevolution = dateEnd(dateLoan);
                    // Criando um emprestimo
                    Loan loan = new Loan(loanId, reader.getId(), book, dateLoan, dateDevolution, 0);
                    //Usando o DAO para adicionar o emprestimo ao banco de dados
                    LoanDAO loandao = DAO.getLoanDAO();
                    loandao.creat(loan);
                    book.setQuantityLoan(1); //soma a variavel da quantidade de emprestimo
                    report.storesBorrowedBooks(book); //add na lista de livros emprestados no momento
                }
            }else{ //aq no caso de ter elementos na fila
                if(book.getResevationQueue().element() == reader){  //no caso de o leitor ser o primeiro da fila, realiza o emprestimo, se não ele tem que reservar o livro
                    // Gere automaticamente o ID do empréstimo
                    long loanId = loanDAO.getNextId();
                    LocalDate dateLoan = dateToday(); //diz a data do dia atual ou seja, a data do emprestimo
                    // Calcule a data de devolução (10 dias a partir da data de empréstimo)
                    LocalDate dateDevolution = dateEnd(dateLoan);
                    // Criando um emprestimo
                    Loan loan = new Loan(loanId, reader.getId(), book, dateLoan, dateDevolution, 0);
                    //Usando o DAO para adicionar o emprestimo ao banco de dados
                    LoanDAO loandao = DAO.getLoanDAO();
                    loandao.creat(loan); //adicionando no banco de dados
                    report.storesBorrowedBooks(book); //add na lista de livros emprestados no momento
                    book.getResevationQueue().remove(); //removendo o primeiro elemento após concluir o emprestimo
                }else{
                    throw new BookException(BookException.NotAvailable);}}}}

    public void registerBook(String isbn, String title, String author, String publishing_company, int year_publication, String category, BookLocation location, int quantity) {
        Book newBook = new Book(isbn, title, author, publishing_company, year_publication, category, location, quantity);

        for (Book book : DAO.getBookDAO().findAll()) {
            if (book.getISBN() == newBook.getISBN()) { // se o isbn dos livros forem iguais
                // já existe esse livro cadastrado logo só se soma a quantidade existente do livro
                book.setQuantityAvailable(book.getQuantityAvailable() + newBook.getQuantityAvailable());
                DAO.getBookDAO().update(book); // atualizando os dados no DAO
                //System.out.println("\nsuccessfully registered book!");
                return; // sai do método pois o livro já foi cadastrado
            }
        }
        DAO.getBookDAO().creat(newBook); // criou o livro e o armazenou no map tendo o seu isbn como id
        //System.out.println("\nsuccessfully registered book!");
    }

    /**
     * Método que realiza a devolução de um empréstimo, se o mesmo estiver ativo, e multa o leitor se a data de devolução passa da data esperada.
     * @param loan empréstimo
     * @param reader leitor
     */
    public void registerDevolution(Loan loan, Reader reader){
        if(loan.getActive()) { //se o emprestimo estiver ativo
            // verificar se a data de devolução condiz com o esperado
            LocalDate now = LocalDate.now();
            if (now.isAfter(loan.getDateDevolution())) { // se a data de devolução passou do esperado
                // leitor é multado
                long days = ChronoUnit.DAYS.between(loan.getDateDevolution(), now) * 2; // dobro de dias de atraso
                reader.fineDeadline = LocalDate.now().plusDays(days);
                reader.block = true;
            }
            // devolve o livro
            loan.setActive(false); // mudando o estado de ativo do emprestimo para falso
            Book book = loan.getBook();
            book.setQuantityAvailable(book.getQuantityAvailable() + 1); // atualizando a quantidade de determinado livro disponível
            report.takeOutBorrowedBook(book); //remove da lista de livros emprestados no momento
        }}

}
