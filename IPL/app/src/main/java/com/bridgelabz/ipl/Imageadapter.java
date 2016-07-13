package com.bridgelabz.ipl;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by bridgelabz1 on 28/6/16.
 */

public class Imageadapter extends BaseAdapter {
    Context mContext;


    public Imageadapter(Context mContext) {
        this.mContext = mContext;
    }



    @Override
    public int getCount() {
        return imageArray.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
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
        imageView.setImageResource(imageArray[position]);
        return imageView;


    }

    int imageArray[] = {R.drawable.dd, R.drawable.gl, R.drawable.kkr, R.drawable.kip, R.drawable.mi, R.drawable.rcb, R.drawable.srh, R.drawable.rps};
}
