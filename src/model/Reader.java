package model;
import java.util.Date;

public class Reader extends User{  //leitor
    public Boolean block;
    //public List<Emprestimo> loan_history;
    // Construtor para a classe Reader
    public Reader(String name, String id, String pin, int age, int phone, Date registration_date, Residence address, Boolean block) {
        super(name, id, pin, age, phone, registration_date, address);
        this.block = block;
    }
    public int reserve_book(){ //faltar ser construido
        return 1;};
    public void renew_loan(){ //faltar ser construido
    }
    public void update_history(){ //faltar ser construido
    }
}
