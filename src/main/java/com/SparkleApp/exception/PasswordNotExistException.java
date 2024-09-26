package com.SparkleApp.exception;

public class PasswordNotExistException extends RuntimeException {
    public PasswordNotExistException(String message) {
        super(message);
    }
}
