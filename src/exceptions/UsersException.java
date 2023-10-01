package exceptions;

public class UsersException extends Exception{
    public static final String UserBlock = "Este usuário está bloqueado";
    public UsersException(String message){
        super(message);
    }
}
