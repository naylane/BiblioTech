package dao;

import org.example.dao.DAO;
import org.example.exceptions.BookException;
import org.example.model.Book;
import org.example.model.BookLocation;
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
    public void testAddBook() throws Exception {
        DAO.getBookDAO().create(this.book);

        assertFalse(DAO.getBookDAO().findAll().isEmpty()); // verifica se a lista de livros está vazia
    }

    @Test
    public void testFailAddBook() throws BookException {
        try {
            Book booktest = new Book("9788595081512", "O Pequeno Príncipe", "Antoine de Saint-Exupéry",
                    "HarperCollins", 2018, "Romance", location, 0);
            fail("Uma exceção deveria ser gerada!!");
        }catch (BookException e){
            assertEquals(BookException.QuantityErro, e.getMessage());
        }
    }

    @Test
    public void testFindBookByIsbn() throws Exception {
        assertNotNull(DAO.getBookDAO().findByIsbn("9788595081512")); // verifica se é encontrado um livro pelo isbn
    }

    @Test
    public void findBookByTitle() throws Exception {
        // verifica se o livro adicionando é o mesmo que foi encontrado pelo título
        for (Book books : DAO.getBookDAO().findByTitle("O Pequeno Príncipe")) {
            assertEquals(books.getTitle(), this.book.getTitle());
        }
    }

    @Test
    public void findByAuthor() throws Exception {
        // verifica se o livro adicionando é o mesmo que foi encontrado pelo autor
        for (Book books : DAO.getBookDAO().findByAuthor("Antoine de Saint-Exupéry")) {
            assertEquals(books.getAuthor(), this.book.getAuthor());
        }
    }

    @Test
    public void findByCategory() throws Exception {
        // verifica se o livro adicionando é o mesmo que foi encontrado pelo autor
        for (Book books : DAO.getBookDAO().findByCategory("Romance")) {
            assertEquals(books.getCategory(), this.book.getCategory());
        }
    }

    @Test
    public void testUpdateBook() throws Exception {
        // CRIANDO LIVRO DIFERENTE
        Book alteredBook = new Book("9788595081512","O Pequeno Príncipe", "Antoine de Saint-Exupéry",
                "HarperCollins", 2018, "Romance", location, 2);

        // ATUALIZANDO
        DAO.getBookDAO().update(alteredBook);

        Book bookTest = DAO.getBookDAO().findByIsbn("9788595081512");

        assertNotEquals(this.book, bookTest); // asserta que os objetos são diferentes
    }

    @Test
    public void testDeleteBook() throws Exception {
        DAO.getBookDAO().deleteAll();
        assertTrue(DAO.getBookDAO().findAll().isEmpty());
    }
}
