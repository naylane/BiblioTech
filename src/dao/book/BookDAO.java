package dao.book;

import dao.CRUD;
import model.Book;

import java.util.HashMap;
import java.util.List;

public interface BookDAO extends CRUD<Book> {
    public long quantityBooks();
    public List<Book> findByTitle(String title);
    public List<Book> findByAuthor(String author);
    public List<Book> findByCategory(String categoria);
    public Book findByIsbn(String id);
    public HashMap<String, Book> getBookMap();

}