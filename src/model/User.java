package model;
import java.util.Date;
public class User {
    private String name;
    private int id;
    private String pin;
    private int age;
    private int phone;
    private Date registration_date;
    private Residence address;
    private Boolean block; // diz se o user está bloqueado ou não: false - não e true - sim
    public User(String name, String pin, String s, int age, int phone, Date registration_date, Residence address, Boolean block){  //construtor
        this.name = name;
        this.id = -1;  //esse id é alterado na classe UserDAOimpl
        this.pin = pin;
        this.age = age;
        this.phone = phone;
        this.registration_date = registration_date;
        this.address = address;
        this.block = false;

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
    public Date getRegistration_date() {
        return registration_date;
    }
    public Residence getAddress() {
        return address;
    }
    public String getBlock(){
        if(block){ //block == true
            return "Blocked";
        }else{
            return "active";}}
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
    public void setRegistration_date(Date registration_date) {
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
    public void block_User(User user){
        user.block = true;}
    public void unlock_User(User user){
        user.block = false;}
    public void search_Book(){ // a fazer
    }
}

