package com.bridgelabz.indiancricketteam;

import android.graphics.Bitmap;

/**
 * Created by bridgelabz1 on 23/6/16.
 */

public class ModelTeamPlayer {
    String name;
    Bitmap image;
    String role;
    String batstyle;
    String bowlstyle;

    public ModelTeamPlayer(String name, Bitmap image, String role, String batstyle, String bowlstyle) {
        this.name = name;
        this.image = image;
        this.role = role;
        this.batstyle = batstyle;
        this.bowlstyle = bowlstyle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getBatstyle() {
        return batstyle;
    }

    public void setBatstyle(String batstyle) {
        this.batstyle = batstyle;
    }

    public String getBowlstyle() {
        return bowlstyle;
    }

    public void setBowlstyle(String bowlstyle) {
        this.bowlstyle = bowlstyle;
    }
}
