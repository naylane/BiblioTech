package dao.Reader;

import model.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReaderDAOImpl implements ReaderDAO {
    private final Map<Integer, Reader> readerMap = new HashMap<>();

    @Override
    public Reader creat(Reader reader) {
        int id = reader.getId();
        readerMap.put(id, reader);
        return reader;
    }

    @Override
    public List<Reader> findAll() {
        return new ArrayList<>(readerMap.values());
    }

    @Override
    public Reader findById(int id) {
        return readerMap.get(id);
    }

    @Override
    public Reader update(Reader reader) {
        readerMap.put(reader.getId(), reader);
        return reader;
    }

    @Override
    public void delete(Reader reader) {
        readerMap.remove(reader.getId());
    }

    @Override
    public void deleteAll() {
        readerMap.clear();
    }

}