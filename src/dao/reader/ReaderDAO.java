package dao.reader;

import dao.CRUD;
import model.Reader;

import java.util.Map;

public interface ReaderDAO extends CRUD<Reader> {
    public Map<Long, Reader> getReaderMap();
    public long getNextId();
}


