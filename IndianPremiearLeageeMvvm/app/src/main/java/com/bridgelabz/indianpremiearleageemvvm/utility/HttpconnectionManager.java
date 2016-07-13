package com.bridgelabz.indianpremiearleageemvvm.utility;

import android.databinding.BindingAdapter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import com.bridgelabz.indianpremiearleageemvvm.R;
import com.squareup.picasso.Picasso;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by bridgelabz1 on 23/6/16.
 */

public class HttpconnectionManager {
    public static String getDataFromjson(String uri) {
        URL url;
        InputStream in;
        try {

            url = new URL(uri);

            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            in = new BufferedInputStream(httpURLConnection.getInputStream());
            // Calling the convertStrean to String
            return convertStreamToString(in);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    private static String convertStreamToString(InputStream is) {
        java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";

    }


    public static Bitmap imageDownload(String uri) {
        URL url;
        InputStream image;
        try {
            url = new URL(uri);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            image = new BufferedInputStream(httpURLConnection.getInputStream());
            return BitmapFactory.decodeStream(image);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }


    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView view, String imageUrl) {

        Picasso.with(view.getContext())
                .load(imageUrl)
                .placeholder(R.drawable.images)
                .into(view);
    }
}

