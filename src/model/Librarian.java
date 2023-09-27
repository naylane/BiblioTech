package model;

import dao.book.BookDAO;
import dao.DAO;
import dao.loan.LoanDAO;
import java.time.LocalDate;

public class Librarian extends User{
    public Boolean block; // diz se o bibliotecario está bloqueado ou não: false - não e true - sim
    private long idLoan = 0;

    public Librarian(long id, String name, String pin, int phone, Residence address) {
        super(id, name, pin, phone, address);
    }

    public String getBlock(){
        if(block){ //block == true
            return "Blocked";
        }else{
            return "Active";
        }
    }

    public void blockReader(Librarian librarian){
        librarian.block = true;
    }

    public void unlockReader(Librarian librarian){
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

    public void registerLoan(Reader reader, Book book){ // registrar emprestimo de leitor
        if(book.getQuantity() == 0){
            System.out.println("This book is not currently available");}
        else{
            if(book.getResevationQueue().isEmpty()){  //retorna true se a fila estiver vazia e false se tiver um elemento ao menos
                // Gera automaticamente o ID do empréstimo
                long loanId = generateId(idLoan);
                LocalDate dateLoan = dateToday(); //diz a data do dia atual ou seja, a data do emprestimo
                // Calcule a data de devolução (10 dias a partir da data de empréstimo)
                LocalDate dateDevolution = dateEnd(dateLoan);
                // Criando um emprestimo
                Loan loan = new Loan(loanId, reader.getId(), book, dateLoan, dateDevolution, 0);
                //Usando o DAO para adicionar o emprestimo ao banco de dados
                LoanDAO loandao = DAO.getLoanDAO();
                loandao.creat(loan);
                System.out.println("successfully registered loan!");
            }else{ //aq no caso de ter elementos na fila
                if(book.getResevationQueue().element() == reader){  //no caso de o leitor ser o primeiro da fila, realiza o emprestimo
                    // Gere automaticamente o ID do empréstimo
                    long loanId = generateId(idLoan);
                    LocalDate dateLoan = dateToday(); //diz a data do dia atual ou seja, a data do emprestimo
                    // Calcule a data de devolução (10 dias a partir da data de empréstimo)
                    LocalDate dateDevolution = dateEnd(dateLoan);
                    // Criando um emprestimo
                    Loan loan = new Loan(loanId, reader.getId(), book, dateLoan, dateDevolution, 0);
                    //Usando o DAO para adicionar o emprestimo ao banco de dados
                    LoanDAO loandao = DAO.getLoanDAO();
                    loandao.creat(loan);
                    System.out.println("successfully registered loan!");
                    book.getResevationQueue().remove(); //removendo o primeiro elemento após concluir o emprestimo
                }else{
                    System.out.println("unfortunately this book is already reserved");
                }
            }
        }
    }

    public void registerBook(int isbn, String title, String author, String publishing_company, int year_publication, String category, BookLocation location, int quantity){
        Book book = new Book(isbn, title, author, publishing_company, year_publication, category, location, quantity);
        BookDAO bookDao = DAO.getBookDAO(); //Usando o DAO para adicionar o livro ao banco de dados
        bookDao.creat(book); //criou o book no banco de dados e armazenou no map tendo o seu isbn como id
        System.out.println("\nsuccessfully registered book!");
    }

    public void registerDevolution(Reader reader, Book book){ //a fazer

    }

}
