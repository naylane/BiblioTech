package model;

/**
 * Esta classe contém atributos para armazenar o endereço de
 * um usuario. Portanto ela contém os atributos de um
 * endereço como rua, cidade, bairro, rua, cep e numero.
 * Além disso, ela contém um construtor para criar o
 * objeto e métodos getters e setters para pegar e alterar
 * os atributos privados.
 *
 * @author Sara Souza e Naylane Ribeiro
 */
public class Residence {
    private String state;
    private String city;
    private String neighborhood; //bairro
    private String street;
    private int number;
    private String cep;
    /**
     * Construtor da classe Residence.
     *
     * @param state       O estado do endereço.
     * @param city        A cidade do endereço.
     * @param neighborhood O bairro do endereço.
     * @param street      A rua do endereço.
     * @param number      O número do endereço.
     * @param cep         O CEP do endereço.
     */
    public Residence(String state, String city, String neighborhood, String street, int number, String cep){
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
    public String getCep() {
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
    public void setCep(String cep) {
        this.cep = cep;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s, %s, %d, %s\n", state, city, neighborhood, street, number, cep);
    }
}
