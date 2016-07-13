package com.bridgelabz.databindingpractice2;

import android.databinding.BaseObservable;
import android.graphics.Bitmap;
import android.widget.ImageView;

/**
 * Created by bridgelabz1 on 2/7/16.
 */

public class UserModel extends BaseObservable{
    String firstname;
    String lastname;
    Bitmap image;
    String url;

    public UserModel(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public UserModel(String firstname, String lastname, Bitmap image) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.image = image;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }
}

