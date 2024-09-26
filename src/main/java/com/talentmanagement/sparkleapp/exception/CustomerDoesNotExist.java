package com.talentmanagement.sparkleapp.exception;

public class CustomerDoesNotExist extends RuntimeException {
    public CustomerDoesNotExist(String message) {
        super(message);
    }
}
