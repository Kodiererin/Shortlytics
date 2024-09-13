package com.example.Shortlytics.controller;


import com.example.Shortlytics.models.URL;
import com.example.Shortlytics.service.UrlService;
import com.example.Shortlytics.utils.ImpleUtility;
import com.example.Shortlytics.utils.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/")
public class HomeController {
    @Autowired
    UrlService urlService;

    @GetMapping("/")
    public String test(){
        return "The Domain is Working";
    }

    @GetMapping("{test}")
    public String getTest(@PathVariable("test") String test){
        return "The URL is Working and the parameter is  "+test;
    }


    // Function receives the URL and the function returns the shorten URL to the Use.
    // Get the new URL and the date-time
    // Save the url
    @GetMapping("/shortUrl")
    public ResponseEntity<URL> shortURL(@RequestParam String oldUrl) {
        String newUrl = new ImpleUtility().shortenURl(oldUrl);
        String dateCreated = new ImpleUtility().getCurrentDateTime();
        URL url = new URL(oldUrl,newUrl,dateCreated);
        URL saveUrl = urlService.saveUrl(url);
        if(saveUrl!=null){
            return ResponseEntity.status(HttpStatus.OK).body(url);
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }


}
