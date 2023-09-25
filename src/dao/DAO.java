package dao;

import dao.Book.BookDAO;
import dao.Book.BookDaoImpl;
import dao.User.UserDAO;
import dao.User.UserDaoImpl;
import dao.Loan.LoanDAO;
import dao.Loan.LoanDAOImpl;
import dao.adm.AdmDAO;
import dao.adm.AdmDAOImpl;
import dao.librarian.LibrarianDAO;
import dao.librarian.LibrarianDAOImpl;

//os metodos get abaixo são para obter o objeto DAO para uma classe

public class DAO {
    private static BookDAO bookDAO;
    private static UserDAO userDAO;
    private static LoanDAO loanDAO;
    private static AdmDAO admDAO;
    private static LibrarianDAO librarianDAO;

    public static BookDAO getBookDAO(){
        if (bookDAO == null) {
            bookDAO = new BookDaoImpl();
        }
        return bookDAO;
    }

    public static UserDAO getUserDAO(){
        if (userDAO == null){
            userDAO = new UserDaoImpl();
        }
        return userDAO;
    }

    public static LoanDAO getLoanDAO() {
        if(loanDAO == null) {
            loanDAO = new LoanDAOImpl();
        }
        return loanDAO;
    }

    public static AdmDAO getAdmDAO() {
        if(admDAO == null) {
            admDAO = new AdmDAOImpl();
        }
        return admDAO;
    }
    
    public static LibrarianDAO librarianDAO() {
        if(librarianDAO == null) {
            librarianDAO = new LibrarianDAOImpl();
        }
        return librarianDAO;
    }
}
