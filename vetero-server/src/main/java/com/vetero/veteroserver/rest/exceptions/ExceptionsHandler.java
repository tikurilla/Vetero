package com.vetero.veteroserver.rest.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionsHandler {
    @ExceptionHandler({DataNotFoundException.class})
    public ResponseEntity<String> handleDataNotFoundException(DataNotFoundException ex) {
        return error(ex.getStatusCode(), ex.getMessage());
    }

    @ExceptionHandler({IncorrectParameterException.class})
    public ResponseEntity<String> handleIncorrectParameterException(IncorrectParameterException ex) {
        return error(ex.getStatusCode(), ex.getMessage());
    }

    private ResponseEntity<String> error(int status, String message) {
        return ResponseEntity.status(status).body(message);
    }
}
