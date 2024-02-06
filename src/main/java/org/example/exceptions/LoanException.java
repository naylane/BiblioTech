package org.example.exceptions;

public class LoanException extends Exception{
    public static final String ContainsPeople = "Já existe pessoas na fila.";
    public static final String RenewalExceeded = "Limite de renovação atingido.";
    public static final String FinalizedLoan = "Este emprestimo já foi finalizado.";
    public static final String LoanLimit = "O usuário já atingiu o limite de emprestimos.";
    public LoanException(String message){
        super(message);
    }
}
