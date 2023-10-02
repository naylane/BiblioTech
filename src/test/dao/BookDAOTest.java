package test.dao;

import dao.DAO;
import exceptions.BookException;
import model.Book;
import model.BookLocation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BookDAOTest {
    private BookLocation location;
    private Book book;

    @BeforeEach
    public void setUp() throws BookException {
        location = new BookLocation("1", "4", "12");
        book = new Book("9788595081512","O Pequeno Príncipe", "Antoine de Saint-Exupéry",
                "HarperCollins", 2018, "Romance", location, 1);
    }

    @Test
    public void testAddBook() {
        DAO.getBookDAO().create(this.book);

        assertFalse(DAO.getBookDAO().findAll().isEmpty()); // verifica se a lista de livros está vazia
    }

    @Test
    public void testFindBookByIsbn() {
        assertNotNull(DAO.getBookDAO().findById("9788595081512")); // verifica se é encontrado um livro pelo isbn
    }

    @Test
    public void findBookByTitle() {
        // verifica se o livro adicionando é o mesmo que foi encontrado pelo título
        for (Book books : DAO.getBookDAO().findByTitle("O Pequeno Príncipe")) {
            assertEquals(books.getTitle(), this.book.getTitle());
        }
    }

    @Test
    public void findByAuthor(){
        // verifica se o livro adicionando é o mesmo que foi encontrado pelo autor
        for (Book books : DAO.getBookDAO().findByAuthor("Antoine de Saint-Exupéry")) {
            assertEquals(books.getAuthor(), this.book.getAuthor());
        }
    }

    @Test
    public void findByCategory(){
        // verifica se o livro adicionando é o mesmo que foi encontrado pelo autor
        for (Book books : DAO.getBookDAO().findByCategory("Romance")) {
            assertEquals(books.getCategory(), this.book.getCategory());
        }
    }

    @Test
    public void testUpdateBook() throws BookException {
        // CRIANDO LIVRO DIFERENTE
        Book alteredBook = new Book("9788595081512","O Pequeno Príncipe", "Antoine de Saint-Exupéry",
                "HarperCollins", 2018, "Romance", location, 2);

        // ATUALIZANDO
        DAO.getBookDAO().update(alteredBook);

        Book bookTest = DAO.getBookDAO().findById("9788595081512");

        assertNotEquals(this.book, bookTest); // asserta que os objetos são diferentes
    }

    @Test
    public void testDeleteBook() {
        DAO.getBookDAO().deleteAll();
        assertTrue(DAO.getBookDAO().findAll().isEmpty());
    }
}
