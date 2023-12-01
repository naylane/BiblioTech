package dao.adm;

import dao.FileControl;
import model.Adm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AdmDAOImpl implements AdmDAO {
    private HashMap<Long, Adm> admMap;
    private long nextId;

    public AdmDAOImpl() throws Exception {
        this.admMap = FileControl.loadAdm(); //recupa os dados
        this.nextId = admMap.size(); //vê o tamanho do map para encontrar o prox ID
    }

    public long getNextId() {
        /*
         * A++ -> usa o valor de A e depois incrementa A
         * ++A -> incrementa o valor de A e depois utiliza o valor de A
         */
        return this.nextId++; // retorna ID para o objeto atual e define o próximo ID
    }

    public HashMap<Long, Adm> getAdmMap() { return admMap; }

    @Override
    public Adm create(Adm adm) {
        adm.setId(getNextId());
        admMap.put(adm.getId(), adm);
        FileControl.saveAdm(this.admMap);
        return adm;
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
        FileControl.saveAdm(this.admMap);
        return null;
    }

    @Override
    public void delete(Adm obj) {
        long id = obj.getId();
        admMap.remove(id);
        FileControl.saveAdm(this.admMap);
    }
    @Override
    public void deleteAll() {
        
        admMap.clear();
        FileControl.saveAdm(this.admMap);
    }
}
