package com.falaagro.fala_agro_back.DTOs;

import lombok.Data;
import lombok.Getter;

@Data
public class LoginRequest {
    private String emailOrUsername;
    private String password;
}
