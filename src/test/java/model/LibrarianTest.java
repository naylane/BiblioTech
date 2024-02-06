package model;

import org.example.dao.DAO;
import org.example.model.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

public class LibrarianTest {
    private Residence address;
    private Librarian librarian;
    private Reader reader;
    private BookLocation location;
    private Book book;

    @BeforeEach
    public void setUp() throws Exception {
        // Configurando objetos para teste
        address = new Residence("Estado", "Cidade", "Bairro", "Rua", 62, "40000000");
        librarian = new Librarian("Nome do Bibliotecário", "1234", "123-456-7890", address);
        reader = new Reader("Nome do Leitor", "5678", "75 98765-3210", address);
        location = new BookLocation("Estante", "Corredor", "Seção");
        book = new Book("ISBN123", "Título do Livro", "Autor do Livro","Editora", 2023, "Categoria", location, 1);
    }

    @Test
    public void testRegisterBook() throws Exception {
        librarian.registerBook("9788595081512","O Pequeno Príncipe", "Antoine de Saint-Exupéry",
                "HarperCollins", 2018, "Romance", location, 4);

        assertNotNull(DAO.getBookDAO().findByIsbn("9788595081512")); // verifica se o pesquisar por id retorna o livro cadastrado
    }

    @Test
    public void testRegisterDuplicateBook() throws Exception {
        librarian.registerBook("9788595081512","O Pequeno Príncipe", "Antoine de Saint-Exupéry",
                "HarperCollins", 2018, "Romance", location, 1);

        // Registrando livro igual com quantidade diferente
        librarian.registerBook("9788595081512","O Pequeno Príncipe", "Antoine de Saint-Exupéry",
                "HarperCollins", 2018, "Romance", location, 5);

        assertSame(6, DAO.getBookDAO().findByIsbn("9788595081512").getQuantityAvailable());
    }

    @Test
    public void testRegisterLoan() throws Exception {
        // Garantindo que o livro está disponível
        book.setQuantityAvailable(1);
        // Garantindo de que o leitor não está bloqueado
        reader.setBlock(false);
        // Bibliotecário registra o empréstimo
        librarian.registerLoan(reader, book);

        assertEquals(0, book.getQuantityAvailable()); // verificando que o livro não está mais disponível
    }

    @Test
    public void testRegisterDevolution() {
        // Configurando um empréstimo ativo
        Loan activeLoan = new Loan(reader.getId(), book, LocalDate.now(), LocalDate.now().plusDays(10));
        activeLoan.setActive(true);
        book.setQuantityAvailable(book.getQuantityAvailable() - 1);

        librarian.registerDevolution(activeLoan, reader);

        assertFalse(activeLoan.getActive()); // Verificando que o empréstimo não está mais ativo
    }
}
