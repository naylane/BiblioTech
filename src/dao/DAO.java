package dao;

import dao.Book.BookDAO;
import dao.Book.BookDaoImpl;
import dao.User.UserDAO;
import dao.User.UserDaoImpl;
import dao.Loan.LoanDAO;
import dao.Loan.LoanDAOImpl;
//os metodos get abaixo são para obter o objeto DAO para uma classe
public class DAO {
    private static BookDAO bookDAO;
    private static UserDAO userDAO;
    private static LoanDAO loanDAO;

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

}
