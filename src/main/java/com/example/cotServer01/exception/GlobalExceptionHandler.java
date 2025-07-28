package com.example.cotServer01.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    //Precessing wrong Request
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponseDTO> handleIllegalArg(IllegalArgumentException e) {
        return ResponseEntity
                .badRequest()
                .body(ErrorResponseDTO.of(400, e.getMessage()));
    }

    // Processing All of Exception(using Log)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> handleAll(Exception e) {
        e.printStackTrace();
        return ResponseEntity
                .internalServerError()
                .body(ErrorResponseDTO.of(500, "Error inner Server"));
    }
}
