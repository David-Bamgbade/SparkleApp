package com.talentmanagement.sparkleapp.exception;

public class UnMatchablePasswordException extends RuntimeException {
    public UnMatchablePasswordException(String message) {
        super(message);
    }
}
