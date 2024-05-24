package com.example.demo.exeption;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(MissingRequiredHeaderException.class)
    public ResponseEntity<Map<String, Object>> handleMissingRequiredHeader(MissingRequiredHeaderException ex) {
        Map<String, Object> response = new HashMap<>();
        response.put("_code", 400);
        response.put("_message",  "Kep-OrgLoginType is not present.");

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}