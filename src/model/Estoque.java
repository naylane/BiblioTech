package model;

import dao.DAO;

import java.util.List;

public class Estoque {
    private int numLivros;

    public Estoque(int numLivros) {
        this.numLivros = numLivros;
    }

    public Livro addLivro(Livro novoLivro){
        return DAO.getLivroDAO().criar(novoLivro);
    }

    public void apagarLivro(Livro livro){
        DAO.getLivroDAO().apagar(livro);
    }

    public void apagarTodos(){
        DAO.getLivroDAO().apagarTodos();
    }

    public Livro atualizarLivro(Livro livro){
        return DAO.getLivroDAO().atualizar(livro);
    }

    public Livro getLivro(String isbn){
        return DAO.getLivroDAO().findByISBN(isbn);
    }

    public List<Livro> getLivros(){
        return DAO.getLivroDAO().encontrarTodos();
    }

}
