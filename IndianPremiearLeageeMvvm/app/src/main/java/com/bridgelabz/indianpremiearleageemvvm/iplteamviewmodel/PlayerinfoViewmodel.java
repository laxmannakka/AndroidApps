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

public class PlayerinfoViewmodel extends BaseObservable{

    String playername;
    String role;
    String battingStyle;
    String bowlingStyle;
    String nationality;
    String dob;
    Bitmap playerphoto;
    String uri;

    public PlayerinfoViewmodel(String playername, String role, String battingStyle, String bowlingStyle, String nationality, String dob, Bitmap playerphoto) {
        this.playername = playername;
        this.role = role;
        this.battingStyle = battingStyle;
        this.bowlingStyle = bowlingStyle;
        this.nationality = nationality;
        this.dob = dob;
        this.playerphoto = playerphoto;
    }

    public PlayerinfoViewmodel(String playername, String role, String battingStyle, String bowlingStyle, String nationality, String dob, String url) {
        this.playername = playername;
        this.role = role;
        this.battingStyle = battingStyle;
        this.bowlingStyle = bowlingStyle;
        this.nationality = nationality;
        this.dob = dob;
        this.uri = url;
    }

    public String getPlayername() {
        return playername;
    }

    public void setPlayername(String playername) {
        this.playername = playername;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getBattingStyle() {
        return battingStyle;
    }

    public void setBattingStyle(String battingStyle) {
        this.battingStyle = battingStyle;
    }

    public String getBowlingStyle() {
        return bowlingStyle;
    }

    public void setBowlingStyle(String bowlingStyle) {
        this.bowlingStyle = bowlingStyle;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getDob() {
        return dob;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public Bitmap getPlayerphoto() {
        return playerphoto;
    }

    public void setPlayerphoto(Bitmap playerphoto) {
        this.playerphoto = playerphoto;
    }


    @BindingAdapter({"bind:imageUri"})
    public static void loadImage(ImageView view, String imageUrl) {
        Picasso.with(view.getContext())
                .load(imageUrl)
                .placeholder(R.drawable.images)
                .into(view);
    }
}
