package model;

import java.time.LocalDate;
import java.util.List;

import static dao.DAO.bookDAO;

public class User {
    private String name;
    private int id = 0;
    private String pin;
    private int age;
    private int phone;
    private LocalDate registration_date;
    private Residence address;
    public User(String name, int id, String pin, int age, int phone, LocalDate registration_date, Residence address){  //construtor
        this.name = name;
        this.id = id;  //esse id é alterado posteriomente nas classes que criam um user
        this.pin = pin;
        this.age = age;
        this.phone = phone;
        this.registration_date = registration_date;
        this.address = address;
    }
    // Métodos Get
    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }
    public String getPin() {
        return pin;
    }
    public int getAge() {
        return age;
    }
    public int getPhone() {
        return phone;
    }
    public LocalDate getRegistration_date() {
        return registration_date;
    }
    public Residence getAddress() {
        return address;
    }
    // Métodos Set
    public void setName(String name) {
        this.name = name;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setPin(String pin) {
        this.pin = pin;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setPhone(int phone) {
        this.phone = phone;
    }
    public void setRegistration_date(LocalDate registration_date) {
        this.registration_date = registration_date;
    }
    public void setAddress(Residence address) {
        this.address = address;
    }
    @Override
    public String toString() {
        return "[User]: " + id + "\n -Informations-\n" + "name: " + name + "age: " + age + "phone: " + phone;
    }
    //o metodo equals visa verificar se os pins de dois objetos são iguais
    public boolean equals(Object o){
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        User user = (User) o;
        return id == user.id;}
    //abaixo tem as pesquisas que o usuario pode fazer
    public List<Book> search_Bookbytitle(String title){
        // Chama o método de pesquisa por título no DAO de livros
        return bookDAO.findByTitulo(title);}
    public List<Book> searchBooksByAutor(String autor) {
        // Chama o método de pesquisa por autor no DAO de livros
        return bookDAO.findByAutor(autor);}
    public List<Book> searchBooksByCategoria(String categoria) {
        // Chama o método de pesquisa por categoria no DAO de livros
        return bookDAO.findByCategoria(categoria);}
}

