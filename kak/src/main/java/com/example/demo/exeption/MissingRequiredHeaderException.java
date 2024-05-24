package com.example.demo.exeption;

public class MissingRequiredHeaderException extends RuntimeException {
    public MissingRequiredHeaderException(String message) {
        super(message);
    }
}    