package dao.Book;

import dao.CRUD;
import model.Book;

import java.util.List;

public interface BookDAO extends CRUD<Book> {
    //pode pesquisar o livro por: titulo, autor, isbn e categoria. Obs: pesquisar por isbn é o mesmo que pesquisar por ID
    public List<Book> findByTitle(String title);
    public List<Book> findByAuthor(String author);
    public List<Book> findByCategory(String categoria);

}