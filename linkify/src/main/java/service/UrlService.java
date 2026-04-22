package com.linkify.service;

import com.linkify.model.Url;
import com.linkify.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class UrlService {

    @Autowired
    private UrlRepository repo;

    public String shortenUrl(String originalUrl) {

        String code = UUID.randomUUID().toString().substring(0,6);

        Url url = new Url();
        url.setOriginalUrl(originalUrl);
        url.setShortCode(code);
        url.setClickCount(0);
        url.setCreatedAt(LocalDateTime.now());

        repo.save(url);

        return code;
    }

    public String getOriginalUrl(String code) {

        Optional<Url> optional = repo.findByShortCode(code);

        if (optional.isPresent()) {
            Url url = optional.get();
            url.setClickCount(url.getClickCount() + 1);
            repo.save(url);
            return url.getOriginalUrl();
        }

        return null;
    }
}