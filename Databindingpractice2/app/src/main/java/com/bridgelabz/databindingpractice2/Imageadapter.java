package com.bridgelabz.databindingpractice2;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

/**
 * Created by bridgelabz1 on 2/7/16.
 */

public class Imageadapter {


    @BindingAdapter("imageResource")
    public static void setImageResource(ImageView imageView, int resource) {
        imageView.setImageResource(resource);
    }
}


