package org.example.emptytest.exceptions;

public class UserAlreadyExitstException extends Exception{
    String message;
    public UserAlreadyExitstException(String message){
        this.message = message;
    }
    public String getMessage(){
        return message;
    }
}
