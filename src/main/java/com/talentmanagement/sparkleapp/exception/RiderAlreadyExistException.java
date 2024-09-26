package com.talentmanagement.sparkleapp.exception;

public class RiderAlreadyExistException extends RuntimeException{
    public RiderAlreadyExistException(String message) {
        super(message);
    }
}
