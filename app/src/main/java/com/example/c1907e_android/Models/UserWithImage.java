package com.example.c1907e_android.Models;

public class UserWithImage {
    private String username;
    private String imgLink;

    public UserWithImage() {
    }

    public UserWithImage(String username, String imgLink) {
        this.username = username;
        this.imgLink = imgLink;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImgLink() {
        return imgLink;
    }

    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }
}
