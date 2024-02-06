package org.example.dao.librarian;

import org.example.dao.CRUD;
import org.example.model.Librarian;

import java.util.Map;

public interface LibrarianDAO extends CRUD<Librarian> {
    public long getNextId();
    public Map<Long, Librarian> getLibrarianMap();
}