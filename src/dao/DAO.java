package dao;

import dao.adm.AdmDAO;
import dao.adm.AdmDAOImpl;
import dao.book.BookDAO;
import dao.book.BookDaoImpl;
import dao.librarian.LibrarianDAO;
import dao.librarian.LibrarianDAOImpl;
import dao.reader.ReaderDAO;
import dao.reader.ReaderDAOImpl;
import dao.loan.LoanDAO;
import dao.loan.LoanDAOImpl;
import dao.report.ReportDAO;
import dao.report.ReportDAOImpl;
import exceptions.LoanException;
import exceptions.UsersException;

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
    private static ReportDAO reportDAO;

    public static BookDAO getBookDAO(){
        if (bookDAO == null) {
            bookDAO = new BookDaoImpl();
        }
        return bookDAO;
    }

    public static LoanDAO getLoanDAO() throws LoanException {
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

    public static ReaderDAO getReaderDAO() throws UsersException {
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

    public static ReportDAO getReportDAO() throws Exception {
        if (reportDAO == null){
            reportDAO = new ReportDAOImpl();
        }
        return reportDAO;
    }
}
