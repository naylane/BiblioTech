package model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Reader extends User {
    public Boolean block; // diz se o leitor está bloqueado ou não: false - não e true - sim
    public LocalDate fineDeadline;
    //public List<Emprestimo> loan_history;

    // Construtor para a classe Reader
    public Reader(String name, String id, String pin, int age, int phone, LocalDate registration_date, Residence address) {
        super(name, id, pin, age, phone, registration_date, address);
        this.block = block;
        this.fineDeadline = null;}
    public String getBlock(){
        if(block){ //block == true
            return "Blocked";
        }else{
            return "Active";}}
    public void block_reader(Reader reader){
        reader.block = true;}
    public void unlock_reader(Reader reader){
        reader.block = false;}
    /**
     * Método que realiza a devolução de um empréstimo, se o mesmo estiver ativo, e multa o leitor se a data de devolução passa da data esperada.
     * @param loan empréstimo
     * @param reader leitor
     */
    public void giveBack(Loan loan, Reader reader) {
        if(loan.getActive()) {
            // verificar se a data de devolução condiz com o esperado
            LocalDate now = LocalDate.now();
            if (now.isAfter(loan.getDateDevolution())) { // se a data de devolução passou do esperado
                // leitor é multado
                long days = ChronoUnit.DAYS.between(loan.getDateDevolution(), now) * 2; // dobro de dias de atraso
                reader.fineDeadline = LocalDate.now().plusDays(days);
                reader.block = true;
            }
            // devolve o livro
            loan.setActive(false); // mudando o estado de ativo do emprestimo para falso
            Book book = loan.getBook();
            book.setQuantity(book.getQuantity() + 1); // atualizando a quantidade de determinado livro disponível
        }
    }

    /*public void renew_loan(Loan loan) throws BlockException {

        if (loan.getBook().getReservationQueue().isEmpty()) { // caso a fila de reserva esteja vazia
            loan.setRenovationQuantity(loan.getRenovationQuantity() + 1); // atualizando a quantidade de renovações
            loan.setDateDevolution();
        }
    }*/

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
