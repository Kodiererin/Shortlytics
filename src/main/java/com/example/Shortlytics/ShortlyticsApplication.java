package com.example.Shortlytics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ShortlyticsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShortlyticsApplication.class, args);
	}

}
