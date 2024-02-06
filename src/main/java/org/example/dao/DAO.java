package org.example.dao;

import org.example.dao.adm.AdmDAO;
import org.example.dao.adm.AdmDAOImpl;
import org.example.dao.book.BookDAO;
import org.example.dao.book.BookDAOImpl;
import org.example.dao.librarian.LibrarianDAO;
import org.example.dao.librarian.LibrarianDAOImpl;
import org.example.dao.reader.ReaderDAO;
import org.example.dao.reader.ReaderDAOImpl;
import org.example.dao.loan.LoanDAO;
import org.example.dao.loan.LoanDAOImpl;


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

    public static BookDAO getBookDAO() throws Exception {
        if (bookDAO == null) {
            bookDAO = new BookDAOImpl();
        }
        return bookDAO;
    }

    public static LoanDAO getLoanDAO() throws Exception {
        if(loanDAO == null) {
            loanDAO = new LoanDAOImpl();
        }
        return loanDAO;
    }

    public static LibrarianDAO getLibrarianDAO() throws Exception {
        if(librarianDAO == null) {
            librarianDAO = new LibrarianDAOImpl();
        }
        return librarianDAO;
    }

    public static ReaderDAO getReaderDAO() throws Exception {
        if(readerDAO == null){
            readerDAO = new ReaderDAOImpl();
        }
        return readerDAO;
    }

    public static AdmDAO getAdmDAO() throws Exception {
        if (admDAO == null){
            admDAO = new AdmDAOImpl();
        }
        return admDAO;
    }
}
