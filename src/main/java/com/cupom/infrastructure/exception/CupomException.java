package com.cupom.infrastructure.exception;

public class CupomException extends RuntimeException{

    public CupomException(String message, Exception e) {
        super(message,e);
    }
}
