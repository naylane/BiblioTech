package model;

import dao.DAO;
import exceptions.BookException;
import exceptions.LoanException;
import exceptions.UsersException;

import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * A classe Librarian é uma subclasse da classe User.
 * Portando, ela herda os atributos e métodos da
 * superclasse User, e contém atributos como block,
 * que indica se o bibliotecario está bloqueado.
 * Além disso, contém um construtor para criar o
 * objeto e métodos getters e setters para pegar e
 * alterar os atributos privados. Contém também
 * metódos que são especificos para as funcionalidades
 * de um bibliotecario, como fazer emprestimo,
 * registrar devolução, registrar livro, bloquear
 * e desbloquear bibliotecario.
 *
 * @author Sara Souza e Naylane Ribeiro
 */
public class Librarian extends User{
    public Boolean block; // diz se o bibliotecario está bloqueado ou não: false - não e true - sim

    /**
     * Construtor da classe Librarian para criar um novo bibliotecário.
     *
     * @param name    O nome do bibliotecário.
     * @param pin     A senha do bibliotecário.
     * @param phone   O número de telefone do bibliotecário.
     * @param address O endereço do bibliotecário.
     */
    public Librarian(String name, String pin, String phone, Residence address) throws Exception {
        super(name, pin, phone, address);
    }

    /**
     * Obtém o status de bloqueio do bibliotecário.
     *
     * @return true se o bibliotecário estiver bloqueado, false se não estiver bloqueado.
     */
    public Boolean getBlock(){
        if(block){ //block == true
            return true;
        }else{
            return false;
        }}
    /**
     * Bloqueia o bibliotecário.
     *
     * @param librarian O bibliotecário a ser bloqueado.
     */
    public void blockLibrarian(Librarian librarian) {
        librarian.block = true;
    }

    /**
     * Desbloqueia o bibliotecário.
     *
     * @param librarian O bibliotecário a ser desbloqueado.
     */
    public void unlockLibrarian(Librarian librarian) {
        librarian.block = false;
    }

    /**
     * Obtém a data atual.
     *
     * @return A data atual.
     */
    public LocalDate dateToday(){ // pega a data de hoje
        return LocalDate.now();
    }

    /**
     * Calcula a data final com um prazo de 10 dias a partir de uma data fornecida.
     *
     * @param datetoday A data inicial.
     * @return A data final com um prazo de 10 dias.
     */
    public LocalDate dateEnd(LocalDate datetoday){ //data final com prazo de 10 dias
        return datetoday.plusDays(10);
    }

    /**
     * Registra um empréstimo para um leitor.
     *
     * @param reader O leitor que está fazendo o empréstimo.
     * @param book   O livro a ser emprestado.
     * @throws BookException se ocorrer um erro relacionado ao livro.
     * @throws LoanException se ocorrer um erro relacionado ao empréstimo.
     */
    public void registerLoan(Reader reader, Book book) throws Exception { // registrar emprestimo de leitor
        if(book.getQuantityAvailable() == 0){ //se tem livro disponivel
            throw new BookException(BookException.NotAvailable);}
        else{
            if(book.getResevationQueue().isEmpty()){  //retorna true se a fila estiver vazia e false se tiver um elemento ao menos tiver uma pessoa
                if(reader.getBlock()){ //retorna true se estiver block
                    throw new LoanException(UsersException.UserBlock);}
                else{
                    if(reader.getLoanLimit() == 0){throw new LoanException(LoanException.LoanLimit);
                    }else{creatLoan(reader, book);}
                }
            }else{ //aq no caso de ter elementos na fila
                if(book.getResevationQueue().element() == reader){  //no caso de o leitor ser o primeiro da fila, realiza o emprestimo, se não ele tem que reservar o livro
                    if(reader.getBlock()){ //retorna true se estiver block
                        throw new LoanException(UsersException.UserBlock);}
                    else{
                        if(reader.getLoanLimit() == 0){throw new LoanException(LoanException.LoanLimit);
                        }else{creatLoan(reader, book);}}
                }else{
                    throw new BookException(BookException.NotAvailable);}}}}

    /**
     * Cria um novo leitor no sistema.
     *
     * @param reader   O leitor do emprestimo.
     * @param book     O livro do emprestimo.
     *
     */
    public Loan creatLoan(Reader reader, Book book) throws IOException, LoanException, Exception {
        LocalDate dateLoan = dateToday(); // diz a data do dia atual ou seja, a data do emprestimo
        LocalDate dateDevolution = dateEnd(dateLoan); // calcula a data de devolução (10 dias a partir da data de empréstimo)
        Loan loan = new Loan(reader.getId(), book, dateLoan, dateDevolution); // cria emprestimo
        book.setQuantityLoan(1); // soma a variavel da quantidade de emprestimo
        book.setQuantityAvailable(book.getQuantityAvailable() - 1); // atualizando a quantidade disponível do livro
        reader.increaseLoanLimit();
        // persistência de dados
        DAO.getLoanDAO().create(loan); // adiciona o emprestimo ao banco de dados

        return loan;
    }

    /**
     * Registra um novo livro no sistema.
     *
     * @param isbn              O número ISBN do livro.
     * @param title             O título do livro.
     * @param author            O autor do livro.
     * @param publishing_company A editora do livro.
     * @param year_publication  O ano de publicação do livro.
     * @param category          A categoria à qual o livro pertence.
     * @param location          O local onde o livro está armazenado.
     * @param quantity          A quantidade inicial de cópias disponíveis do livro.
     */
    public void registerBook(String isbn, String title, String author, String publishing_company, int year_publication, String category, BookLocation location, int quantity) throws BookException, IOException {
        Book newBook = new Book(isbn, title, author, publishing_company, year_publication, category, location, quantity);

        for (Book book : DAO.getBookDAO().findAll()) {
            if (book.getISBN() == newBook.getISBN()) { // se o isbn dos livros forem iguais
                // já existe esse livro cadastrado logo só se soma a quantidade existente do livro
                book.setQuantityAvailable(book.getQuantityAvailable() + newBook.getQuantityAvailable());
                DAO.getBookDAO().update(book); // atualizando os dados no DAO
                return; // sai do método pois o livro já foi cadastrado
            }
        }
        DAO.getBookDAO().create(newBook); // criou o livro e o armazenou no map tendo o seu isbn como id
        System.out.println("\nsuccessfully registered book!");
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
                reader.setFineDeadline(LocalDate.now().plusDays(days));
                reader.setBlock(true);
            }
            // devolve o livro
            loan.setActive(false); // mudando o estado de ativo do emprestimo para falso
            Book book = loan.getBook();
            book.setQuantityAvailable(book.getQuantityAvailable() + 1); // atualizando a quantidade de determinado livro disponível
            reader.increaseLoanLimit();
        }
    }
}
