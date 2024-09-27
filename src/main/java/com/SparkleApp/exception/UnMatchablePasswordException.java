package com.SparkleApp.exception;

public class UnMatchablePasswordException extends RuntimeException {
    public UnMatchablePasswordException(String message) {
        super(message);
    }
}
