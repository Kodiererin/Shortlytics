package com.example.Shortlytics.utils;

import org.springframework.boot.autoconfigure.web.format.DateTimeFormatters;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ImpleUtility implements  Utility{
    private HashMap<String, String> urlMap = new HashMap<>();
    private HashMap<String, String> reverseUrlMap = new HashMap<>();
    private static final String BASE_URL = "Https://www.whoisujjwal.me/";
    private static final String CHAR_SET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private Random random = new Random();
    private static final int SHORT_URL_LENGTH = 6; // Length of short URL

    @Override
    public String shortelURl(String oldUrl) {
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
        DateTimeFormatter dtf = new DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now).toString();

    }
}
