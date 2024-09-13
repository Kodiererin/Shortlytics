package com.example.Shortlytics.repository;

import com.example.Shortlytics.models.URL;
import com.example.Shortlytics.utils.ImpleUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UrlRepoImplementation implements  UrlRepository {


    @Autowired
    private MongoTemplate mongoTemplate;
    private ImpleUtility utility;

    public UrlRepoImplementation() {
        this.utility = new ImpleUtility();
    }

    @Override
    public HashMap<String, String> saveURL(String oldUrl) {
        HashMap<String, String> map = new HashMap<>();
        try {
            // Logic to get the Shorten URL
            String newUrl = utility.shortelURl(oldUrl);
            // Get the current date and time.
            String dateTime = utility.getCurrentDateTime();
            // Check if the URL is unique or not - if unique save in the database.
//            URL getUrl =  mongoTemplate.find(oldUrl,Url,url);
            // else regenerate the url and then save it in the database.
//            if(getUrl==null){
//                URL saveUrl = new URL(oldUrl,newUrl,dateTime);
//                mongoTemplate.save(saveUrl);
//            }
//            else{
//                new HashMap<String,String>().put("Status" , "Url already exists.");
//            }

            map.put("OldURl", oldUrl);
            map.put("NewUrl", newUrl);
            map.put("Time", dateTime);

            return map;
        } catch (Exception e) {
            map.put("Status", "Error in generating the Url");
            return map;
        }
    }
    @Override
    public String deleteUrl(String newUrl) {
        return null;
    }
}
