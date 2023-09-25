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
    public List<Book> findAll() { //retorna a lista de todos livros em bookmap
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

    public void deleteAll(){
        bookmap.clear(); //a função clear vai apagar tudo no bookmap
    }
    //as funções de pesquisas abaixo vão iterar pelo map e criar uma lista de livro de acordo com oq se pesquisa.
    public List<Book> findByTitulo(String title) {
        List<Book> result = new ArrayList<>();
        for (Book livro : bookmap.values()) {
            if (livro.getTitle().equalsIgnoreCase(title)) {
                result.add(livro);
            }
        }
        return result;
    }

    public List<Book> findByAutor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book livro : bookmap.values()) {
            if (livro.getAuthor().equalsIgnoreCase(author)) {
                result.add(livro);
            }
        }
        return result;
    }

    public List<Book> findByCategoria(String category) {
        List<Book> result = new ArrayList<>();
        for (Book livro : bookmap.values()) {
            if (livro.getCategory().equalsIgnoreCase(category)) {
                result.add(livro);
            }
        }
        return result;
    }
}
