package dao.adm;

import model.Adm;
import model.Librarian;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdmDAOImpl implements AdmDAO {
    private final Map<Long, Adm> admMap = new HashMap<>();
    private long nextId = 0;

    private long getNextId() {
        /*
         * A++ -> usa o valor de A e depois incrementa A
         * ++A -> incrementa o valor de A e depois utiliza o valor de A
         */
        return this.nextId++; // retorna ID para o objeto atual e define o próximo ID
    }

    @Override
    public Adm creat(Adm obj){
        obj.setId(getNextId());
        admMap.put(obj.getId(), obj);
        return obj;
    }

    @Override
    public List<Adm> findAll() {
        return new ArrayList<>(admMap.values());
    }

    @Override
    public Adm findById(long id) {
        return admMap.get(id);
    }

    @Override
    public Adm update(Adm obj) {
        admMap.put(obj.getId(), obj);
        return null;
    }

    @Override
    public void delete(Adm obj) {
        long id = obj.getId();
        admMap.remove(id);
    }

    @Override
    public void deleteAll() {
        admMap.clear();
    }

    @Override
    public void deleteAll() {
        admMap.clear();}
}
