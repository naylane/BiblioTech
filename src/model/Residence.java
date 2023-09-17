package model;

public class Residence {
    private String state;
    private String city;
    private String neighborhood; //bairro
    private String street;
    private int number;
    private int cep;
    // Construtor
    public Residence(String state, String city, String neighborhood, String street, int number, int cep) {
        this.state = state;
        this.city = city;
        this.neighborhood = neighborhood;
        this.street = street;
        this.number = number;
        this.cep = cep;}
    // Métodos Get
    public String getState() {
        return state;
    }
    public String getCity() {
        return city;
    }
    public String getNeighborhood() {
        return neighborhood;
    }
    public String getStreet() {
        return street;
    }
    public int getNumber() {
        return number;
    }
    public int getCep() {
        return cep;
    }
    // Métodos Set
    public void setState(String state) {
        this.state = state;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public void setCep(int cep) {
        this.cep = cep;
    }
}
