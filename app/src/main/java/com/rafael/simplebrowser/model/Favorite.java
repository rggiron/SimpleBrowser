package com.rafael.simplebrowser.model;

/**
 * Created by htpc on 23/01/2015.
 */
public class Favorite
{
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private int id;
    private String name;
    private String url;


    public Favorite(int id, String name, String url) {
        this.id = id;
        this.name = name;
        this.url = url;
    }
}
