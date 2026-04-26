package com.linkify.service;

import com.linkify.model.User;
import com.linkify.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    @Autowired
    private PasswordEncoder encoder;

    // ✅ REGISTER
    public String register(String username, String password) {

        username = username.trim();

        // ❗ check duplicate user
        if (repo.findByUsername(username).isPresent()) {
            return "User already exists";
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(encoder.encode(password));

        repo.save(user);

        return "User saved";
    }

    // ✅ FIND USER
    public User findByUsername(String username) {
        return repo.findByUsername(username.trim()).orElse(null);
    }
}