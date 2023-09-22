package model;
import java.time.LocalDate;
import java.util.Date;

public class Reader extends User{  //leitor
    public Boolean block;
    public LocalDate fineDeadline;
    //public List<Emprestimo> loan_history;

    // Construtor para a classe Reader
    public Reader(String name, String id, String pin, int age, int phone, Date registration_date, Residence address, Boolean block) {
        super(name, id, pin, age, phone, registration_date, address, block);
        this.block = block;
        this.fineDeadline = null;
    }

    public void reserve_book(Reader reader, Book book){ //queue - fila
        book.addReservationQueue(reader); //colocando leitor na fila para reservar o livro
    }

    public void renew_loan(){ //faltar ser construido
    }

    public void update_history(){ //faltar ser construido
    }

    /**
     * Método que verifica se um leitor está com multa ativa.
     * @param reader leitor
     * @return boolean referente ao leitor estar bloqueado ou não
     */
    public boolean areFined(Reader reader) {
        LocalDate now = LocalDate.now();
        if (now.isAfter(reader.fineDeadline)) { // se o dia atual é depois do prazo da multa
            reader.block = false; // leitor é desbloqueado
            reader.fineDeadline = null; // retira a data referente a multa
        }
        return reader.block;
    }
}
