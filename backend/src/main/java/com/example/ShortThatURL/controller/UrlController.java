package com.example.urlshortener.controller;

import com.example.urlshortener.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UrlController {

    @Autowired
    private UrlService urlService;

    @PostMapping("/shorten")
    public Map<String, String> shortenUrl(@RequestBody Map<String, String> request) {
        String longUrl = request.get("longUrl");
        String shortUrl = urlService.generateShortUrl(longUrl);
        return Map.of("shortUrl", shortUrl);
    }

    @GetMapping("/{shortUrl}")
    public Map<String, String> getLongUrl(@PathVariable String shortUrl) {
        Optional<String> longUrl = urlService.getLongUrl(shortUrl);
        return longUrl.map(url -> Map.of("longUrl", url)).orElse(Map.of("error", "URL not found"));
    }
}
