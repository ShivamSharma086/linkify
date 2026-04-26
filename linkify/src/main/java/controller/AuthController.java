package com.linkify.controller;

import com.linkify.model.User;
import com.linkify.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private UserService service;

    @Autowired
    private PasswordEncoder encoder;

    // ✅ REGISTER
    @PostMapping("/register")
    public Map<String, String> register(@RequestBody Map<String, String> body) {

        String username = body.get("username");
        String password = body.get("password");

        Map<String, String> res = new HashMap<>();

        if (username == null || password == null) {
            res.put("error", "Missing fields");
            return res;
        }

        service.register(username.trim(), password);

        res.put("message", "User registered!");
        return res;
    }

    // ✅ LOGIN
    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> body) {

        String username = body.get("username");
        String password = body.get("password");

        Map<String, String> res = new HashMap<>();

        if (username == null || password == null) {
            res.put("error", "Missing fields");
            return res;
        }

        User user = service.findByUsername(username.trim());

        if (user != null && encoder.matches(password, user.getPassword())) {
            res.put("message", "Login successful!");
        } else {
            res.put("error", "Invalid credentials");
        }

        return res;
    }
}