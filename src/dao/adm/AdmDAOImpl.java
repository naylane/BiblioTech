package dao.adm;

import model.Adm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdmDAOImpl implements AdmDAO {
    private final Map<Integer, Adm> admMap = new HashMap<>();

    @Override
    public Adm creat(Adm adm) {
        int id = adm.getId();
        admMap.put(id, adm);
        return adm;
    }

    @Override
    public List<Adm> findAll() {
        return new ArrayList<>(admMap.values());
    }

    @Override
    public Adm findById(int id) {
        return admMap.get(id);
    }

    @Override
    public Adm update(Adm adm) {
        admMap.put(adm.getId(), adm);
        return adm;
    }

    @Override
    public void delete(Adm obj) {
    }
}
