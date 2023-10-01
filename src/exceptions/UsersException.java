package exceptions;

public class UsersException extends Exception{
    public static final String AlreadyUserBlock = "Este usuário já está bloqueado.";
    public static final String AlreadyUserUnlock = "Este usuário já está desbloqueado.";
    public static final String LoanLimit = "O usuário já atingiu o limite de emprestimos.";
    public static final String UserBlock = "Este usuário está bloqueado";
    public static final String ReaderNotFound = "Leitor não encontrado";

    public UsersException(String message){
        super(message);
    }
}
