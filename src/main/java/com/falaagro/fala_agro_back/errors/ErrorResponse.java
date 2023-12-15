package com.falaagro.fala_agro_back.errors;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
public class ErrorResponse {
    private final String message;
    private final HttpStatus status;
    private final Integer statusCode;
    private final LocalDateTime timestamp = LocalDateTime.now();

    public ErrorResponse(String message, HttpStatus status, Integer statusCode) {
        this.message = message;
        this.status = status;
        this.statusCode = statusCode;
    }
}
