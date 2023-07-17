package com.example.CoffeStore.services.exceptions;

public class NonTransientDataAccessException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public NonTransientDataAccessException(String msg){
        super(msg);
    }
}
