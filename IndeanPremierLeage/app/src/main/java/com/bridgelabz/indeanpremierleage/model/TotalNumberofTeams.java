package com.bridgelabz.indeanpremierleage.model;

        import android.graphics.Bitmap;

/**
 * Created by bridgelabz1 on 4/7/16.
 */

public class TotalNumberofTeams {
    String mTeamname;
    String owner;
    Bitmap image;


    public TotalNumberofTeams(String mTeamname, String owner) {
        this.mTeamname = mTeamname;
        this.owner = owner;
    }

    public TotalNumberofTeams(String mTeamname, String owner, Bitmap image) {
        this.mTeamname = mTeamname;
        this.owner = owner;
        this.image = image;
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
}
