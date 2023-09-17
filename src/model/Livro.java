package model;

import java.util.List;

public class Livro {
    private String isbn;
    private String titulo;
    private String autor;
    private String editora;
    private String anoDePubli; // depois alterar para data
    private String categoria;
    private LocalLivro localizacao;
    private int quantidade;
    private List<Usuario> filaReserva;

    public Livro(String isbn, String titulo, String autor, String editora, String anoDePubli, String categoria, LocalLivro localizacao, int quantidade) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.anoDePubli = anoDePubli;
        this.categoria = categoria;
        this.localizacao = localizacao;
        this.quantidade = quantidade;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getISBN() {
        return isbn;
    }

    public void setISBN(String isbn) {
        this.isbn = isbn;
    }

    public String getAnoDePubli() {
        return anoDePubli;
    }

    public void setAnoDePubli(String anoDePubli) {
        this.anoDePubli = anoDePubli;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public LocalLivro getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(LocalLivro localizacao) {
        this.localizacao = localizacao;
    }

    public int getQuantidade(){
        return quantidade;
    }

    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
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
        return "model.Livro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", editora='" + editora + '\'' +
                ", isbn='" + isbn + '\'' +
                ", ano de publicação='" + anoDePubli + '\'' +
                ", categoria='" + categoria + '\'' +
                ", localizacao='" + localizacao + '\'' +
                '}';
    }
}
