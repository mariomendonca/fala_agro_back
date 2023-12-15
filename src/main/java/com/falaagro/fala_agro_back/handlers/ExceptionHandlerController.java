package com.falaagro.fala_agro_back.handlers;

import com.falaagro.fala_agro_back.errors.ErrorResponse;
import com.falaagro.fala_agro_back.errors.LoginInvalidException;
import com.falaagro.fala_agro_back.errors.UserAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleUserAlreadyExistsException(UserAlreadyExistsException e) {
        ErrorResponse errorResponse = new ErrorResponse(
                e.getMessage(),
                HttpStatus.BAD_REQUEST,
                HttpStatus.BAD_REQUEST.value()
        );
        return ResponseEntity.badRequest().body(errorResponse);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleLoginInvalidException(LoginInvalidException e) {
        ErrorResponse errorResponse = new ErrorResponse(
                e.getMessage(),
                HttpStatus.BAD_REQUEST,
                HttpStatus.BAD_REQUEST.value()
        );
        return ResponseEntity.badRequest().body(errorResponse);
    }
}
