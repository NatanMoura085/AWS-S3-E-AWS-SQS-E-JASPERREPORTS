package com.cupom.infrastructure.exception;

public class EntityNotFound extends CupomException{
    public EntityNotFound(String message,RuntimeException e){
        super(message);
    }
}
