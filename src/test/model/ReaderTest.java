package test.model;

import exceptions.LoanException;
import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class ReaderTest {
    private Residence address;
    private Reader reader;
    private BookLocation location;
    private Book book;
    private LocalDate dateLoan;
    private LocalDate dateDevolution;

    @BeforeEach
    public void setUp() {
        address = new Residence("Estado", "Cidade", "Bairro", "Rua", 62, 40000000);
        reader = new Reader(1, "Nome do Leitor", "123", "xx xxxxx-xxxx", address);
        location = new BookLocation("Estante", "Corredor", "Seção");
        book = new Book("ISBN123", "Título do Livro", "Autor do Livro","Editora", 2023, "Categoria", location, 1);
        dateLoan = LocalDate.now();
        dateDevolution = dateLoan.plusDays(10);
    }
    
    @Test
    public void testAreFinedWithExpiredFine() {
        reader.blockReader(reader); // definindo leitor previamente como bloqueado
        reader.fineDeadline = LocalDate.now().minusDays(1); // Data de vencimento expirada
        boolean isBlocked = reader.areFined(reader);

        assertFalse(isBlocked); // Deve retornar false após a chamada ao método
    }

    @Test
    public void testAreFinedWithValidFine() {
        reader.blockReader(reader); // definindo leitor previamente como bloqueado
        reader.fineDeadline = LocalDate.now().plusDays(1); // Data de vencimento futura
        boolean isBlocked = reader.areFined(reader);

        assertTrue(isBlocked); // Deve retornar true após a chamada ao método
    }

    @Test
    public void testAreFinedWithoutFine() {
        reader.fineDeadline = null; // Sem data de vencimento da multa
        boolean isBlocked = reader.areFined(reader);

        assertFalse(isBlocked); // Deve retornar false após a chamada ao método
    }

    @Test
    public void testRenewFinalizedLoan() throws LoanException {
        Loan loan = new Loan(1, 1, book, dateLoan, dateDevolution);
        loan.setActive(false);

        try {
            reader.renewLoan(reader, loan, book);
        } catch (LoanException e) {
            // Verifique se a exceção tem a mensagem correta.
            assertEquals(LoanException.FinalizedLoan, e.getMessage());
        }
    }

    @Test
    public void testRenewWithReservationQueue() {
        Loan loan = new Loan(1, 1, book, dateLoan, dateDevolution);
        loan.setActive(true);

        // Garantindo que a fila não está vazia
        Reader r = new Reader(2, "Nome", "Senha123", "xx xxxxx-xxxx", address);
        book.getResevationQueue().add(r);

        try {
            reader.renewLoan(reader,loan, book);
        } catch (Exception e) {
            assertEquals(LoanException.ContainsPeople, e.getMessage());
        }
    }

    @Test
    public void testRenewWithBlockedReader() {
        Loan loan = new Loan(1, 1, book, dateLoan, dateDevolution);
        loan.setActive(true);

        reader.blockReader(reader); // Garantindo que o leitor está bloqueado

        try {
            reader.renewLoan(reader, loan, book);
        } catch (Exception e) {
            assertEquals(LoanException.UserBlock, e.getMessage());
        }
    }

    @Test
    public void testWithMaxRenewalsReached() {
        Loan loan = new Loan(1, 1, book, dateLoan, dateDevolution);
        loan.setActive(true);
        loan.setRenovationQuantity(3); // Garantindo que o limite de renovações foi atingido
        try {
            reader.renewLoan(reader, loan, book);
        } catch (Exception e) {
            assertEquals(LoanException.RenewalExceeded, e.getMessage());
        }
    }
}
