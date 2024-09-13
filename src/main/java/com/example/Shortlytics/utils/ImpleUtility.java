package com.example.Shortlytics.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.format.DateTimeFormatters;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Random;



@Component
public class ImpleUtility implements  Utility{
    private final HashMap<String, String> urlMap = new HashMap<>();
    private final HashMap<String, String> reverseUrlMap = new HashMap<>();
    private static final String BASE_URL = "http://localhost:8080/";
    private static final String CHAR_SET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private final Random random = new Random();
    private static final int SHORT_URL_LENGTH = 6; // Length of short URL

    @Override
    public String shortenURl(String oldURL) {
        if (reverseUrlMap.containsKey(oldURL)) {
            return BASE_URL + reverseUrlMap.get(oldURL);
        }
        String shortCode;
        do {
            shortCode = generateShortCode();
        } while (urlMap.containsKey(shortCode));
        urlMap.put(shortCode, oldURL);
        reverseUrlMap.put(oldURL, shortCode);
        return BASE_URL + shortCode;
    }

    private String generateShortCode() {
        StringBuilder shortCode = new StringBuilder();
        for (int i = 0; i < SHORT_URL_LENGTH; i++) {
            shortCode.append(CHAR_SET.charAt(random.nextInt(CHAR_SET.length())));
        }
        return shortCode.toString();
    }


    // To Get the Current Date time
    @Override
    public String getCurrentDateTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);

    }
}
