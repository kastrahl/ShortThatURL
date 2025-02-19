package com.example.urlshortener.service;

import com.example.urlshortener.model.Url;
import com.example.urlshortener.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class UrlService {

    @Autowired
    private UrlRepository urlRepository;

    private final String BASE_URL = "http://localhost:8080/";

    public String generateShortUrl(String longUrl) {
        String shortUrl = generateRandomShortCode();
        Url url = new Url();
        url.setLongUrl(longUrl);
        url.setShortUrl(shortUrl);
        urlRepository.save(url);
        return BASE_URL + shortUrl;
    }

    public Optional<String> getLongUrl(String shortUrl) {
        return urlRepository.findByShortUrl(shortUrl).map(Url::getLongUrl);
    }

    private String generateRandomShortCode() {
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuilder shortUrl = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            shortUrl.append(characters.charAt(random.nextInt(characters.length())));
        }
        //need validation if shorturl already in use and in DB
        return shortUrl.toString();
    }
}
