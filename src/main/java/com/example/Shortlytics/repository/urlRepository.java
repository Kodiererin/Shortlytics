package com.example.Shortlytics.repository;

import com.example.Shortlytics.models.URL;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface urlRepository extends MongoRepository<URL,String> {
    List<URL> findURLByNewUrlEndingWithIgnoreCase(String newURL);
}
