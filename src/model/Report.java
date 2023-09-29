package model;

import dao.book.BookDaoImpl;
import dao.loan.LoanDAOImpl;
import exceptions.BookException;
import exceptions.LoanException;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Report {
    BookDaoImpl books = new BookDaoImpl();
    LoanDAOImpl loans = new LoanDAOImpl();
    private List<Book> borrowedBooks; //armazena todos livros que estão emprestados no momento
    private List<Book> lateBooks; //armazena todos livros que estão atrasados no momento
    private List<Book> reservedBooks; //armazena todos livros que já estão reservados no momento

    //BORROWED BOOKS
    public void storesBorrowedBooks(Book book) {  //armazenar na lista de livros emprestados na hora de um novo emprestimo
        borrowedBooks.add(book);
    }

    public void takeOutBorrowedBook(Book book) { //tirar da lista de livros emprestados na hora da devolução
        borrowedBooks.remove(book);
    }

    public int quantityBorrowedBooks() throws BookException { //retorna a quantidade de livros emprestados no momento
        if (borrowedBooks.isEmpty()) { //retorna true se estiver vazia
            throw new BookException(BookException.NoBorrowedBooks);
        } else {
            return borrowedBooks.size();
        }
    }

    public List<Book> generatesBorrowedBooks() throws BookException {
        if (borrowedBooks.isEmpty()) { //retorna true se estiver vazia
            throw new BookException(BookException.NoBorrowedBooks);
        } else {
            return borrowedBooks;
        }
    }

    //LATE BOOKS
    public List<Book> generatesLateBooks() throws BookException {
        Map<Long, Loan> LoanMap = loans.getLoanMap(); //pega o hash map de meprestimos
        for (Loan loan : LoanMap.values()) {
            LocalDate now = LocalDate.now(); //pega a data de hoje
            if (now.isAfter(loan.getDateDevolution())) { // se a data de devolução passou do esperado)
                lateBooks.add(loan.getBook()); //adiciona na lista de livros atrasados os livros que a data de hoje já passou da data de devolução
            }
        }
        if (lateBooks.isEmpty()) { //se estiver vazio
            throw new BookException(BookException.NoLateBooks);
        } else {
            return lateBooks;
        }
    }

    public int quantityLateBooks() throws BookException { //retorna a quantidade de livros atrasados no momento
        if (lateBooks.isEmpty()) {
            throw new BookException(BookException.NoLateBooks);
        } else {
            return lateBooks.size();
        }
    }

    //RESERVED BOOKS
    public List<Book> generatesReservedBooks() { //retorna todos livros que tem alguém na fila de reserva no momento
        Map<String, Book> BookMap = books.getBookMap();
        for (Book book : BookMap.values()) {
            if (!book.getResevationQueue().isEmpty()) { //retorna true se a lista estiver vazia
                reservedBooks.add(book);
            }
        }
        return reservedBooks;
    }

    public int quantityReservedBooks() throws BookException { //retorna a quantidade de livros emprestados no momento
        if (reservedBooks.isEmpty()) { //retorna true se estiver vazia
            throw new BookException(BookException.NoReservedBooks);
        } else {
            return reservedBooks.size();
        }
    }

    //POPULAR BOOK
    public List<Book> generateBookHighestPopular() throws LoanException { //o livro que teve mais emprestimo
        int highestValue = 0;
        List<Book> bookPopular = null; //lista que vai armazenar o livro ou livros com maiores quantidade de emprestimo
        Map<String, Book> BookMap = books.getBookMap();
        for (Book book : BookMap.values()) {
            int value = book.getQuantityLoan();
            if (value == 0) {
                highestValue = 0;
            } else if (value >= highestValue) {
                highestValue = value; // Atualize o maior valor encontrado
                bookPopular.add(book);
            }
        }
        if (bookPopular == null) {
            throw new LoanException(LoanException.NoLoan);
        } else {
            return bookPopular;
        }
    } //retorna uma lista de livro, pois pode ter mais de um livro com a mesma quantidade de emprestimo, e essa quantidade ser a maior

    //LOAN HISTORY
    public List<Loan> genareteUserLoan(Reader reader) throws LoanException{ //passa para a função o leitor que você quer o historico de emprestimo
        List<Loan> loanHistory = null;
        Map<Long, Loan> LoanMap = loans.getLoanMap();
        Long idReader = reader.getId();
        for (Loan loan : LoanMap.values()) {
            if(idReader == loan.getIdUser()){
                loanHistory.add(loan);}
        }
        if(loanHistory==null){
            throw new LoanException(LoanException.NoUserLoan);}
        else{
            return loanHistory;}}
}


