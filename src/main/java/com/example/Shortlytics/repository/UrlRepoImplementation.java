package com.example.Shortlytics.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UrlRepoImplementation implements  UrlRepository {


    @Autowired
    private MongoTemplate mongoTemplate;
    @Override
    public String saveURL(String oldUrl) {
        try{
            // Logic to get the Shorten URL
            // Get the current date and time.
            // Check if the URL is unique or not - if unique save in the database.
            // else regenerate the url and then save it in the database.


            return "Hello World";
        }catch(Exception e){
            return e.toString();
        }
    }

    @Override
    public String deleteUrl(String newUrl) {
        return null;
    }
}
