package org.acme.model;

import java.time.LocalDate;
import java.util.Date;

import io.quarkus.mongodb.panache.PanacheMongoEntity;

public class Post extends PanacheMongoEntity {
    
    private String title;

    private String description;

    private Boolean active;

    public String date;

    //public String imageUrl;

    //public String[] hashtags; //maybe entity
    
    //public long likes;
    
    //public String[] comments; //entity if users exists

    public Post() { }

    public Post(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String string) {
        this.date = string.toString();
    }

    

    /*public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String[] getHashtags() {
        return hashtags;
    }

    public void setHashtags(String[] hashtags) {
        this.hashtags = hashtags;
    }



    public long getLikes() {
        return likes;
    }

    public void setLikes(long likes) {
        this.likes = likes;
    }

    public String[] getComments() {
        return comments;
    }

    public void setComments(String[] comments) {
        this.comments = comments;
    }*/
}

