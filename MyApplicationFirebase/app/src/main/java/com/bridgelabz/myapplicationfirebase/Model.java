package com.bridgelabz.myapplicationfirebase;

/**
 * Created by bridgelabz1 on 9/7/16.
 */

public class Model {

    String name;
    String url;
    String position;

    public Model(String name, String url, String position) {
        this.name = name;
        this.url = url;
        this.position = position;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
