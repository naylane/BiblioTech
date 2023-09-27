package model;

public class Reserve {
    public long id = 0;
    public Reader reader; //leitor que reservou o livro
    public Book book; //livro a ser reservado

    public Reserve(long id, Reader reader, Book book){
        this.id = id;
        this.book = book;
        this.reader = reader;
    }

    // Métodos Get
    public Reader getReader() {return reader;}

    public Book getBook() {return book;}

    // Métodos Set
    public void setReader(Reader reader) {this.reader = reader;}

    public void setBook(Book book) {this.book = book;}

    public long getId() {return id;}

    public int generateId(int id){ //gerar automaticamente o id da reserva
        return id +=1;
    }

    /**
    * Método que adiciona um leitor a fila de reserva de determinado livro.
    * @param reader leitor
    * @param book livro
    **/
    public void removeToQueue(Reader reader, Book book){
        book.removeReservationQueue(reader); //tirando leitor da fila para reservar o livro
    }

    /**
     * Método que retira um leitor a fila de reserva de determinado livro.
     * @param reader leitor
     * @param book livro
     **/
    public void makeReservation(Reader reader, Book book){ //verefica se tem livro disponivel
        if(book.getQuantity() > 0){
            System.out.println("Livro disponivel para emprestimo");} //logo, vc pode ir fazer o emprestimo com o bibliotecario
        else{
            book.addReservationQueue(reader); //entra na fila de reserva
        }
    }
}
