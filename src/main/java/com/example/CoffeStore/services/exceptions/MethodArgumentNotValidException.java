package com.example.CoffeStore.services.exceptions;

public class MethodArgumentNotValidException extends RuntimeException{

    private static final long serialVersionUID = 1L;
    public MethodArgumentNotValidException(String msg){
        super(msg);
    }
}