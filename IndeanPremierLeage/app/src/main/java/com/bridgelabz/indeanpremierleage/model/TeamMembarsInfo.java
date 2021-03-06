package com.bridgelabz.indeanpremierleage.model;

import android.graphics.Bitmap;

/**
 * Created by bridgelabz1 on 6/7/16.
 */

public class TeamMembarsInfo  {
    String playername;
    String role;
    String battingStyle;
    String bowlingStyle;
    String nationality;
    String dob;
    Bitmap playerphoto;

    public TeamMembarsInfo(String playername, String role, String battingStyle, String bowlingStyle, String nationality, String dob, Bitmap playerphoto) {
        this.playername = playername;
        this.role = role;
        this.battingStyle = battingStyle;
        this.bowlingStyle = bowlingStyle;
        this.nationality = nationality;
        this.dob = dob;
        this.playerphoto = playerphoto;
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

    public void setDob(String dob) {
        this.dob = dob;
    }

    public Bitmap getPlayerphoto() {
        return playerphoto;
    }

    public void setPlayerphoto(Bitmap playerphoto) {
        this.playerphoto = playerphoto;
    }
}
