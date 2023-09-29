package model;

import dao.reader.ReaderDAOImpl;
import exceptions.BookException;
import exceptions.LoanException;

import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Reader extends User {

    ReaderDAOImpl readerDAO = new ReaderDAOImpl(); //se quiser usar as opreções do DAO, uma das formas é criar um objeto
    public Boolean block; // diz se o leitor está bloqueado ou não: false - não e true - sim
    public LocalDate fineDeadline; //data final que o leitor está bloqueado
    //public List<Emprestimo> loan_history;

    public Reader(long id, String name, String pin, String phone, Residence address) { //construtor reader
        super(id, name, pin, phone, address);
        this.fineDeadline = null;
    }

    public Boolean getBlock(){
        if(block){ //block == true
            return true;
        }else{
            return false;}}

    public void blockReader(Reader reader){
        reader.block = true;}

    public void unlockReader(Reader reader){
        reader.block = false;}

    public void updateHistory(){ //faltar ser construido
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
    /**
     * Método que adiciona um leitor a fila de reserva de determinado livro.
     * @param reader leitor
     * @param book livro
     **/
    public void makeReservation(Reader reader, Book book) throws BookException { //verefica se tem livro disponivel
        if(book.getQuantityAvailable() > 0){
            throw new BookException(BookException.Available); //logo, vc pode ir fazer o emprestimo com o bibliotecario
        }
        else{
            book.addReservationQueue(reader); }} //entra na fila de reserva
    /**
     * Método que retira um leitor a fila de reserva de determinado livro.
     * @param reader leitor
     * @param book livro
     **/
    public void removeToQueue(Reader reader, Book book){
        book.removeReservationQueue(reader); //tirando leitor da fila para reservar o livro
    }
    public LocalDate dateEnd(LocalDate date){ //data final com prazo de 10 dias
        return date.plusDays(10);}
    public void renewLoan(Loan loan, Book book) throws LoanException {
        Reader reader = readerDAO.findById(loan.getIdUser()); //retorna o leitor do banco de dados de acordo com o Id
        if(!loan.getActive()){ //se for falso
            throw new LoanException(LoanException.FinalizedLoan);}
        else if(book.getResevationQueue().isEmpty()){ //se contém elementos na fila, logo contém pessoas
            throw new LoanException(LoanException.ContainsPeople);}
        else if(reader.getBlock()){
            throw new LoanException(LoanException.UserBlock);}
        else if(loan.getRenovationQuantity() == 3){
            throw new LoanException(LoanException.RenewalExceeded);
        }else{
            loan.setRenovationQuantity(1); //soma uma renovação
            loan.setDateDevolution(dateEnd(loan.getDateDevolution())); //pega a data final e soma + 10 dias, e fica sendo a nova data devolução
        }}
}
