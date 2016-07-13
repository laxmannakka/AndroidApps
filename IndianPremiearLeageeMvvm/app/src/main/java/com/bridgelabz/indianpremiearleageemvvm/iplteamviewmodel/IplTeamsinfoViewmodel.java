package com.bridgelabz.indianpremiearleageemvvm.iplteamviewmodel;

import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.bridgelabz.indianpremiearleageemvvm.R;
import com.squareup.picasso.Picasso;

/**
 * Created by bridgelabz1 on 7/7/16.
 */

public class IplTeamsinfoViewmodel extends BaseObservable{
    String teamname;
    String owner;
    String url;

    public IplTeamsinfoViewmodel() {
    }

    public IplTeamsinfoViewmodel(String teamname, String ownerName) {
        this.teamname=teamname;
        this.owner =ownerName;
    }

    public IplTeamsinfoViewmodel(String teamname, String owner, String url) {
        this.teamname = teamname;
        this.owner = owner;
        this.url =url;

    }

    public String getTeamname() {
        return teamname;
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView view, String imageUrl) {
        Picasso.with(view.getContext())
                .load(imageUrl)
                .placeholder(R.drawable.images)
                .into(view);
    }


}
