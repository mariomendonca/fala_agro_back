package com.falaagro.fala_agro_back.DTOs;

import lombok.Data;

@Data
public class LoginRequest {
    private String emailOrUsername;
    private String password;
}
