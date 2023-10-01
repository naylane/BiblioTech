package test.dao;

import dao.DAO;
import dao.adm.AdmDAO;
import model.Adm;
import model.Residence;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.*;

public class AdmDAOTest {
    private AdmDAO admDAO;
    private Adm adm0;
    private Adm adm1;
    Residence address;

    @BeforeEach
    public void setUp() {
        admDAO = DAO.getAdmDAO();
        Residence address = new Residence("Estado", "Cidade", "Bairro", "Rua", 62, 40000000);
        adm0 = new Adm(0, "Nome do ADM 0", "Senha123", "xx xxxxx-xxxx", address);
        adm1 = new Adm(0, "Nome do ADM 1", "Senha456", "xx xxxxx-xxxx", address);
    }

    @AfterEach
    public void cleanDAO() {
        admDAO.deleteAll();
    }

    @Test
    public void testAddAdm() {
        admDAO.creat(adm0);

        assertFalse(admDAO.findAll().isEmpty()); // verifica se a lista de ADM's está vazia
    }

    @Test
    public void testFindAdm() {
        admDAO.creat(adm0);

        assertSame(adm0, admDAO.findById(0));
    }

    @Test
    public void testFindAll() {
        int qntBefore = admDAO.findAll().size();
        admDAO.creat(adm1); // Adicionando um adm
        int qntAfter = admDAO.findAll().size();

        assertTrue(qntAfter > qntBefore);
    }

    public void testUpdate() {
        // Adicionando um adm
        admDAO.creat(adm0);
        // Criando adm com informações diferentes ao adm 0
        Adm editedAdm = new Adm(0, "Nome Alterado", "Senha alterada", "xx xxxxx-xxxx", address);
        // Editando
        admDAO.update(editedAdm);

        assertNotEquals(adm0, admDAO.findById(0));
    }

    @Test
    public void testDelete() {
        // Adicionando dois ADMs na lista
        admDAO.creat(adm0);
        admDAO.creat(adm1);
        int qntBefore = admDAO.findAll().size();
        // Removendo um adm
        admDAO.delete(adm1);
        int qntAfter = admDAO.findAll().size();

        assertTrue(qntAfter < qntBefore);
    }

    @Test
    public void testDeleteAll() {
        admDAO.deleteAll();

        assertTrue(admDAO.findAll().isEmpty());
    }
}
