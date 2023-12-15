package com.falaagro.fala_agro_back.security;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class PasswordCrypt {
    public static String encryption(String password) {
        return BCrypt.withDefaults().hashToString(12, password.toCharArray());
    }

    public static boolean verifier(String password, String encryptedPassword) {
        return BCrypt.verifyer().verify(password.toCharArray(), encryptedPassword).verified;
    }
}
