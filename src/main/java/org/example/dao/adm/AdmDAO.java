package org.example.dao.adm;

import org.example.dao.CRUD;
import org.example.model.Adm;

import java.util.HashMap;

public interface AdmDAO extends CRUD<Adm> {
    public long getNextId();
    public HashMap<Long, Adm> getAdmMap();
}
