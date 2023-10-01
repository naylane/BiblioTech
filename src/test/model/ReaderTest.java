package test.model;

import exceptions.BookException;
import exceptions.LoanException;
import exceptions.UsersException;
import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class ReaderTest {
    private Residence address;
    private Reader reader;
    private Book book;
    private LocalDate dateLoan;
    private LocalDate dateDevolution;

    @BeforeEach
    public void setUp() throws BookException {
        address = new Residence("Estado", "Cidade", "Bairro", "Rua", 62, "40000000");
        reader = new Reader("Nome do Leitor", "123", "xx xxxxx-xxxx", address);
        BookLocation location = new BookLocation("Estante", "Corredor", "Seção");
        book = new Book("ISBN123", "Título do Livro", "Autor do Livro","Editora", 2023, "Categoria", location, 1);
        dateLoan = LocalDate.now();
        dateDevolution = dateLoan.plusDays(10);
    }
    
    @Test
    public void testAreFinedWithExpiredFine() {
        reader.blockReader(reader); // definindo leitor previamente como bloqueado
        reader.setFineDeadline(LocalDate.now().minusDays(1)); // Data de vencimento expirada
        boolean isBlocked = reader.areFined(reader);

        assertFalse(isBlocked); // Deve retornar false após a chamada ao método
    }

    @Test
    public void testAreFinedWithValidFine() {
        reader.blockReader(reader); // definindo leitor previamente como bloqueado
        reader.setFineDeadline(LocalDate.now().plusDays(1)); // Data de vencimento futura
        boolean isBlocked = reader.areFined(reader);

        assertTrue(isBlocked); // Deve retornar true após a chamada ao método
    }

    @Test
    public void testAreFinedWithoutFine() {
        reader.setFineDeadline(null); // Sem data de vencimento da multa
        boolean isBlocked = reader.areFined(reader);

        assertFalse(isBlocked); // Deve retornar false após a chamada ao método
    }

    @Test
    public void testRenewFinalizedLoan() {
        Loan loan = new Loan(reader.getId(), book, dateLoan, dateDevolution);
        loan.setActive(false);

        try {
            reader.renewLoan(reader, loan, book);
        } catch (LoanException | UsersException e) {
            // Verifique se a exceção tem a mensagem correta.
            assertEquals(LoanException.FinalizedLoan, e.getMessage());
        }
    }

    @Test
    public void testRenewWithReservationQueue() {
        Loan loan = new Loan(1, book, dateLoan, dateDevolution);
        loan.setActive(true);

        // Garantindo que a fila não está vazia
        Reader r = new Reader("Nome", "Senha123", "xx xxxxx-xxxx", address);
        book.getResevationQueue().add(r);

        try {
            reader.renewLoan(reader, loan, book);
        } catch (Exception e) {
            assertEquals(LoanException.ContainsPeople, e.getMessage());
        }
    }

    @Test
    public void testRenewWithBlockedReader() {
        Loan loan = new Loan(1, book, dateLoan, dateDevolution);
        loan.setActive(true);

        reader.blockReader(reader); // Garantindo que o leitor está bloqueado

        try {
            reader.renewLoan(reader, loan, book);
        } catch (Exception e) {
            assertEquals(UsersException.UserBlock, e.getMessage());
        }
    }

    @Test
    public void testWithMaxRenewalsReached() {
        Loan loan = new Loan(1, book, dateLoan, dateDevolution);
        loan.setActive(true);
        loan.setRenovationQuantity(3); // Garantindo que o limite de renovações foi atingido
        try {
            reader.renewLoan(reader, loan, book);
        } catch (Exception e) {
            assertEquals(LoanException.RenewalExceeded, e.getMessage());
        }
    }
}
