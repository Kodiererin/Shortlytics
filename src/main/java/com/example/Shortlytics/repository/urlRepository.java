package com.example.Shortlytics.repository;

import com.example.Shortlytics.models.URL;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface urlRepository extends MongoRepository<URL,String> {

}
