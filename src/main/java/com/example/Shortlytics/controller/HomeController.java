package com.example.Shortlytics.controller;


import com.example.Shortlytics.repository.UrlRepoImplementation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/")
public class HomeController {


    @GetMapping("/")
    public String test(){
        return "The Domain is Working";
    }

    @GetMapping("{test}")
    public String getTest(@PathVariable("test") String test){
        return "The URL is Working and the parameter is  "+test;
    }


    // Function receives the URL and the function returns the shorten URL to the Use.
    @GetMapping("/shortUrl")
    public ResponseEntity<HashMap<String, String>> shortURL(@RequestParam String oldUrl) {
        if (oldUrl == null || oldUrl.isBlank() || oldUrl.length() <= 1) {
            HashMap<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Empty or Invalid URL");
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }

        UrlRepoImplementation urlRepoImp = new UrlRepoImplementation();
        HashMap<String, String> map = urlRepoImp.saveURL(oldUrl);

        if (map != null) {
            return ResponseEntity.status(HttpStatus.OK).body(map);
        } else {
            HashMap<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Failed to shorten URL");
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
