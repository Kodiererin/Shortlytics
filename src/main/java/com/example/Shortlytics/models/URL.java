package com.example.Shortlytics.models;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "url")
// Collection Name : url
public class URL {
    @Id
    private String Id;
    @Indexed(unique = true)
    private String initialUrl;      // Old Url
    @Indexed(unique = true)
    private String newUrl;          // New url
    private String urlAdded;        // Date and time when the url was added

    public URL(String initialUrl, String newUrl, String urlAdded) {
        this.initialUrl = initialUrl;
        this.newUrl = newUrl;
        this.urlAdded = urlAdded;
    }

    public String getId() {
        return Id;
    }

    public String getInitialUrl() {
        return initialUrl;
    }

    public void setInitialUrl(String initialUrl) {
        this.initialUrl = initialUrl;
    }

    public String getNewUrl() {
        return newUrl;
    }

    public void setNewUrl(String newUrl) {
        this.newUrl = newUrl;
    }

    public String getUrlAdded() {
        return urlAdded;
    }

    public void setUrlAdded(String urlAdded) {
        this.urlAdded = urlAdded;
    }
}
