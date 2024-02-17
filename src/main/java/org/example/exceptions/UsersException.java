package org.example.exceptions;

public class UsersException extends Exception{
    public static final String UserBlock = "Este usuário está bloqueado.";
    public static final String UserNotFound = "Usuário não encontrado.";
    public static final String LoginError = "Não foi possível realizar o login! Por favor, verifique os dados informados.";

    public UsersException(String message){
        super(message);
    }
}
