package dao.librarian;

import model.Librarian;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibrarianDAOImpl implements LibrarianDAO {
    private final Map<Long, Librarian> librarianMap = new HashMap<>();
    private long nextId = 0;

    private long getNextId() {
        /**
         * A++ -> usa o valor de A e depois incrementa A
         * ++A -> incrementa o valor de A e depois utiliza o valor de A
         */
        return this.nextId++; // retorna ID para o objeto atual e define o próximo ID
    }

    @Override
    public Librarian creat(Librarian obj){
        obj.setId(getNextId());
        librarianMap.put(obj.getId(), obj);
        return obj;
    }

    @Override
    public List<Librarian> findAll() {
        return new ArrayList<>(librarianMap.values());
    }

    @Override
    public Librarian findById(long id) {
        return librarianMap.get(id);
    }

    @Override
    public Librarian update(Librarian obj) {
        librarianMap.put(obj.getId(), obj);
        return null;
    }

    @Override
    public void delete(Librarian obj) {
        long id = obj.getId();
        librarianMap.remove(id);
    }

    @Override
    public void deleteAll() {
        librarianMap.clear();
    }
}
