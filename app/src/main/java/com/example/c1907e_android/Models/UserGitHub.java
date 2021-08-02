package com.example.c1907e_android.Models;

public class UserGitHub {
    private int id;
    private String login;
    private String avatar_url;
    private String type;

    public UserGitHub() {
    }

    public UserGitHub(int id, String login, String avatar_url, String type) {
        this.id = id;
        this.login = login;
        this.avatar_url = avatar_url;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
