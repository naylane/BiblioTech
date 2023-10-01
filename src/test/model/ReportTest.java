package test.model;

import exceptions.LoanException;
import model.*;
import exceptions.BookException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

public class ReportTest {
    private Report report = new Report();
    private Book book0;
    private Book book1;
    private Book book2;
    private Reader reader;
    private Loan loan;

    @BeforeEach
    public void setUp() {
        // Configurando objetos para teste
        Residence address = new Residence("Estado", "Cidade", "Bairro", "Rua", 62, 40000000);
        //librarian = new Librarian(1, "Nome do Bibliotecário", "1234", "123-456-7890", address);
        reader = new Reader(2, "Nome do Leitor", "5678", "75 98765-3210", address);

        BookLocation location = new BookLocation("Estante", "Corredor", "Seção");
        book0 = new Book("ISBN123", "Título do Livro", "Autor do Livro","Editora", 2023, "Categoria", location, 1);
        book1 = new Book("ISBN456", "Título do Livro", "Autor do Livro","Editora", 2023, "Categoria", location, 1);
        book2 = new Book("ISBN789", "Título do Livro", "Autor do Livro","Editora", 2023, "Categoria", location, 1);

        LocalDate dateLoan = LocalDate.now();
        LocalDate dateDevolution = dateLoan.plusDays(10);
        loan = new Loan(7, 23, book0, dateLoan, dateDevolution);
    }

    @Test
    public void testStoresBorrowedBooks() {
        int qntBefore = report.quantityBorrowedBooks();
        report.storesBorrowedBooks(book0);
        int qntAfter = report.quantityBorrowedBooks();

        assertTrue(qntAfter > qntBefore); // Verifica que a quantidade após adicionar o livro é maior
    }

    @Test
    public void takeOutBorrowedBook() {
        // Armazenando dois livros na lista de livros emprestados
        report.storesBorrowedBooks(book0);
        report.storesBorrowedBooks(book1);
        int qntBefore = report.quantityBorrowedBooks();
        // Retirando um livro da lista de livros emprestados
        report.takeOutBorrowedBook(book0);
        int qntAfter = report.quantityBorrowedBooks();

        assertTrue(qntAfter < qntBefore);  // Verifica que a quantidade após adicionar o livro é menor
    }

    @Test
    public void testNegativeQuantityBorrowedBooks() {
        // Armazenando um livro na lista de livros emprestados
        report.storesBorrowedBooks(book0);
        // Retirando o livro da lista de livros emprestados
        report.takeOutBorrowedBook(book0);

        int qnt = report.quantityBorrowedBooks();

        assertTrue(qnt >= 0); // Verifica que a quantidade não fica negativa
    }

    @Test
    public void testGeneratesBorrowedBooks() throws BookException {
        // Armazenando livros na lista de livros emprestados
        report.storesBorrowedBooks(book0);
        report.storesBorrowedBooks(book1);
        report.storesBorrowedBooks(book2);

        List list = report.generatesBorrowedBooks(); // Não lança exceção pois a lista não está vazia
        assertTrue(list.size() == 3); // Verificando que os livros estão sendo armazendados
    }

    @Test
    public void testGeneratesBorrowedBooksListIsEmpty() throws BookException {
        try {
            report.generatesBorrowedBooks();
        } catch (Exception e) {
            // Verifique se a exceção tem a mensagem correta.
            assertEquals(BookException.NoBorrowedBooks, e.getMessage());
        }
    }

    //public List<Book> generateBookHighestPopular() throws LoanException

    @Test
    public void genareteUserLoan() throws LoanException {
        report.genareteUserLoan(reader);
    }
}
