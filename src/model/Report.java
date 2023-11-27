package model;

import dao.DAO;
import dao.book.BookDAO;
import dao.loan.LoanDAO;
import exceptions.LoanException;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Esta classe serve para armazenar dados para
 * gerar um relatorio do sistema. Portanto, ela contém atributos como livros emprestados, livros atrasados,
 * e livros reservados, atributos esses formulados conforme o que foi pedido no problema.<br>
 * Além disso, ela contém métodos para gerar os dados dos livros que estão emprestados, atrasados e reservados, e
 * métodos para gerar o historico de um usuario específico e pegar o livro mais popular.<br>
 * Padrão de Projeto Singleton.
 * @author Sara Souza e Naylane Ribeiro
 */
public class Report implements Serializable {
    private BookDAO books = DAO.getBookDAO();
    private LoanDAO loans = DAO.getLoanDAO();
    private List<Book> borrowedBooks; //armazena todos os livros que estão emprestados no momento
    private List<Book> lateBooks; //armazena todos os livros que estão atrasados no momento
    private List<Book> reservedBooks; //armazena todos os livros que estão reservados no momento

    public Report() throws LoanException {
        this.borrowedBooks = new ArrayList<>();
        this.lateBooks = new ArrayList<>();
        this.reservedBooks = new ArrayList<>();
    }

    //BORROWED BOOKS
    /**
     * Armazena um livro na lista de livros emprestados na hora de um novo empréstimo.
     *
     * @param book O livro a ser armazenado na lista de livros emprestados.
     */
    public void storesBorrowedBooks(Book book) {
        borrowedBooks.add(book);
    }

    /**
     * Remove um livro da lista de livros emprestados na hora da devolução.
     *
     * @param book O livro a ser removido da lista de livros emprestados.
     */
    public void takeOutBorrowedBook(Book book) {
        borrowedBooks.remove(book);
    }

    /**
     * Retorna a quantidade de livros emprestados no momento.
     *
     * @return A quantidade de livros emprestados.
     */
    public int quantityBorrowedBooks() {
            return borrowedBooks.size();}

    /**
     * Gera uma lista dos livros atualmente emprestados.
     *
     * @return Uma lista dos livros emprestados.
     */
    public List<Book> generatesBorrowedBooks() {
        return borrowedBooks;
    }

    //LATE BOOKS
    /**
     * Gera uma lista dos livros atualmente atrasados.
     *
     * @return Uma lista dos livros atrasados.
     */
    public List<Book> generatesLateBooks() {
        Map<Long, Loan> LoanMap = loans.getLoanMap();
        for (Loan loan : LoanMap.values()) {
            LocalDate now = LocalDate.now();
            if (now.isAfter(loan.getDateDevolution())) {
                lateBooks.add(loan.getBook());
            }
        }return lateBooks;
    }

    /**
     * Retorna a quantidade de livros atrasados no momento.
     *
     * @return A quantidade de livros atrasados.
     */
    public int quantityLateBooks() {
        return lateBooks.size();}

    //RESERVED BOOKS
    /**
     * Gera uma lista dos livros que estão atualmente reservados por algum usuário.
     *
     * @return Uma lista dos livros reservados.
     */
    public List<Book> generatesReservedBooks() {
        List<Book> BookMap = books.findAll();
        for (Book book : BookMap) {
            if (!book.getResevationQueue().isEmpty()) {
                reservedBooks.add(book);
            }
        }
        return reservedBooks;
    }

    /**
     * Retorna a quantidade de livros reservados no momento.
     *
     * @return A quantidade de livros reservados.
     */
    public int quantityReservedBooks() {
        return reservedBooks.size();}

    //POPULAR BOOK
    /**
     * Retorna uma lista dos livros mais populares, ou seja, aqueles com a maior quantidade de empréstimos.
     *
     * @return Uma lista dos livros mais populares.
     */
    public List<Book> generateBookHighestPopular() {
        List<Book> bookPopular = new ArrayList<>();
        List<Book> bookList = books.findAll();
        int highestValue = 0;
        for (Book bookFound : bookList) {
            int value = bookFound.getQuantityLoan();
            if (value == 0) {
                highestValue = 0;
            } else if (value >= highestValue) {
                highestValue = value;
                bookPopular.add(bookFound);
            }
        }return bookPopular;
    }

    //LOAN HISTORY
    /**
     * Gera o histórico de empréstimos de um determinado usuário.
     *
     * @param reader O leitor para o qual o histórico de empréstimos será gerado.
     * @return Uma lista de empréstimos realizados pelo usuário.
     */
    public List<Loan> genareteUserLoan(Reader reader) {
        List<Loan> loanHistory = new ArrayList<>();
        List<Loan> LoanList = loans.findAll();
        Long idReader = reader.getId();

        for (Loan loanFound : LoanList) {
            if (idReader == loanFound.getIdUser()) {
                loanHistory.add(loanFound);
            }
        }

        return loanHistory;
    }

    public BookDAO getBooks() { return books; }

    public LoanDAO getLoans() { return loans; }
}
