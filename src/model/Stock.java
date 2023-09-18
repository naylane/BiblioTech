package model;

import dao.DAO;

import java.util.List;

public class Stock {
    private int numLivros;
    public Stock(int numLivros) {
        this.numLivros = numLivros;
    }
    public Book addLivro(Book newbook){
        return DAO.getBookDAO().creat(newbook);
    }
    public void apagarLivro(Book book){
        DAO.getBookDAO().update(book);
    }
    /*
    public void apagarTodos(){
        DAO.getBookDAO().apagarTodos();
    */
    public Book atualizarLivro(Book book){
        return DAO.getBookDAO().update(book);
    }
    /*
    public Book getLivro(int isbn){
        return DAO.getBookDAO().findByISBN(isbn);
    }

    public List<Book> getLivros(){
        return DAO.getBookDAO().encontrarTodos();
    }
     */
}
