package dao.book;

import dao.FileControl;
import exceptions.UsersException;
import model.Adm;
import model.Book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BookDaoImpl implements BookDAO {
    private HashMap<String, Book> bookMap;

    public void BookDAOImpl() throws UsersException {
        this.bookMap = FileControl.loadBook();
    }

    @Override
    public Book create(Book book) {
        bookMap.put(book.getISBN(), book);
        FileControl.saveBook(this.bookMap);
        return book;
    }

    @Override
    public List<Book> findAll() { //retorna a lista de todos livros em bookmap
        return new ArrayList<>(bookMap.values());}

    @Override
    public Book findById(long id) {
        return null;
    }

    @Override
    public Book findByIsbn(String id) {  //retorna um livro pelo Id (lembrando q o id é o isbn)
        return bookMap.get(id);}

    @Override
    public Book update(Book obj) {
        bookMap.put(obj.getISBN(), obj);
        FileControl.saveBook(this.bookMap);
        return null;}

    @Override
    public void delete(Book obj) {
        String id = obj.getISBN();
        bookMap.remove(id);
        FileControl.saveBook(this.bookMap);
    }

    public void deleteAll(){
        bookMap.clear();
        FileControl.saveBook(this.bookMap);//a função clear vai apagar tudo no bookmap
    }

    //as funções de pesquisas abaixo vão iterar pelo map e criar uma lista de livro de acordo com oq se pesquisa.
    public List<Book> findByTitle(String title) {
        List<Book> result = new ArrayList<>();
        for (Book book : bookMap.values()) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                result.add(book);
            }
        }
        return result;
    }

    public List<Book> findByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : bookMap.values()) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                result.add(book);
            }
        }
        return result;
    }

    public List<Book> findByCategory(String category) {
        List<Book> result = new ArrayList<>();
        for (Book book : bookMap.values()) {
            if (book.getCategory().equalsIgnoreCase(category)) {
                result.add(book);
            }
        }
        return result;
    }

    public long quantityBooks(){ return (long)bookMap.size();} //retorna a quantidade de livros

    public HashMap<String, Book> getBookMap() { return bookMap; }

}
