/**
 * Esta classe serve para armazenar dados para
 * gerar um relatorio do sistema. Portanto ela contém
 * atributos como livros emprestados, livros atrasados,
 * e livros reservados, atrivutos esses que foram
 * formulados de acordo com o que foi pedido no problema.
 * Além disso, ela contém métodos para gerar os dados dos
 * livros que estão emprestados, atrasados e reservados, e
 * métodos para gerar o historico de um usuario especifico
 * e pegar o livro mais popular.
 *
 * @author Sara Souza e Nayalane Ribeiro
 */

package model;

import dao.book.BookDaoImpl;
import dao.loan.LoanDAOImpl;
import exceptions.BookException;
import exceptions.LoanException;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class Report {
    BookDaoImpl books = new BookDaoImpl();
    LoanDAOImpl loans = new LoanDAOImpl();
    private List<Book> borrowedBooks; //armazena todos livros que estão emprestados no momento
    private List<Book> lateBooks; //armazena todos livros que estão atrasados no momento
    private List<Book> reservedBooks; //armazena todos livros que já estão reservados no momento

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
     * @throws BookException Se não houver livros emprestados no momento.
     */
    public int quantityBorrowedBooks() throws BookException {
        if (borrowedBooks.isEmpty()) {
            throw new BookException(BookException.NoBorrowedBooks);
        } else {
            return borrowedBooks.size();
        }
    }
    /**
     * Gera uma lista dos livros atualmente emprestados.
     *
     * @return Uma lista dos livros emprestados.
     * @throws BookException Se não houver livros emprestados no momento.
     */
    public List<Book> generatesBorrowedBooks() throws BookException {
        if (borrowedBooks.isEmpty()) {
            throw new BookException(BookException.NoBorrowedBooks);
        } else {
            return borrowedBooks;
        }
    }

    //LATE BOOKS
    /**
     * Gera uma lista dos livros atualmente atrasados.
     *
     * @return Uma lista dos livros atrasados.
     * @throws BookException Se não houver livros atrasados no momento.
     */
    public List<Book> generatesLateBooks() throws BookException {
        Map<Long, Loan> LoanMap = loans.getLoanMap();
        for (Loan loan : LoanMap.values()) {
            LocalDate now = LocalDate.now();
            if (now.isAfter(loan.getDateDevolution())) {
                lateBooks.add(loan.getBook());
            }
        }
        if (lateBooks.isEmpty()) {
            throw new BookException(BookException.NoLateBooks);
        } else {
            return lateBooks;
        }
    }
    /**
     * Retorna a quantidade de livros atrasados no momento.
     *
     * @return A quantidade de livros atrasados.
     * @throws BookException Se não houver livros atrasados no momento.
     */
    public int quantityLateBooks() throws BookException {
        if (lateBooks.isEmpty()) {
            throw new BookException(BookException.NoLateBooks);
        } else {
            return lateBooks.size();
        }
    }

    //RESERVED BOOKS
    /**
     * Gera uma lista dos livros que estão atualmente reservados por algum usuário.
     *
     * @return Uma lista dos livros reservados.
     */
    public List<Book> generatesReservedBooks() {
        Map<String, Book> BookMap = books.getBookMap();
        for (Book book : BookMap.values()) {
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
     * @throws BookException Se não houver livros reservados no momento.
     */
    public int quantityReservedBooks() throws BookException {
        if (reservedBooks.isEmpty()) {
            throw new BookException(BookException.NoReservedBooks);
        } else {
            return reservedBooks.size();
        }
    }

    //POPULAR BOOK
    /**
     * Retorna uma lista dos livros mais populares, ou seja, aqueles com a maior quantidade de empréstimos.
     *
     * @return Uma lista dos livros mais populares.
     * @throws LoanException Se não houver empréstimos registrados no momento.
     */
    public List<Book> generateBookHighestPopular() throws LoanException {
        int highestValue = 0;
        List<Book> bookPopular = null;
        Map<String, Book> BookMap = books.getBookMap();
        for (Book book : BookMap.values()) {
            int value = book.getQuantityLoan();
            if (value == 0) {
                highestValue = 0;
            } else if (value >= highestValue) {
                highestValue = value;
                bookPopular.add(book);
            }
        }
        if (bookPopular == null) {
            throw new LoanException(LoanException.NoLoan);
        } else {
            return bookPopular;
        }
    }

    //LOAN HISTORY
    /**
     * Gera o histórico de empréstimos de um determinado usuário.
     *
     * @param reader O leitor para o qual o histórico de empréstimos será gerado.
     * @return Uma lista de empréstimos realizados pelo usuário.
     * @throws LoanException Se o usuário não tiver histórico de empréstimo registrado.
     */
    public List<Loan> genareteUserLoan(Reader reader) throws LoanException {
        List<Loan> loanHistory = null;
        Map<Long, Loan> LoanMap = loans.getLoanMap();
        Long idReader = reader.getId();
        for (Loan loan : LoanMap.values()) {
            if (idReader == loan.getIdUser()) {
                loanHistory.add(loan);
            }
        }
        if (loanHistory == null) {
            throw new LoanException(LoanException.NoUserLoan);
        } else {
            return loanHistory;
        }}
}


