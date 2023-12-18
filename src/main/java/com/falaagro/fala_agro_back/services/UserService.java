package com.falaagro.fala_agro_back.services;

import com.falaagro.fala_agro_back.DTOs.LoginRequest;
import com.falaagro.fala_agro_back.DTOs.LoginResponse;
import com.falaagro.fala_agro_back.entities.User;
import com.falaagro.fala_agro_back.errors.LoginInvalidException;
import com.falaagro.fala_agro_back.errors.UserAlreadyExistsException;
import com.falaagro.fala_agro_back.repositories.UserRepository;
import com.falaagro.fala_agro_back.security.PasswordCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    public UserRepository userRepository;

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User createUser(User user) throws RuntimeException {
        Optional<User> existentUser = userRepository.findByUsernameOrEmail(user.getUsername(), user.getEmail());

        if (existentUser.isPresent()) {
            throw new UserAlreadyExistsException("username or email is already being used");
        }


        user.setPassword(PasswordCrypt.encryption(user.getPassword()));
        return userRepository.save(user);
    }

    public LoginResponse login(LoginRequest loginRequest) {
        Optional<User> user = userRepository.findByUsernameOrEmail(loginRequest.getEmailOrUsername(), loginRequest.getEmailOrUsername());

        if (user.isEmpty() || !PasswordCrypt.verifier(loginRequest.getPassword(), user.get().getPassword())) {
            throw new LoginInvalidException("Invalid credentials");
        }

        return new LoginResponse(user.get(), "token");
    }
}
