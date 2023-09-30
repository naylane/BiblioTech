package dao.librarian;

import dao.CRUD;
import model.Librarian;

import java.util.Map;

public interface LibrarianDAO extends CRUD<Librarian> {
    public long getNextId();
    public Map<Long, Librarian> getLibrarianMap();
}