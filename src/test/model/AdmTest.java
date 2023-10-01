package test.model;

import dao.DAO;
import model.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

public class AdmTest {
    Residence address = new Residence("Bahia", "Feira de Santana", "Feira VI", "A", 14,"44000000");
    Adm adm = new Adm("Nome do Adm", "123", "75 94002-8922", address);

    @Test
    public void registerReader() {
        // ADM REGISTRA O LEITOR
        Reader reader = adm.creatReader("Fernanda", "7752", "75 9 0000-0000", address);

        assertSame(reader, DAO.getReaderDAO().findById(reader.getId())); // ASSERTE QUE EXISTE UM LEITOR IDÊNTICO AO CRIADO PELO ADM
    }

    @Test
    public void registerLibrarian() {
        // ADM REGISTRA O BIBLIOTECÁRIO
        Librarian librarian = adm.creatLibrariam("Felipe", "81472", "75 9 0000-0000", address);

        assertSame(librarian, DAO.getLibrarianDAO().findById(librarian.getId())); // ASSERTE QUE EXISTE UM BIBLIOTECÁRIO IDÊNTICO AO CRIADO PELO ADM
    }

    @Test
    public void registerAdm() {
        // ADM REGISTRA UM ADM
        Adm newAdm = adm.creatAdm("Otávio", "97420", "75 9 0000-0000", address);

        assertSame(newAdm, DAO.getAdmDAO().findById(newAdm.getId())); // ASSERTE QUE EXISTE UM ADM IDÊNTICO AO CRIADO PELO ADM
    }
}
