package com.SparkleApp.exception;

public class CustomerDoesNotExist extends RuntimeException {
    public CustomerDoesNotExist(String message) {
        super(message);
    }
}
