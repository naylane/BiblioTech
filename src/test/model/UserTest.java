package test.model;

import model.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    private Residence address;
    private User user;
    private BookLocation location;
    private Book book;

    @BeforeEach
    public void setUp() {
        // Configurando objetos para teste
        address = new Residence("Estado", "Cidade", "Bairro", "Rua", 62, 40000000);
        user = new User("Nome do Usuário", "Senha123", "xx xxxxx-xxxx", address);
        location = new BookLocation("Estante", "Corredor", "Seção");
        book = new Book("ISBN123", "Título do Livro", "Autor do Livro","Editora", 2023, "Categoria", location, 1);
        //DAO.getBookDAO().creat(book);
    }

    @Test
    public void testFindBookByIsbn() {
        //assertNotNull(DAO.getBookDAO().findById("9788595081512")); // verifica se é encontrado um livro pelo isbn
    }

    @Test
    public void testFindBookByTitle() {
        for (Book bookFound : user.searchBookByTitle("Título do Livro")) {
            assertEquals(bookFound.getTitle(), book.getTitle());
        }
    }

    @Test
    public void testFindByAuthor(){
        for (Book bookFound : user.searchBooksByAuthor("O Pequeno Príncipe")) {
            assertEquals(bookFound.getAuthor(), this.book.getAuthor());
        }
    }

    @Test
    public void testFindByCategory(){
        // verifica se o livro adicionando é o mesmo que foi encontrado pelo autor
        for (Book bookFound : user.searchBooksByCategory("Romance")) {
            assertEquals(bookFound.getCategory(), this.book.getCategory());
        }
    }
}
