package com.falaagro.fala_agro_back.DTOs;

import com.falaagro.fala_agro_back.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponse {
    private User user;
    private String token;
}
