package model;

import dao.DAO;
import java.util.List;

public class Stock {
    private int numBooks;

    public Stock(int numBooks) {
        this.numBooks = numBooks;
    }

    public Book addBook(Book newBook){
        return DAO.getBookDAO().creat(newBook);
    }

    public void deleteBook(Book book){
        DAO.getBookDAO().delete(book);
    }

    /*
    public void deleteAll(){ // não implementado
        DAO.getBookDAO().apagarTodos();
    */

    public Book updateBook(Book book){
        return DAO.getBookDAO().update(book);
    }

    public Book getBook(int isbn){
        return DAO.getBookDAO().findById(isbn);
    }

    public List<Book> getBooks(){
        return DAO.getBookDAO().findAll();
    }

}
