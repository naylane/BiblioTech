package test;

import dao.DAO;
import model.BookLocation;
import model.Librarian;
import model.Residence;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

public class LibrarianTest {
    // CRIANDO BILIOTECARIO
    Residence address = new Residence("Bahia", "Feira de Santana", "Feira VI", "A", 14,44000000);
    Librarian librarian = new Librarian(1, "Mônica", "123", "75982854278", address);

    @Test
    public void testRegisterBook() {
        // REGISTRANDO LIVRO
        BookLocation location = new BookLocation("1", "4", "12");
        librarian.registerBook("9788595081512","O Pequeno Príncipe", "Antoine de Saint-Exupéry",
                "HarperCollins", 2018, "Romance", location, 4);

        assertNotNull(DAO.getBookDAO().findById("9788595081512")); // verifica se o pesquisar por id retorna o livro cadastrado
    }

    @Test
    public void testRegisterDuplicateBook() {
        // REGISTRANDO LIVRO
        BookLocation location = new BookLocation("1", "4", "12");
        librarian.registerBook("9788595081512","O Pequeno Príncipe", "Antoine de Saint-Exupéry",
                "HarperCollins", 2018, "Romance", location, 1);

        // REGISTRANDO LIVRO IGUAL COM QUANTIDADE DIFERENTE
        librarian.registerBook("9788595081512","O Pequeno Príncipe", "Antoine de Saint-Exupéry",
                "HarperCollins", 2018, "Romance", location, 5);

        assertSame(6, DAO.getBookDAO().findById("9788595081512").getQuantityAvailable());
    }

}
