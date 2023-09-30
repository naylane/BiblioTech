package dao.reader;

import model.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReaderDAOImpl implements ReaderDAO {
    private final Map<Long, Reader> readerMap = new HashMap<>();
    private long nextId = 0;

    public long getNextId() {
        /*
         * A++ -> usa o valor de A e depois incrementa A
         * ++A -> incrementa o valor de A e depois utiliza o valor de A
         */
        return this.nextId++; // retorna ID para o objeto atual e define o próximo ID
    }

    @Override
    public Reader creat(Reader obj){
        obj.setId(getNextId());
        readerMap.put(obj.getId(), obj);
        return obj;
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
    public Reader update(Reader obj) {
        readerMap.put(obj.getId(), obj);
        return obj;
    }

    @Override
    public void delete(Reader obj) {
        readerMap.remove(obj.getId());
    }

    @Override
    public void deleteAll() {
        readerMap.clear();
    }

    public Map<Long, Reader> getReaderMap() { //pega o banco de dados com todos leitores cadastrados
        return readerMap;}
}