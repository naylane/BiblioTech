package model;

import dao.loan.LoanDAOImpl;

import java.time.LocalDate;

/**
 * Esta classe contém atributos para a realização de um
 * emprestimo. Portanto ela contém atributos como
 * id de usuario, id do emprestimo, livro, data de
 * devolução, data de emprestimo, quantidade de
 * renovações e por fim, uma variavel booleana que
 * indica se o emprestimo está ativo ou não.
 * Além disso, ela contém um construtor para criar o
 * objeto e métodos getters e setters para pegar e alterar
 * os atributos privados.
 *
 * @author Sara Souza e Naylane Ribeiro
 */
public class Loan {
    private long idLoan; //esse id muda dps
    private long idUser;
    private Book book;
    private LocalDate dateLoan; //vai adicionar a data de hoje a data do emprestimo
    private LocalDate dateDevolution; //vai ser de 10 dias e chama a função que soma +10 dias a data do emprestimo
    private int renovationQuantity; //limite de 3 renovacoes do livro
    private boolean active = true; // boolean que diz se o empréstimo já foi devolvido ou não (false = sim, true - não)
    LoanDAOImpl loanDAO = new LoanDAOImpl();
    /**
     * Construtor da classe Loan.
     *
     * @param idUser         O ID do usuário associado ao empréstimo.
     * @param book           O livro emprestado.
     * @param dateLoan       A data de empréstimo.
     * @param dateDevolution A data de devolução prevista.
     */
    public Loan(long idUser, Book book, LocalDate dateLoan, LocalDate dateDevolution) {
        this.idLoan = loanDAO.getNextId(); //gera o id automaticamente
        this.idUser = idUser;
        this.book = book;
        this.dateLoan = dateLoan;
        this.dateDevolution = dateDevolution;
        this.renovationQuantity = 0;
    }

    // Métodos get e set para idLoan
    public long getIdLoan() {return idLoan;}
    public void setIdLoan(int idLoan) {this.idLoan = idLoan;}

    // Métodos get e set para idUser
    public long getIdUser() {return idUser;}
    public void setIdUser(long idUser) {this.idUser = idUser;}

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
    public void setRenovationQuantity(int renovationQuantity) {this.renovationQuantity += renovationQuantity;}

    // Métodos get e set para active
    public boolean getActive() {return active;}
    public void setActive(boolean active) {this.active = active;}
}
