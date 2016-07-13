package com.bridgelabz.asyntaskjson2;
import com.bridgelabz.asyntaskjson2.MainActivity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by bridgelabz1 on 21/6/16.
 */

public class HttpConnect {

        // Function for get the data from json

    public static String  getdata(String uri){
        URL url;
        InputStream in;
        try {
            url = new URL(uri);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            in = new BufferedInputStream(urlConnection.getInputStream());
            // Calling the convertStrean to String
            return convertStreamToString(in);


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
    //--Method to convert the stream data into the string
    public Bitmap getBitmapData(String uri, final ImageView imageView){
        new GetImage(){
            @Override
            protected void onPostExecute(Bitmap bitmap) {

                super.onPostExecute(bitmap);
            }
        }.execute(uri);
        return null;
    }

    //--Convert imageUrl to Image
    public static Bitmap urlToImageDownload(String imgUrl) {
        Bitmap bitmap = null;
        try {
            URL url = new URL(imgUrl);

            bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    private static String convertStreamToString(java.io.InputStream is) {
        java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";

    }

    public class GetImage extends AsyncTask<String,Void,Bitmap>{

        @Override
        protected Bitmap doInBackground(String... params) {

            URL url;
            InputStream in;
            try {
                url = new URL(params[0]);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                InputStream abc = urlConnection.getInputStream();
                return BitmapFactory.decodeStream(abc);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return  null;
        }



    }



}
