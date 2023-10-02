package test.model;

import dao.DAO;
import dao.book.BookDAO;
import dao.loan.LoanDAO;
import model.*;
import exceptions.BookException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ReportTest {
    private final Report report = new Report();
    private BookDAO bookDAO;
    private Book book0;
    private Book book1;
    private Book book2;
    private Reader reader;

    @BeforeEach
    public void setUp() throws BookException {
        // Configurando objetos para teste
        bookDAO = report.getBooks();

        Residence address = new Residence("Estado", "Cidade", "Bairro", "Rua", 62, "40000000");
        reader = new Reader("Nome do Leitor", "5678", "75 98765-3210", address);
        DAO.getReaderDAO().create(reader);

        BookLocation location = new BookLocation("Estante", "Corredor", "Seção");
        book0 = new Book("ISBN123", "Título do Livro 0", "Autor do Livro","Editora", 2023, "Categoria", location, 1);
        book1 = new Book("ISBN456", "Título do Livro 1", "Autor do Livro","Editora", 2023, "Categoria", location, 1);
        book2 = new Book("ISBN789", "Título do Livro 2", "Autor do Livro","Editora", 2023, "Categoria", location, 1);
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
    public void testGeneratesBorrowedBooks() {
        // Armazenando livros na lista de livros emprestados
        report.storesBorrowedBooks(book0);
        report.storesBorrowedBooks(book1);
        report.storesBorrowedBooks(book2);

        List list = report.generatesBorrowedBooks(); // Não lança exceção pois a lista não está vazia
        assertEquals(3, list.size()); // Verificando que os livros estão sendo armazendados
    }

    @Test
    public void testHighestPopularBookWithManyBooks() {  // Teste com vários livros
        book0.setQuantityLoan(2);
        book1.setQuantityLoan(9);
        book2.setQuantityLoan(0);

        bookDAO.create(book0);
        bookDAO.create(book1);
        bookDAO.create(book2);

        assertTrue(report.generateBookHighestPopular().contains(book1));
    }

    @Test
    public void testHighestPopularBookWithManyBooksAndZeroLoan() {  // Teste com todos os livros com quantidade de empréstimos igual a zero
        book0.setQuantityLoan(0);
        book1.setQuantityLoan(0);
        book2.setQuantityLoan(0);

        bookDAO.create(book0);
        bookDAO.create(book1);
        bookDAO.create(book2);

        assertTrue(report.generateBookHighestPopular().isEmpty()); // Lista dos mais populares deve estar vazia
    }

    @Test
    public void testGenerateUserLoanSuccess() {
        LoanDAO loanDAO = report.getLoans();

        LocalDate dateLoan = LocalDate.now();
        LocalDate dateDevolution = dateLoan.plusDays(10);
        Loan loan0 = new Loan(reader.getId(), book0, dateLoan, dateDevolution);
        Loan loan1 = new Loan(reader.getId(), book1, dateLoan, dateDevolution);
        Loan loan2 = new Loan(2, book2, dateLoan, dateDevolution); // Empréstimo não relacionado ao leitor

        loanDAO.create(loan0);
        loanDAO.create(loan1);
        loanDAO.create(loan2);

        List<Loan> userLoans = report.genareteUserLoan(reader);

        assertEquals(2, userLoans.size()); // Verifica se a lista contém 2 empréstimos.
    }
}
