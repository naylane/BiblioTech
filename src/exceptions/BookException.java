package exceptions;

public class BookException extends Exception{
    public static final String QuantityErro = "A quantidade tem que ser maior que 0.";
    public static final String NotAvailable = "Esse livro não está disponível no momento.";
    public static final String Available = "Livro disponível para emprestimo.";
    public static final String BookNotFound = "Livro não encontrado.";
    public BookException(String message){
        super(message);
    }
}
