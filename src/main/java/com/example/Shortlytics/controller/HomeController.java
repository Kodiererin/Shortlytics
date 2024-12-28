package com.example.Shortlytics.controller;

import com.example.Shortlytics.models.URL;
import com.example.Shortlytics.service.UrlService;
import com.example.Shortlytics.utils.ImpleUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/")
public class HomeController {

    final String shortenUrl_Url = "http://localhost:5173/"; // Added trailing slash

    @Autowired
    UrlService urlService;

    @GetMapping("/")
    public String test() {
        return "The Domain is Working";
    }

    /**
     * Controller that takes the shortened URL and redirects to the original URL.
     * @param data
     * @return
     */
    @GetMapping("/{data}")
    public ResponseEntity<Object> getTest(@PathVariable("data") String data) {
        System.out.println("Shortened Key: " + data);
        String fullShortUrl = shortenUrl_Url + data;
        List<URL> getUrl = urlService.findUrlByFullShortUrl(fullShortUrl);

        if (getUrl.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("URL not found"); // Return 404 if not found
        }

        String initialUrl = getUrl.get(0).getInitialUrl();
        if (!initialUrl.startsWith("http://") && !initialUrl.startsWith("https://")) {
            initialUrl = "http://" + initialUrl; // Ensure protocol is added
        }

        System.out.println("Redirecting to: " + initialUrl);
        return ResponseEntity.status(HttpStatus.OK).body(initialUrl); // Send the original URL in the response body
    }


    /**
     * Controller to shorten the URL which also saves the data in the database.
     * @param oldUrl
     * @return
     */
    @GetMapping("/shortUrl")
    public ResponseEntity<URL> shortURL(@RequestParam String oldUrl) {
        System.out.println(oldUrl);
//        System.out.println("");
        String newUrl = new ImpleUtility().shortenURl(oldUrl);
        String dateCreated = new ImpleUtility().getCurrentDateTime();
        URL url = new URL(oldUrl, newUrl, dateCreated);
        URL saveUrl = urlService.saveUrl(url);

        if (saveUrl != null) {
            return ResponseEntity.status(HttpStatus.OK).body(url);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}
