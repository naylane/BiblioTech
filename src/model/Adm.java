package model;

import java.time.LocalDate;

public class Adm extends Librarian {
    public Adm(String name, String pin, String s, int age, int phone, LocalDate registration_date, Residence address) {
        super(name, pin, s, age, phone, registration_date, address);

        //tem q criar a classe para criar usuarios
    }
}
