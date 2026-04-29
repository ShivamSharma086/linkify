package com.linkify.controller;

import com.linkify.service.UrlService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UrlController {

    @Autowired
    private UrlService urlService;

    // =========================
    // TEST API
    // =========================
    @GetMapping("/hello")
    public String hello() {
        return "Linkify is working! 🚀";
    }

    // =========================
    // SHORTEN URL
    // =========================
    @PostMapping("/shorten")
    public String shortenUrl(@RequestBody Map<String, String> body,
                             HttpServletRequest request) {

        String url = body.get("url");

        if (url == null || url.trim().isEmpty()) {
            return "Invalid URL";
        }

        // Generate short code
        String shortCode = urlService.shortenUrl(url);

        // Dynamic base URL
        String baseUrl = request.getScheme() + "://" + request.getServerName();

        if (request.getServerPort() != 80 && request.getServerPort() != 443) {
            baseUrl += ":" + request.getServerPort();
        }

        // Final short URL
        return baseUrl + "/api/r/" + shortCode;
    }

    // =========================
    // REDIRECT TO ORIGINAL URL
    // =========================
    @GetMapping("/r/{shortCode}")
    public void redirect(@PathVariable String shortCode,
                         HttpServletResponse response) throws IOException {

        String originalUrl = urlService.getOriginalUrl(shortCode);

        if (originalUrl == null) {
            response.sendError(404, "Short URL not found");
            return;
        }

        response.sendRedirect(originalUrl);
    }
}

