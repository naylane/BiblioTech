package exceptions;

public class UsersException extends Exception{
    public static final String AlreadyUserBlock = "Este usuário já está bloqueado.";
    public static final String AlreadyUserUnlock = "Este usuário já está desbloqueado.";

    public UsersException(String message){
        super(message);
    }
}
