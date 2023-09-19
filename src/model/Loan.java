package model;
import java.util.Date;

public class Loan {
    private int idLoan;
    private int idUser;
    private Book book;
    private Date dateLoan;
    private Date dateDevolution; //vai ser de 10 dias
    private int renovationQuantity; //limite de 3 renovacoes do livro
    public Loan(int idLoan, int idUser, Book book, Date dateLoan, Date dateDevolution, int renovationQuantity) {
        this.idLoan = idLoan;
        this.idUser = idUser;
        this.book = book;
        this.dateLoan = dateLoan; //vai adicionar a data de hoje a data do emprestimo
        this.dateDevolution = dateDevolution; //chama a função que vai somar +10 dias a data do emprestimo
        this.renovationQuantity = renovationQuantity;
    }
    // Métodos get e set para idLoan
    public int getIdLoan() {return idLoan;}
    public void setIdLoan(int idLoan) {this.idLoan = idLoan;}
    // Métodos get e set para idUser
    public int getIdUser() {return idUser;}
    public void setIdUser(int idUser) {this.idUser = idUser;}
    // Métodos get e set para book
    public Book getBook() {return book;}
    public void setBook(Book book) {this.book = book;}
    // Métodos get e set para dateLoan
    public Date getDateLoan() {return dateLoan;}
    public void setDateLoan(Date dateLoan) {this.dateLoan = dateLoan;}
    // Métodos get e set para dateDevolution
    public Date getDateDevolution() {return dateDevolution;}
    public void setDateDevolution(Date dateDevolution) {this.dateDevolution = dateDevolution;}
    // Métodos get e set para renovationQuantity
    public int getRenovationQuantity() {return renovationQuantity;}
    public void setRenovationQuantity(int renovationQuantity) {this.renovationQuantity = renovationQuantity;}
}
