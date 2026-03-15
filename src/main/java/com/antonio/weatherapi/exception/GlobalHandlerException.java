package com.antonio.weatherapi.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;

@RestControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(IOException.class)
    public ResponseEntity<String> handleIOException(IOException exception){
        return ResponseEntity.internalServerError().body("Erro ao acessar o serviço externo");
    }
    @ExceptionHandler(InterruptedException.class)
    public ResponseEntity<String> handleInterruptedException(InterruptedException exception){
        return ResponseEntity.internalServerError().body("Operação interrompida");
    }

}
