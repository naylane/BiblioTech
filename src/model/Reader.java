package model;

import dao.reader.ReaderDAOImpl;
import exceptions.BookException;
import exceptions.LoanException;

import java.time.LocalDate;

/**
 * A classe Reader é uma subclasse da classe User.
 * Portando, ela herda os atributos e métodos da
 * superclasse User, e contém atributos como block,
 * que indica se o leitor está bloqueado, e prazo
 * final, que armazena a data final que o leitor
 * está bloqueado. Além disso, contém um construtor
 * para criar o objeto e métodos getters e setters
 * para pegar e alterar os atributos privados.
 * Contém também metódos que são especificos para
 * as funcionalidades de um leitor, como fazer uma
 * reserva, renovar um emprestimo, sair da fila de
 * reserva e verificar se ele está com multa ativa.
 *
 * @author Sara Souza e Naylane Ribeiro
 */
public class Reader extends User {

    ReaderDAOImpl readerDAO = new ReaderDAOImpl(); //se quiser usar as opreções do DAO, uma das formas é criar um objeto
    public Boolean block; // diz se o leitor está bloqueado ou não: false - não e true - sim
    public LocalDate fineDeadline; //data final que o leitor está bloqueado

    /**
     * Construtor da classe Reader que cria um novo leitor com os atributos
     * fornecidos e inicializa o estado de bloqueio como falso (não bloqueado).
     *
     * @param id      O ID do leitor.
     * @param name    O nome do leitor.
     * @param pin     O código PIN do leitor.
     * @param phone   O número de telefone do leitor.
     * @param address O endereço do leitor.
     */
    public Reader(long id, String name, String pin, String phone, Residence address) { //construtor reader
        super(id, name, pin, phone, address);
        this.fineDeadline = null;
    }

    /**
     * Obtém o estado de bloqueio do leitor.
     *
     * @return True se o leitor estiver bloqueado, False caso contrário.
     */
    public Boolean getBlock(){
        if(block){ //block == true
            return true;
        } else {
            return false;
        }
    }

    /**
     * Bloqueia um leitor, definindo seu estado de bloqueio como verdadeiro.
     *
     * @param reader O leitor que será bloqueado.
     */
    public void blockReader(Reader reader) {
        reader.block = true;
    }

    /**
     * Desbloqueia um leitor, definindo seu estado de bloqueio como falso.
     *
     * @param reader O leitor que será desbloqueado.
     */
    public void unlockReader(Reader reader) {
        reader.block = false;}

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

    /**
     * Calcula a data final com prazo de 10 dias a partir de uma data inicial.
     *
     * @param date A data inicial.
     * @return A data final após adicionar 10 dias.
     */
    public LocalDate dateEnd(LocalDate date){ //data final com prazo de 10 dias
        return date.plusDays(10);}

    /**
     * Renova um empréstimo, estendendo sua data de devolução.
     *
     * @param loan O empréstimo a ser renovado.
     * @param book O livro emprestado.
     * @throws LoanException Se o empréstimo já foi finalizado, a fila de reserva contém pessoas,
     * o leitor está bloqueado, ou o limite de renovações foi excedido.
     */
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
