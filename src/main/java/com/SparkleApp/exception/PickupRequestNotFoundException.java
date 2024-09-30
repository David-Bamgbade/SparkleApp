package com.SparkleApp.exception;

public class PickupRequestNotFoundException extends RuntimeException{
    public PickupRequestNotFoundException(String message) {
        super(message);
    }
}
