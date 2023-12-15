package com.falaagro.fala_agro_back.errors;

public class LoginInvalidException extends RuntimeException {
    public LoginInvalidException(String message) {
        super(message);
    }
}
