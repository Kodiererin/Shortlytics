package com.example.Shortlytics.service;

import com.example.Shortlytics.models.URL;
import com.example.Shortlytics.repository.urlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UrlService {

    @Autowired
    private urlRepository repository;

    public URL saveUrl(URL url){
        return repository.save(url);
    }

}
