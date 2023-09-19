package model;
import dao.Book.BookDAO;
import dao.DAO;
import java.util.Date;
import java.util.Calendar;

public class Librarian extends User{
    private int idLoan=0;
    public int generateId(int idLoan){ //gerar automaticamente o id do emprestimo
        return idLoan +=1;}
    public Librarian(String name, String pin, String s, int age, int phone, Date registration_date, Residence address, Boolean block) {
        super(name, pin, s, age, phone, registration_date, address, block);}
    public Date dateToday(){
        return new Date();} //pega a data de hoje
    public Date dateEnd(Date datetoday){ //data final com prazo de 10 dias
        // Convertendo a data atual para um objeto Calendar
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(datetoday);
        // Somando 10 dias à data de hoje
        calendar.add(Calendar.DAY_OF_MONTH, 10);
        // Obtendo a nova data após a adição de 10 dias
        return calendar.getTime();}
    public void register_loan(Reader reader, Book book){ //registrar emprestimo de leitor
        // Gere automaticamente o ID do empréstimo
        int loanId = generateId(idLoan);
        Date dateLoan = dateToday(); //diz a data do dia atual ou seja, a data do emprestimo
        // Calcule a data de devolução (10 dias a partir da data de empréstimo)
        Date dateDevolution = dateEnd(dateLoan);
        // Criando um emprestimo - falta adicionar no banco de dados (hash map)
        Loan loan = new Loan(loanId, reader.getId(), book, dateLoan, dateDevolution, 0);
        System.out.println("\nsuccessfully registered loan!");
    }
    public void register_book(int isbn, String title, String author, String publishing_company, int year_publication, String category, BookLocation location, int quantity){
        Book book = new Book(isbn, title, author, publishing_company, year_publication, category, location, quantity);
        BookDAO bookDao = DAO.getBookDAO(); //Usando o DAO para adicionar o livro ao banco de dados
        bookDao.creat(book); //criou o book no banco de dados e armazenou no map tendo o seu isbn como id
        System.out.println("\nsuccessfully registered book!");

    }
    public void register_devolution(Reader reader, Book book){ //a fazer
    }
}
