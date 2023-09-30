package model;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Esta classe contém atributos para armazenar os
 * dados de um livro. Portanto ela contém os atributos
 * de um livro como nome, isbn, autor, ano de publicação
 * categoria, localização na biblioteca, quantidade total
 * de livros desse tipo, quantidade no momento de livros
 * desse tipo, uma fila de reserva e quantidade de vezes
 * que aquele livro já teve emprestimo. Além disso, ela
 * contém um construtor para criar o objeto e métodos getters
 * e setters para pegar e alterar os atributos privados.
 * Contém outros métodos uteis para classe livro como
 * entrar e sair da fila de reserva.
 *
 * @author Sara Souza e Naylane Ribeiro
 */
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
    private int quantityLoan=0; //quantidade de emprestimos

    /**
     * Construtor da classe Book para criar um novo livro.
     *
     * @param isbn              O número ISBN do livro.
     * @param title             O título do livro.
     * @param author            O autor do livro.
     * @param publishing_company A editora do livro.
     * @param year_publication  O ano de publicação do livro.
     * @param category          A categoria à qual o livro pertence.
     * @param location          O local onde o livro está armazenado.
     * @param quantity          A quantidade inicial de cópias disponíveis do livro.
     */
    public Book(String isbn, String title, String author, String publishing_company, int year_publication, String category, BookLocation location, int quantity) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publishing_company = publishing_company;
        this.year_publication = year_publication;
        this.category = category;
        this.location = location;
        this.quantityAvailable = quantity;
        this.quantityTotal = quantity;}

    /**
     * Adiciona um leitor à fila de reserva deste livro.
     *
     * @param reader O leitor a ser adicionado à fila de reserva.
     */
    public void addReservationQueue(Reader reader){  // Adicionando leitores à fila do livro
        reservationQueue.offer(reader);}

    /**
     * Remove um leitor da fila de reserva deste livro.
     *
     * @param reader O leitor a ser removido da fila de reserva.
     */
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
    public int getQuantityLoan() {
        return quantityLoan;
    }
    public void setQuantityLoan(int quantityLoan) {
        this.quantityLoan += quantityLoan;
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
