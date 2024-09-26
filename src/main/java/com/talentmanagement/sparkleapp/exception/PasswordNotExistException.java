package com.talentmanagement.sparkleapp.exception;

public class PasswordNotExistException extends RuntimeException {
    public PasswordNotExistException(String message) {
        super(message);
    }
}
