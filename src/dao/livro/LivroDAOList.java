package dao.livro;

import model.Livro;

import java.util.ArrayList;
import java.util.List;

public class LivroDAOList implements LivroDAO {
    private List<Livro> lista;

    public LivroDAOList(){
        this.lista = new ArrayList<>();
    }

    @Override
    public Livro criar(Livro livro) {
        this.lista.add(livro);
        return livro;
    }

    @Override
    public List<Livro> encontrarTodos() {
        return this.lista;
    }

    @Override
    public Livro encontrarPorId(int id) {
        return null;
    }

    public Livro findByTitulo(String titulo) {
        for (Livro livro : this.lista) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                return livro;
            }
        }
        return null;
    }

    public Livro findByAutor(String autor) {
        for (Livro livro : this.lista) {
            if (livro.getAutor().equalsIgnoreCase(autor)) {
                return livro;
            }
        }
        return null;
    }

    public Livro findByISBN(String isbn) {
        for (Livro livro : this.lista) {
            if (livro.getISBN().equalsIgnoreCase(isbn)) {
                return livro;
            }
        }
        return null;
    }

    public Livro findByCategoria(String categoria) {
        for (Livro livro : this.lista) {
            if (livro.getCategoria().equalsIgnoreCase(categoria)) {
                return livro;
            }
        }
        return null;
    }

    @Override
    public Livro atualizar(Livro livro) {
        int indice = lista.indexOf(livro);
        this.lista.set(indice, livro);
        return livro;
    }

    @Override
    public void apagar(Livro livro) {
        this.lista.remove(livro);
    }

    public void apagarTodos() {
        this.lista.clear();
    }

}
