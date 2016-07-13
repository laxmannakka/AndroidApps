package com.bridgelabz.asyntaskjson2;

import android.graphics.Bitmap;

/**
 * Created by bridgelabz1 on 21/6/16.
 */

public class Player {
    String Name;
    String position;
    Bitmap photo;

    public Bitmap getPhoto() {
        return photo;
    }

    public void setPhoto(Bitmap photo) {
        this.photo = photo;
    }



    public Player(String name, String position, Bitmap photo) {
        Name = name;
        this.position = position;
        this.photo = photo;
    }

    public String getName() {

        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }


}
