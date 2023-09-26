package model;

import dao.Book.BookDAO;
import dao.DAO;
import dao.Loan.LoanDAO;
import java.time.LocalDate;

public class Librarian extends User{
    public Boolean block; // diz se o bibliotecario está bloqueado ou não: false - não e true - sim
    private int idLoan = 0;
    public String getBlock(){
        if(block){ //block == true
            return "Blocked";
        }else{
            return "Active";}}
    public void block_reader(Librarian librarian){
        librarian.block = true;}
    public void unlock_reader(Librarian librarian){
        librarian.block = false;}
    public int generateId(int idLoan){ //gerar automaticamente o id do emprestimo
        return idLoan +=1;}
    public Librarian(String name, String pin, String s, int age, int phone, LocalDate registration_date, Residence address) {
        super(name, pin, s, age, phone, registration_date, address);}
    public LocalDate dateToday(){
        return LocalDate.now();} //pega a data de hoje
    public LocalDate dateEnd(LocalDate datetoday){ //data final com prazo de 10 dias
        return datetoday.plusDays(10);}
    public void register_loan(Reader reader, Book book){ //registrar emprestimo de leitor
        // Gere automaticamente o ID do empréstimo
        int loanId = generateId(idLoan);
        LocalDate dateLoan = dateToday(); //diz a data do dia atual ou seja, a data do emprestimo
        // Calcule a data de devolução (10 dias a partir da data de empréstimo)
        LocalDate dateDevolution = dateEnd(dateLoan);
        // Criando um emprestimo
        Loan loan = new Loan(loanId, reader.getId(), book, dateLoan, dateDevolution, 0);
        //Usando o DAO para adicionar o emprestimo ao banco de dados
        LoanDAO loandao = DAO.getLoanDAO();
        loandao.creat(loan);
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
