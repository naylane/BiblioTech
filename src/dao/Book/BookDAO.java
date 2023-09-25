package dao.Book;

import dao.CRUD;
import model.Book;

import java.util.List;

public interface BookDAO extends CRUD<Book> {
    //pode pesquisar o livro por: titulo, autor, isbn e categoria. Obs: pesquisar por isbn é o mesmo que pesquisar por ID
    public List<Book> findByTitulo(String titulo);
    public List<Book> findByAutor(String autor);
    public List<Book> findByCategoria(String categoria);

}