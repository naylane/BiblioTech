package model;
import dao.book.BookDaoImpl;
import exceptions.BookException;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Book {
    private String isbn;
    private String title;
    private String author;
    private String publishing_company;
    private int year_publication; // depois alterar para data
    private String category;
    private BookLocation location;
    private int quantityAvailable; //essa quantidade indica a quantidade desse livro disponivel em um dado momento
    private int quantityTotal;   //essa quantidade indica a quantidade desse livro total no sistema
    private Queue<Reader> reservationQueue = new LinkedList<>(); //Queue: fila em java
    //BookDaoImpl bookdaoimpl = new BookDaoImpl();

    public Book(String isbn, String title, String author, String publishing_company, int year_publication, String category, BookLocation location, int quantity) {
        //chekIsbn(isbn); //aq vai checar se já existe um livro com mesmo isbn no banco de dados
        //chekQuantity(quantity);
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publishing_company = publishing_company;
        this.year_publication = year_publication;
        this.category = category;
        this.location = location;
        this.quantityAvailable = quantity;
        this.quantityTotal = quantity;}
    /*
    public void chekIsbn(String isbn) throws BookException {
        if(bookdaoimpl.getBookMap() != null){
            if(bookdaoimpl.getBookMap().containsKey(isbn)){
                throw new BookException(BookException.AlreadyCreated);}}
        String isbnString = Long.toString(isbn); //para verificar s quantidade de numeros em um long precisa transforma em string
        int numberofDgits = isbnString.length();
        if(isbn == 0 || numberofDgits < 13){ //se o isbn for zero ou menor que 13 digitos, ele está incorreto
            throw new BookException(BookException.IsbnErro);}}

    public void chekQuantity(int quantity) throws BookException{
        if(quantity < 1){
            throw new BookException(BookException.QuantityErro);}
    }

     */
    public void addReservationQueue(Reader reader){  // Adicionando leitores à fila do livro
        reservationQueue.offer(reader);}
    public void removeReservationQueue(Reader reader){ // removendo leitores da fila
        reservationQueue.remove(reader);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishing_company() {
        return publishing_company;
    }

    public void setPublishing_company(String publishing_company) {
        this.publishing_company = publishing_company;
    }

    public String getISBN() {
        return isbn;
    }

    public void setISBN(String isbn) {
        this.isbn = isbn;
    }

    public int getYear_publication() {
        return year_publication;
    }

    public void setYear_publication(int year_publication) {
        this.year_publication = year_publication;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BookLocation getLocation() {
        return location;
    }

    public void setLocation(BookLocation location) {
        this.location = location;
    }
    
    public int getQuantityAvailable() {
        return quantityAvailable;
    }

    public void setQuantityAvailable(int quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    public int getQuantityTotal() {
        return quantityTotal;
    }

    public void setQuantityTotal(int quantityTotal) {
        this.quantityTotal = quantityTotal;
    }
    public Queue<Reader> getResevationQueue(){return reservationQueue;}

    public void setReservationQueue(Queue<Reader> list){this.reservationQueue = list;}
    
    @Override
    public String toString() {
        return "\n[BOOK]: " + title + "\n \n" +
                "-informations-" + '\n' +
                "autor:" + author + '\n' +
                "editora:" + publishing_company + '\n' +
                "isbn:" + isbn + '\n' +
                "ano de publicação:" + year_publication + '\n' +
                "categoria:" + category + '\n' +
                "localizacao:" + "corredor - " + location.getHall() + ", prateleira - " + location.getShelf() + ", sessao - " + location.getSection();
    }
}
