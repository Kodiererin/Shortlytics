package com.example.Shortlytics.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/")
    public String sayHello(){
        return "Hello World";
    }

    @GetMapping("/home")
    public String sayHelloHome(){
        return "Hello World";
    }
}
