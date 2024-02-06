package org.example.dao.reader;

import org.example.dao.FileControl;
import org.example.model.Reader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ReaderDAOImpl implements ReaderDAO {
    private HashMap<Long, Reader> readerMap;
    private long nextId;

    public ReaderDAOImpl() throws Exception {
        this.readerMap = FileControl.loadReader();
        this.nextId = readerMap.size();
    }

    public long getNextId() {
        /*
         * A++ -> usa o valor de A e depois incrementa A
         * ++A -> incrementa o valor de A e depois utiliza o valor de A
         */
        return this.nextId++;
    }

    @Override
    public Reader create(Reader reader) {
        reader.setId(getNextId());
        readerMap.put(reader.getId(), reader);
        FileControl.saveReader(this.readerMap);
        return reader;
    }

    @Override
    public List<Reader> findAll() {
        return new ArrayList<>(readerMap.values());
    }

    @Override
    public Reader findById(long id) {
        return readerMap.get(id);
    }

    @Override
    public Reader update(Reader reader) {
        readerMap.put(reader.getId(), reader);
        FileControl.saveReader(this.readerMap);
        return reader;
    }

    @Override
    public void delete(Reader reader) {
        readerMap.remove(reader.getId());
        FileControl.saveReader(this.readerMap);
    }

    @Override
    public void deleteAll() {
        readerMap.clear();
        FileControl.saveReader(this.readerMap);
    }

    public HashMap<Long, Reader> getReaderMap() {
        return readerMap;
    }
}