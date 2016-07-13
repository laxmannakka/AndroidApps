package com.bridgelabz.ipldemo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.bridgelabz.ipldemo.R;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by bridgelabz1 on 29/6/16.
 */

public class HttpInnternetmanager {

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


    private static String convertStreamToString(java.io.InputStream is) {
        java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }


    public static Bitmap getdataImages(String uri) {
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

    public static class DisplayTeam extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_display_team);
            Intent intent = getIntent();
            int keyValue = intent.getIntExtra("TEAM_NAME", 0);

            TextView Teamnamedisplay = (TextView) findViewById(R.id.textview);
            RecyclerView recylerview = (RecyclerView) findViewById(R.id.recycleview);
            //   Mynetworkoperation obj = new Mynetworkoperation();
            if (keyValue == 0) {
                Teamnamedisplay.setText("DD");
                String url = "http://192.168.0.118/laxman/ddteam.json";
                //      obj.execute(url);
            } else if (keyValue == 1)
                Teamnamedisplay.setText("srh");
            else if (keyValue == 3)
                Teamnamedisplay.setText("MI");

        }
    }
}