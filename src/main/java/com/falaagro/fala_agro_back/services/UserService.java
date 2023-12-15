package com.falaagro.fala_agro_back.services;

import com.falaagro.fala_agro_back.entities.User;
import com.falaagro.fala_agro_back.errors.UserAlreadyExistsException;
import com.falaagro.fala_agro_back.repositories.UserRepository;
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

        return userRepository.save(user);
    }
}
