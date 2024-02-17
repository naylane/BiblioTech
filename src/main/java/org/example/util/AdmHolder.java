package org.example.util;

import org.example.model.Adm;

public class AdmHolder {
    private static AdmHolder instance;
    private Adm adm;

    private AdmHolder(Adm adm) {
        this.adm = adm;
    }

    public static AdmHolder getInstance() {
        if (instance == null) {
            instance = new AdmHolder(null);
        }
        return instance;
    }

    public void setAdm(Adm adm) {
        this.adm = adm;
    }

    public Adm getAdm() {
        return this.adm;
    }

}