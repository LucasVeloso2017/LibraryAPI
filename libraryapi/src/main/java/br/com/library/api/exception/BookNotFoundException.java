package br.com.library.api.exception;

public class BookNotFoundException extends RuntimeException{
    
    public BookNotFoundException(String msg){
        super(msg);
    }
}
