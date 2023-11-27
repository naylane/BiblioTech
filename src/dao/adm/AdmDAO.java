package dao.adm;

import dao.CRUD;
import model.Adm;

import java.util.HashMap;

public interface AdmDAO extends CRUD<Adm> {
    public long getNextId();
    public HashMap<Long, Adm> getAdmMap();
}
