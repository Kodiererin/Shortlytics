package com.example.Shortlytics.repository;

import com.example.Shortlytics.models.URL;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.HashMap;

public interface UrlRepository {
    // Adding the URL
    public HashMap<String,String> saveURL(String url);
    // Deleting the URL
    public String deleteUrl(String url);
}
