package com.bridgelabz.indianpremiearleageemvvm.model;

import android.graphics.Bitmap;

/**
 * Created by bridgelabz1 on 7/7/16.
 */

public class IplTeamsinfo  {
    String mTeamname;
    String owner;
    Bitmap image;
    String url;

    public IplTeamsinfo(String mTeamname, String owner, Bitmap image,String url) {
        this.mTeamname = mTeamname;
        this.owner = owner;
        this.image = image;
        this.url =url;
    }

    public String getmTeamname() {
        return mTeamname;
    }

    public void setmTeamname(String mTeamname) {
        this.mTeamname = mTeamname;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
