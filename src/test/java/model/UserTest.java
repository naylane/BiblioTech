package model;

import org.example.dao.DAO;
import org.example.exceptions.BookException;
import org.example.model.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    private User user;
    private Book book;

    @BeforeEach
    public void setUp() throws BookException, IOException {
        // Configurando objetos para teste
        Residence address = new Residence("Estado", "Cidade", "Bairro", "Rua", 62, "40000000");
        user = new User("Nome do Usuário", "Senha123", "xx xxxxx-xxxx", address);
        BookLocation location = new BookLocation("Estante", "Corredor", "Seção");
        book = new Book("ISBN123", "Título do Livro", "Autor do Livro","Editora", 2023, "Categoria", location, 1);
        try {
            DAO.getBookDAO().create(book);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testFindBookByIsbn() throws Exception {
        assertNotNull(user.searchBookByIsbn("ISBN123")); // verifica se é encontrado um livro pelo isbn
    }

    @Test
    public void testFindBookByTitle() {
        for (Book bookFound : user.searchBookByTitle("Título do Livro")) {
            assertEquals(bookFound.getTitle(), book.getTitle());
        }
    }

    @Test
    public void testFindByAuthor(){
        for (Book bookFound : user.searchBooksByAuthor("Autor do Livro")) {
            assertEquals(bookFound.getAuthor(), this.book.getAuthor());
        }
    }

    @Test
    public void testFindByCategory() {
        // verifica se o livro adicionando é o mesmo que foi encontrado pelo autor
        for (Book bookFound : user.searchBooksByCategory("Categoria")) {
            assertEquals(bookFound.getCategory(), this.book.getCategory());
        }
    }
}
