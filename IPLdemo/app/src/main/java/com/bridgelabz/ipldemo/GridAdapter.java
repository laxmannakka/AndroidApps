package com.bridgelabz.ipldemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by bridgelabz1 on 29/6/16.
 */

public class GridAdapter extends BaseAdapter {
    Context mContext;
    List<Bitmap> bitmaps;

    public GridAdapter(Context mContext, List<Bitmap> bitmaps) {
        this.mContext = mContext;
        this.bitmaps = bitmaps;
    }



    @Override
    public int getCount() {
        return bitmaps.size();
    }

    @Override
    public Object getItem(int position) {
        return bitmaps.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ImageView imageView;
        if (convertView == null) {
            imageView = new ImageView(mContext);

            imageView.setLayoutParams(new GridView.LayoutParams(300, 300));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(10, 10, 10, 10);
        } else {
            imageView = (ImageView) convertView;
        }
        imageView.setImageBitmap(bitmaps.get(position));
        return imageView;

    }

    /**
     * Created by bridgelabz1 on 30/6/16.
     */

    public static class Model  {
        String playername;
        String role;
        String battingstyle;
        String bowlingstyle;
        String nationality;
        String dob;
        Bitmap image;

        public Model(String playername, String role, String battingstyle, String bowlingstyle, String nationality, String dob, Bitmap image) {
            this.playername = playername;
            this.role = role;
            this.battingstyle = battingstyle;
            this.bowlingstyle = bowlingstyle;
            this.nationality = nationality;
            this.dob = dob;
            this.image = image;
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

        public String getBattingstyle() {
            return battingstyle;
        }

        public void setBattingstyle(String battingstyle) {
            this.battingstyle = battingstyle;
        }

        public String getBowlingstyle() {
            return bowlingstyle;
        }

        public void setBowlingstyle(String bowlingstyle) {
            this.bowlingstyle = bowlingstyle;
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

        public Bitmap getImage() {
            return image;
        }

        public void setImage(Bitmap image) {
            this.image = image;
        }
    }
}
