package model;
import java.util.Date;

public class Reader extends User{  //leitor
    public Boolean block;
    //public List<Emprestimo> loan_history;
    // Construtor para a classe Reader
    public Reader(String name, String id, String pin, int age, int phone, Date registration_date, Residence address, Boolean block) {
        super(name, id, pin, age, phone, registration_date, address, block);
        this.block = block;
    }
    public void reserve_book(Reader reader, Book book){ //queue - fila
        book.addReservationQueue(reader); //colocando leitor na fila para reservar o livro
    }
    public void renew_loan(){ //faltar ser construido
    }
    public void update_history(){ //faltar ser construido
    }
}
