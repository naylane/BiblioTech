package dao;

import dao.adm.AdmDAO;
import dao.adm.AdmDAOImpl;
import dao.Book.BookDAO;
import dao.Book.BookDaoImpl;
import dao.librarian.LibrarianDAO;
import dao.librarian.LibrarianDAOImpl;
import dao.Reader.ReaderDAO;
import dao.Reader.ReaderDAOImpl;
import dao.Loan.LoanDAO;
import dao.Loan.LoanDAOImpl;

//A classe DAO é um ponto de entrada para acessar os objetos DAO das classes específicas de domínio.
//O objetivo é facilitar o acesso a esses objetos e tornar o código mais legível e fácil de manter.
//O uso da classe DAO torna esse código mais legível e fácil de manter. Não é necessário saber como o
//objeto DAO é implementado. Você só precisa saber que pode usá-lo para acessar os dados do cliente.

public class DAO {
    public static BookDAO bookDAO;
    private static LoanDAO loanDAO;
    private static LibrarianDAO librarianDAO;
    private static AdmDAO admDAO;
    private static ReaderDAO readerDAO;

    public static BookDAO getBookDAO(){
        if (bookDAO == null) {
            bookDAO = new BookDaoImpl();
        }
        return bookDAO;
    }

    public static LoanDAO getLoanDAO() {
        if(loanDAO == null) {
            loanDAO = new LoanDAOImpl();
        }
        return loanDAO;
    }

    public static LibrarianDAO getLibrarianDAO() {
        if(librarianDAO == null) {
            librarianDAO = new LibrarianDAOImpl();
        }
        return librarianDAO;
    }

    public static ReaderDAO getReaderDAO(){
        if(readerDAO == null){
            readerDAO = new ReaderDAOImpl();
        }
        return readerDAO;
    }

    public static AdmDAO getAdmDAO(){
        if (admDAO == null){
            admDAO = new AdmDAOImpl();
        }
        return admDAO;
    }

}
