package dao;

import dao.livro.LivroDAO;
import dao.livro.LivroDAOList;

public class DAO {
    private static LivroDAO livroDAO;

    public static LivroDAO getLivroDAO(){
        if (livroDAO == null) {
            livroDAO = new LivroDAOList();
        }
        return livroDAO;
    }

}
