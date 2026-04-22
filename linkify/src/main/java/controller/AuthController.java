package com.linkify.controller;

import com.linkify.model.User;
import com.linkify.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService service;

    @Autowired
    private PasswordEncoder encoder;

    @PostMapping("/register")
    public String register(@RequestParam String username,
                           @RequestParam String password) {

        service.register(username, password);
        return "User registered!";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password) {

        User user = service.findByUsername(username);

        if (user != null && encoder.matches(password, user.getPassword())) {
            return "Login successful!";
        }

        return "Invalid credentials";
    }
}