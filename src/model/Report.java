package model;

import dao.DAO;
import dao.book.BookDAO;
import dao.loan.LoanDAO;
import exceptions.LoanException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Esta classe serve para armazenar dados para
 * gerar um relatorio do sistema. Portanto, ela contém atributos como livros emprestados, livros atrasados,
 * e livros reservados, atributos esses formulados conforme o que foi pedido no problema.<br>
 * Além disso, ela contém métodos para gerar os dados dos livros que estão emprestados, atrasados e reservados, e
 * métodos para gerar o historico de um usuario específico e pegar o livro mais popular.<br>
 * @author Sara Souza e Naylane Ribeiro
 */
public class Report {
    private final BookDAO bookDAO = DAO.getBookDAO();
    private final LoanDAO loanDAO = DAO.getLoanDAO();
    private long borrowedBooks; // quantidade de livros emprestados no momento
    private long lateBooks; // quantidade de livros que estão atrasados no momento
    private long reservedBooks; // quantidade de livros que estão reservados no momento

    public Report() throws LoanException {
        this.borrowedBooks = 0;
        this.lateBooks = 0;
        this.reservedBooks = 0;
    }

    /**
     * Percorre o hashmap de emprestimos em busca dos emprestimos que se encontram ativos.
     * @return Quantidade de livros emprestados.
     */
    public long generatesBorrowedBooks() {
        for (Loan loan : loanDAO.findAll()) {
            if (loan.getActive()) {
                this.borrowedBooks++;
            }
        }
        return borrowedBooks;
    }

    /**
     * Percorre o hashmap de emprestimos em busca dos emprestimos atualmente atrasados.
     * @return Quantidade de livros atrasados.
     */
    public long generatesLateBooks() {
        for (Loan loan : loanDAO.findAll()) {
            LocalDate now = LocalDate.now();
            if (now.isAfter(loan.getDateDevolution())) {
                lateBooks++;
            }
        }
        return lateBooks;
    }

    /**
     * Percorre o hashmap de livros em busca daqueles que estão atualmente reservados por algum usuário.
     * @return Quantidade de livros reservados.
     */
    public Long generatesReservedBooks() {
        for (Book book : bookDAO.findAll()) {
            if (!book.getResevationQueue().isEmpty()) {
                reservedBooks++;
            }
        }
        return reservedBooks;
    }

    /**
     * Retorna uma lista dos livros mais populares, ou seja, aqueles com a maior quantidade de empréstimos.
     *
     * @return Uma lista dos livros mais populares.
     */
    public List<Book> generateBookHighestPopular() {
        List<Book> bookPopular = new ArrayList<>();
        int highestValue = 0;
        for (Book bookFound : bookDAO.findAll()) {
            int value = bookFound.getQuantityLoan();
            if (value == 0) {
                highestValue = 0;
            } else if (value >= highestValue) {
                highestValue = value;
                bookPopular.add(bookFound);
            }
        }
        return bookPopular;
    }

    /**
     * Gera o histórico de empréstimos de um determinado usuário.
     *
     * @param reader O leitor para o qual o histórico de empréstimos será gerado.
     * @return Uma lista de empréstimos realizados pelo usuário.
     */
    public List<Loan> genareteUserLoan(Reader reader) {
        List<Loan> loanHistory = new ArrayList<>();
        long idReader = reader.getId();
        for (Loan loanFound : loanDAO.findAll()) {
            if (idReader == loanFound.getIdUser()) {
                loanHistory.add(loanFound);
            }
        }
        return loanHistory;
    }

}
