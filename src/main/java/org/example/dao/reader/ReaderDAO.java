package org.example.dao.reader;

import org.example.dao.CRUD;
import org.example.model.Reader;

import java.util.Map;

public interface ReaderDAO extends CRUD<Reader> {
    public Map<Long, Reader> getReaderMap();
    public long getNextId();
}
