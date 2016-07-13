package com.bridgelabz.indianpremiearleageemvvm.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bridgelabz.indianpremiearleageemvvm.R;
import com.bridgelabz.indianpremiearleageemvvm.adapters.PlyersRecyleviewAdapter;
import com.bridgelabz.indianpremiearleageemvvm.controller.IplPlayerinfoController;
import com.bridgelabz.indianpremiearleageemvvm.controller.IplTeamsinfoController;
import com.bridgelabz.indianpremiearleageemvvm.iplteamviewmodel.PlayerinfoViewmodel;
import com.bridgelabz.indianpremiearleageemvvm.model.PlayerInfo;
import com.bridgelabz.indianpremiearleageemvvm.utility.HttpconnectionManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class IplPlayersview extends AppCompatActivity {

    Context context;
    RecyclerView recyclerView;
    ArrayList<PlayerInfo> mPlayerdata;
    public static String BASE_URL = "http://192.168.0.132/laxman/";
    PlyersRecyleviewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ipl_players_info);
        Intent intent = getIntent();
        int value = intent.getIntExtra("Key", 0);


        recyclerView = (RecyclerView) findViewById(R.id.playerrecycleview);
        mPlayerdata = new ArrayList<>();
        Mytask getjson = new Mytask();

        switch (value) {

            case 0: {
                String url = "sunrisershyd.json";
                getjson.execute(BASE_URL + url);
                break;
            }

            case 1: {
                String url = "mumbhaiindians.json";
                getjson.execute(BASE_URL + url);
                break;
            }
            case 2: {
                String url = "roylachalengersbangalore.json";
                getjson.execute(BASE_URL + url);
                break;
            }
            case 3: {
                String url = "risingpunewariors.json";
                getjson.execute(BASE_URL + url);
                break;
            }
            case 4: {
                String url = "kingspunjab.json";
                getjson.execute(BASE_URL + url);
                break;
            }
            case 5: {
                String url = "delhidaredevils.json";
                getjson.execute(BASE_URL + url);
                break;
            }
            case 6: {
                String url = "gujaratlions.json";
                getjson.execute(BASE_URL + url);
                break;
            }
            case 7: {
                String url = "kolkatanigthriders.json";
                getjson.execute(BASE_URL + url);
                break;
            }

        }

    }


    public class Mytask extends AsyncTask<String, String, ArrayList> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected ArrayList doInBackground(String... params) {
            String jsondata = HttpconnectionManager.getDataFromjson(params[0]);
            try {
                JSONArray jsonArray = new JSONArray(jsondata);
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);

                    String playername = jsonObject.getString("player_name");
                    String role = jsonObject.getString("player_role");
                    String Battingstyle = jsonObject.getString("player_batting_style");
                    String Bowlinstyle = jsonObject.getString("player_bowling_style");
                    String Nationality = jsonObject.getString("player_nationality");
                    String player_dob = jsonObject.getString("player_dob");
                    String imageurl = jsonObject.getString("player_img_url");
                    Bitmap image = HttpconnectionManager.imageDownload(BASE_URL + imageurl);
                    mPlayerdata.add(new PlayerInfo(playername, role, Battingstyle, Bowlinstyle, Nationality, player_dob, imageurl, image));

                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
            return mPlayerdata;
        }


        @Override
        protected void onPostExecute(ArrayList arrayList) {


            ArrayList<PlayerinfoViewmodel> viewmodelplayerdata = IplPlayerinfoController.setPlayersInfo(arrayList);

            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
            recyclerView.setLayoutManager(mLayoutManager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            adapter = new PlyersRecyleviewAdapter(IplPlayersview.this,viewmodelplayerdata);
            recyclerView.setAdapter(adapter);





        }
    }
}


