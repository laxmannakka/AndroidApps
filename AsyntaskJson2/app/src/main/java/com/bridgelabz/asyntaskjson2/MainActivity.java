package com.bridgelabz.asyntaskjson2;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.bridgelabz.asyntaskjson2.HttpConnect.getdata;
import static com.bridgelabz.asyntaskjson2.R.id.image;
import static com.bridgelabz.asyntaskjson2.R.id.recyleview;

public class MainActivity extends AppCompatActivity {

    String url;
    public ImageView image1;

    ArrayList<Player> listplayer;
    PlayerAdapter mAdapter;
    Bitmap encodedPhoto;
    public RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_acivity);
        url = "http://192.168.0.120/laxman/doc2.json";
        Mytask myTask = new Mytask();
        recyclerView = (RecyclerView) findViewById(R.id.recyleview);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        listplayer = new ArrayList<Player>();
        mAdapter = new PlayerAdapter(MainActivity.this, listplayer);

        myTask.execute(url);


    }

    public class Mytask extends AsyncTask<String, String, String> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... params) {
            String Content = getdata(params[0]);
            Log.i("Tag", "content is " + Content);
            return Content;
        }

        @Override
        protected void onPostExecute(String Content) {
            try {
                JSONObject Root = new JSONObject(Content);
                JSONArray jsonArray = Root.optJSONArray("Player");
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    String str;
                    String Name = jsonObject.getString("name");
                    String Postion = jsonObject.getString("position");
                    String btmapurl = jsonObject.getString("photo");


                    //Bitmap photo= getBitmapFromURL(url);
                    HttpConnect connect = new HttpConnect();
                    connect.getBitmapData(btmapurl, image1);
                    listplayer.add(new Player())


                    //image1.setImageBitmap(HttpConnect.urlToImageDownload(btmapurl));


                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

            recyclerView.setAdapter(mAdapter);

        }


    }



}


