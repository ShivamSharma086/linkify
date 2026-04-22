package com.linkify.controller;

import com.linkify.service.UrlService;
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

    // टेस्ट API
    @GetMapping("/hello")
    public String hello() {
        return "Linkify is working! 🚀";
    }

    // ✅ SHORTEN URL (FIXED using POST)
    @PostMapping("/shorten")
    public String shortenUrl(@RequestBody Map<String, String> body) {
        String url = body.get("url");

        if (url == null || url.isEmpty()) {
            return "Invalid URL";
        }

        String shortCode = urlService.shortenUrl(url);
        return "http://localhost:8080/api/r/" + shortCode;
    }

    // ✅ REDIRECT TO ORIGINAL URL
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