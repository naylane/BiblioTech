package model;

import java.util.Date;

public class Adm extends Librarian {
    public Adm(String name, String pin, String s, int age, int phone, Date registration_date, Residence address, Boolean block) {
        super(name, pin, s, age, phone, registration_date, address, block);

        //tem q criar a classe para criar usuarios
    }
}
