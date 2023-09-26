package dao;

import dao.Book.BookDAO;
import dao.Book.BookDaoImpl;
import dao.User.UserDAO;
import dao.User.UserDaoImpl;
import dao.Loan.LoanDAO;
import dao.Loan.LoanDAOImpl;
//A classe DAO é um ponto de entrada para acessar os objetos DAO das classes específicas de domínio.
//O objetivo é facilitar o acesso a esses objetos e tornar o código mais legível e fácil de manter.
//O uso da classe DAO torna esse código mais legível e fácil de manter. Não é necessário saber como o
//objeto DAO é implementado. Você só precisa saber que pode usá-lo para acessar os dados do cliente.
public class DAO {
    public static BookDAO bookDAO;
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
