package exceptions;

public class LoanException extends Exception{
    public static final String ContainsPeople = "Já existe pessoas na fila.";
    public static final String RenewalExceeded = "Limite de renovação atingido.";
    public static final String FinalizedLoan = "Este emprestimo já foi finalizado.";
    public static final String NoLoan = "Nenehum emprestimo ainda feito.";
    public static final String NoUserLoan = "Este usuario ainda não fez emprestimos.";
    public LoanException(String message){
        super(message);
    }
}
