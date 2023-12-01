package test.dao;

import dao.reader.ReaderDAOImpl;
import exceptions.UsersException;
import model.Reader;
import model.Residence;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ReaderDAOTest {
    private ReaderDAOImpl readerDAO = new ReaderDAOImpl();
    private Reader reader1;
    private Reader reader2;
    private Reader reader3;
    Residence address;

    public ReaderDAOTest() throws Exception {
    }

    @BeforeEach
    public void setUp(){
        address = new Residence("Estado", "Cidade", "Bairro", "Rua", 62, "40000000");
        reader1 = new Reader("Nome do leitor 1", "senha123","xx xxxxx-xxxx", address);
        reader2 = new Reader("Nome do leitor 1", "senha345","xx xxxxx-xxxx", address);
        reader3 = new Reader("Nome do leitor 1", "senha678","xx xxxxx-xxxx", address);
    }

    @AfterEach
    public void cleanDAO() {
        readerDAO.deleteAll();
    }

    @Test
    public void testAddReader() {
        readerDAO.create(reader1);
        Reader readerExpected = readerDAO.findById(reader1.getId());
        assertEquals(reader1, readerExpected);
    }

    @Test
    public void testFindReader() {
        readerDAO.create(reader1);
        assertSame(reader1, readerDAO.findById(reader1.getId()));
    }

    @Test
    public void testFindAll() {
        readerDAO.create(reader1);
        readerDAO.create(reader2);
        readerDAO.create(reader3);

        assertEquals(3, readerDAO.findAll().size());
    }

    @Test
    public void testUpdate() {
        readerDAO.create(reader1);

        Reader editedReader = new Reader("Nome Alterado", "Senha alterada", "xx xxxxx-xxxx", address);
        readerDAO.update(editedReader);

        assertEquals(reader1, readerDAO.findById(reader1.getId()));
    }

    @Test
    public void testDelete() {
        readerDAO.create(reader1);
        readerDAO.create(reader2);

        int qntBefore = readerDAO.findAll().size();
        readerDAO.delete(reader1);
        int qntAfter = readerDAO.findAll().size();

        assertTrue(qntAfter < qntBefore);
    }

    @Test
    public void testDeleteAll() {
        readerDAO.deleteAll();
        assertTrue(readerDAO.findAll().isEmpty());
    }

}
