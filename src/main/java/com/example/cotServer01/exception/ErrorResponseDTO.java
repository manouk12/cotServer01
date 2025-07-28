package com.example.cotServer01.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponseDTO {
    private int status;  //HTTP상태코드
    private String message; //Error 메시지
    private LocalDateTime timestamp;

    public static ErrorResponseDTO of(int status, String message) {
        return new ErrorResponseDTO(status, message, LocalDateTime.now());
    }
}
