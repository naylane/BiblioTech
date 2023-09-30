package model;

import java.util.List;

import static dao.DAO.bookDAO;

public class User {
    private long id;
    private String name;
    private String pin;
    private String phone;
    private Residence address;

    public User(long id, String name, String pin, String phone, Residence address){
        this.id = id;
        this.name = name;
        this.pin = pin;
        this.phone = phone;
        this.address = address;
    }

    // Métodos Get
    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public String getPin() {
        return pin;
    }

    public String getPhone() {
        return phone;
    }

    public Residence getAddress() {
        return address;
    }

    // Métodos Set

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(Residence address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "[User]: " + id + "\n -Informations-\n" + "name: " + name  + "phone: " + phone;
    }

    // o metodo equals visa verificar se os pins de dois objetos são iguais
    public boolean equals(Object o){
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        User user = (User) o;
        return id == user.id;
    }

    // abaixo tem as pesquisas que o usuario pode fazer

    public List<Book> searchBookbytitle(String title){
        // Chama o método de pesquisa por título no DAO de livros
        return bookDAO.findByTitle(title);
    }

    public List<Book> searchBooksByAuthor(String author) {
        // Chama o método de pesquisa por autor no DAO de livros
        return bookDAO.findByAuthor(author);
    }

    public List<Book> searchBooksByCategory(String category) {
        // Chama o método de pesquisa por categoria no DAO de livros
        return bookDAO.findByCategory(category);
    }
}
