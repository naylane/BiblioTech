package model;

public class Book {
    private int isbn;
    private String title;
    private String author;
    private String publishing_company;
    private int year_publication; // depois alterar para data
    private String category;
    private BookLocation location;
    private int quantity;
    //private List<User> filaReserva;

    public Book(int isbn, String titulo, String autor, String editora, int anoDePubli, String categoria, BookLocation localizacao, int quantidade) {
        this.isbn = isbn;
        this.title = titulo;
        this.author = autor;
        this.publishing_company = editora;
        this.year_publication = anoDePubli;
        this.category = categoria;
        this.location = localizacao;
        this.quantity = quantidade;
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

    public int getISBN() {
        return isbn;
    }

    public void setISBN(int isbn) {
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

    public void alterarTitulo(){

    }
    public void alterarAutor(){

    }
    public void alterarEditora(){

    }
    public void alterarIsbn(){

    }
    public void alterarAnoDePubli(){

    }
    public void alterarCategoria(){

    }
    @Override
    public String toString() {
        return "\n[BOOK]: " + title + "\n \n" +
                "-informations-" + '\n' +
                "autor:" + author + '\n' +
                "editora:" + publishing_company + '\n' +
                "isbn:" + isbn + '\n' +
                "ano de publicação:" + year_publication + '\n' +
                "categoria:" + category + '\n' +
                "localizacao:" + "corredor - " + location.getCorredor() + ", prateleira - " + location.getPrateleira() + ", sessao - " + location.getSessao();
    }
}
