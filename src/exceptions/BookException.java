package exceptions;

public class BookException extends Exception{
    public static final String AlreadyCreated = "Este Livro já está no sistema.";
    public static final String IsbnErro = "Existe uma inconsistência com o Isbn.";
    public static final String QuantityErro = "A quantidade tem que ser maior que 0.";
    public static final String NotAvailable = "Esse livro não está disponível no momento.";
    public static final String Available = "Livro disponível para emprestimo.";
    public BookException(String message){
        super(message);
    }
}
