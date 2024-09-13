package com.example.Shortlytics.repository;

import com.example.Shortlytics.models.URL;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UrlRepository {
    // Adding the URL
    public String saveURL(String url);
    // Deleting the URL
    public String deleteUrl(String url);
}
