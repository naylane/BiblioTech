package dao.livro;

import dao.CRUD;
import model.Livro;

public interface LivroDAO extends CRUD<Livro> {
    public void apagarTodos();

    public Livro findByISBN(String isbn);

    public Livro findByTitulo(String titulo);

    public Livro findByAutor(String autor);

    public Livro findByCategoria(String categoria);
}