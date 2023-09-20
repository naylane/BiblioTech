package model;
import java.time.LocalDate;
import java.util.Date;

public class Loan {
    private int idLoan;
    private int idUser;
    private Book book;
    private LocalDate dateLoan;
    private LocalDate dateDevolution; //vai ser de 10 dias
    private int renovationQuantity; //limite de 3 renovacoes do livro
    private boolean active; // boolean que diz se o empréstimo já foi devolvido ou não

    public Loan(int idLoan, int idUser, Book book, LocalDate dateLoan, LocalDate dateDevolution, int renovationQuantity, boolean active) {
        this.idLoan = idLoan;
        this.idUser = idUser;
        this.book = book;
        this.dateLoan = dateLoan; //vai adicionar a data de hoje a data do emprestimo
        this.dateDevolution = dateDevolution; //chama a função que vai somar +10 dias a data do emprestimo
        this.renovationQuantity = renovationQuantity;
        this.active = active;
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
    public LocalDate getDateLoan() {return dateLoan;}
    public void setDateLoan(LocalDate dateLoan) {this.dateLoan = dateLoan;}

    // Métodos get e set para dateDevolution
    public LocalDate getDateDevolution() {return dateDevolution;}
    public void setDateDevolution(LocalDate dateDevolution) {this.dateDevolution = dateDevolution;}

    // Métodos get e set para renovationQuantity
    public int getRenovationQuantity() {return renovationQuantity;}
    public void setRenovationQuantity(int renovationQuantity) {this.renovationQuantity = renovationQuantity;}

    // Métodos get e set para active
    public boolean getActive() {return active;}
    public void setActive(boolean active) {this.active = active;}
}
