package com.linkify.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "urls")   // matches your MySQL table
public class Url {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "original_url")
    private String originalUrl;

    @Column(name = "short_code")
    private String shortCode;

    @Column(name = "click_count")
    private long clickCount;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    // ✅ getters and setters

    public Long getId() {
        return id;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public String getShortCode() {
        return shortCode;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }

    public long getClickCount() {
        return clickCount;
    }

    public void setClickCount(long clickCount) {
        this.clickCount = clickCount;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}