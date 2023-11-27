package dao.book;

import model.Book;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookDaoImpl implements BookDAO {
    private HashMap<String, Book> bookMap;

    public BookDAOImpl() {
        this.bookMap = FileControl.loadBook();}

    @Override
    public Book create(Book book) {
        bookMap.put(reader.getIsbn(), book);
        FileControl.saveBook(this.bookMap);
        return book;
    }

    @Override
    public List<Book> findAll() { //retorna a lista de todos livros em bookmap
        return new ArrayList<>(bookMap.values());}

    @Override
    public Book findById(String id) {  //retorna um livro pelo Id (lembrando q o id é o isbn)
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
}
