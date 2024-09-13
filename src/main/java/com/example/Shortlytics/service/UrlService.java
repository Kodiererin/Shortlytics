package com.example.Shortlytics.service;

import com.example.Shortlytics.models.URL;
import com.example.Shortlytics.repository.urlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UrlService {

    @Autowired
    private urlRepository repository;


    // Saving the URL
    public URL saveUrl(URL url){
        return repository.save(url);
    }


    // Finding the URL
    public List<URL> findUrl(String url){
        return repository.findURLByNewUrlEndingWithIgnoreCase(url);
    }
}
