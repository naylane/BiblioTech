package model;

public class Reserve {
    public int id = 0;
    public Reader reader; //leitor que reservou o livro
    public Book book; //livro a ser reservado
    public Reserve(int id, Reader reader, Book book){
        this.id = id;
        this.book = book;
        this.reader = reader;}
    // Métodos Get
    public Reader getReader() {return reader;}
    public Book getBook() {return book;}
    // Métodos Set
    public void setReader(Reader reader) {this.reader = reader;}
    public void setBook(Book book) {this.book = book;}
    public int getId() {return id;}

    /**
    * Métodos que adicionam/tiram um leitor a fila de reserva de determinado livro.
    * @param reader leitor
    * @param book livro
    **/
    public void removetoQueue(Reader reader, Book book){
        book.removeReservationQueue(reader);} //tirando leitor da fila para reservar o livro
    public void addtoQueue(Reader reader, Book book){ //queue - fila
        book.addReservationQueue(reader); //colocando leitor na fila para reservar o livro
        Reader firstofQueue = book.getResevationQueue().peek(); //retirando primeiro elemento da fila
        if(firstofQueue == reader){ //se o primeiro da fila for o leitor, ele reserva, se não fica na fila
            //falta fazer
        }else{
            System.out.println("Você foi adicionado a fila de reserva");}}

}
