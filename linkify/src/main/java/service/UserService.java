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

    public void register(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(encoder.encode(password));
        repo.save(user);
    }

    public User findByUsername(String username) {
        return repo.findByUsername(username).orElse(null);
    }
}