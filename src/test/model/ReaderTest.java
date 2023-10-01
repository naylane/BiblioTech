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
        reader = new Reader(2, "Nome do Leitor", "123", "xx xxxxx-xxxx", address);
        location = new BookLocation("Estante", "Corredor", "Seção");
        book = new Book("ISBN123", "Título do Livro", "Autor do Livro","Editora", 2023, "Categoria", location, 1);
        dateLoan = LocalDate.now();
        dateDevolution = dateLoan.plusDays(10);
    }

    // Caso de teste com multa vencida
    @Test
    public void testAreFinedWithExpiredFine() {
        reader.blockReader(reader); // definindo leitor previamente como bloqueado
        reader.fineDeadline = LocalDate.now().minusDays(1); // Data de vencimento expirada
        boolean isBlocked = reader.areFined(reader);

        assertFalse(isBlocked); // Deve retornar false após a chamada ao método
    }

    // Caso de teste com multa válida
    @Test
    public void testAreFinedWithValidFine() {
        reader.blockReader(reader); // definindo leitor previamente como bloqueado
        reader.fineDeadline = LocalDate.now().plusDays(1); // Data de vencimento futura
        boolean isBlocked = reader.areFined(reader);

        assertTrue(isBlocked); // Deve retornar true após a chamada ao método
    }

    // Caso de teste do leitor sem multa
    @Test
    public void testAreFinedWithoutFine() {
        reader.fineDeadline = null; // Sem data de vencimento da multa
        boolean isBlocked = reader.areFined(reader);

        assertFalse(isBlocked); // Deve retornar false após a chamada ao método
    }

    // Teste com um empréstimo finalizado
    @Test
    public void renewFinalizedLoan() throws LoanException {
        Loan loan = new Loan(1, 1, book, dateLoan, dateDevolution, 0);

    }

    // Teste com uma fila de reserva vazia
    @Test
    public void testRenewWithEmptyReservationQueue() {

    }

    // Teste com um leitor bloqueado
    @Test
    public void testRenewWithBlockedReader() {

    }

    // Teste com quantidade máxima de renovações atingida
    @Test
    public void testWithMaxRenewalsReached() {

    }

}
