package dao.Book;

import model.Book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookDaoImpl implements BookDAO {
    private final Map<Integer, Book> bookmap = new HashMap<>(); //map para gaurdar os livros numa estrutura Isbn:livro
    @Override
    public Book creat(Book livro){ //criando um livro e colocando no map
        int idbook = livro.getISBN(); //o id do livro vai ser o proprio isbn
        bookmap.put(idbook, livro);
        return livro;}

    @Override
    public List<Book> findAll() { //retorna uma lista de livros
        return new ArrayList<>(bookmap.values());}

    @Override
    public Book findById(int id) {  //retorna um livro pelo Id (lembrando q o id é o isbn)
        return bookmap.get(id);}

    @Override
    public Book update(Book livro) {
        bookmap.put(livro.getISBN(), livro);
        return null;}

    @Override
    public void delete(Book obj) {
        int id = obj.getISBN();
        bookmap.remove(id);}

    /*
    public Book findByTitle(String titulo) {
        for (Book livro : this.list) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                return livro;
            }
        }
        return null;
    }
    public Book findByAutor(String autor) {
        for (Book livro : this.list) {
            if (livro.getAutor().equalsIgnoreCase(autor)) {
                return livro;
            }
        }
        return null;
    }
    public Book findByCategoria(String categoria) {
        for (Book livro : this.list) {
            if (livro.getCategoria().equalsIgnoreCase(categoria)) {
                return livro;
            }
        }
        return null;
    }
    @Override
    public Book atualizar(Book livro) {
        int indice = list.indexOf(livro);
        this.list.set(indice, livro);
        return livro;
    }

    @Override
    public void apagar(Book livro) {
        this.list.remove(livro);
    }

    public void apagarTodos() {
        this.list.clear();
    }

     */
}
