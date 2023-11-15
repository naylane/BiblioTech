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
    private final Map<String, Book> bookMap = new HashMap<>(); //map para gaurdar os livros numa estrutura Isbn:livro
    public Map<String, Book> getBookMap() { //para retornar o banco de dados com todos livros cadastrados em  formato map
        return bookMap;
    }

    public long quantityBooks(){ return (long)bookMap.size();} //retorna a quantidade de livros


    public void saveBooksToCSV()  {
        String csvBooks = "./data/books.csv"; //File's name
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvBooks))) {
            for (Map.Entry<String, Book> entry : bookMap.entrySet()) {
                Book book = entry.getValue();
                String line = String.format("%s,%s,%s,%s,%d,%s,%s,%d\n",
                        book.getISBN(),
                        book.getTitle(),
                        book.getAuthor(),
                        book.getPublishing_company(),
                        book.getYear_publication(),
                        book.getCategory(),
                        book.getLocation().toString(), // pega o to String do BookLocation
                        book.getQuantityTotal());
                writer.write(line);}
                System.out.println("Dados foram escritos no arquivo CSV.");
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public long QuantityBooks(){ return (long)bookMap.size();} //retorna a quantidade de livros
    @Override
    public Book create(Book obj) throws IOException { //criando um livro e colocando no map
        String id = obj.getISBN(); //o id do livro vai ser o proprio isbn
        bookMap.put(id, obj);
        saveBooksToCSV();
        return obj;
    }

    @Override
    public List<Book> findAll() { //retorna a lista de todos livros em bookmap
        return new ArrayList<>(bookMap.values());}

    @Override
    public Book findById(long id) { //não vai ser utilizavél aqui
        return null;
    }

    @Override
    public Book findById(String id) {  //retorna um livro pelo Id (lembrando q o id é o isbn)
        return bookMap.get(id);}

    @Override
    public Book update(Book obj) {
        bookMap.put(obj.getISBN(), obj);
        return null;}

    @Override
    public void delete(Book obj) {
        String id = obj.getISBN();
        bookMap.remove(id);}

    public void deleteAll(){
        bookMap.clear(); //a função clear vai apagar tudo no bookmap
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
}
