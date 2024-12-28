package com.example.Shortlytics.service;

import com.example.Shortlytics.models.URL;
import com.example.Shortlytics.repository.urlRepository;
import com.example.Shortlytics.utils.ImpleUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
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
        System.out.println("Saving the URL");
        // Add the implementation : if the url already exists.
        List<URL> isURlExist = repository.findByInitialUrlContainingIgnoreCase(url.getInitialUrl());
        if(isURlExist.size()>=1){
            repository.delete(isURlExist.get(0));
            url.setNewUrl(new ImpleUtility().shortenURl(url.getInitialUrl()));
        }
        return repository.save(url);
    }


    // Finding the URL
    @Cacheable("urlCache")
    public List<URL> findUrl(String url){
        System.out.println("IS Caching Working");
        return repository.findURLByNewUrlEndingWithIgnoreCase(url);
    }


    public List<URL> findUrlByShortKey(String shortKey) {
        // Extract the full shortened URL format
        String fullShortUrl = "http://localhost:8080/" + shortKey;

        // Query the database
        return repository.findByNewUrl(fullShortUrl);
    }

    public List<URL> findUrlByFullShortUrl(String fullShortUrl) {
        // Query the database using the full short URL (e.g., http://localhost:8080/xVhMRW)
        return repository.findByNewUrl(fullShortUrl);  // Assuming 'newUrl' field stores the full URL
    }

}
