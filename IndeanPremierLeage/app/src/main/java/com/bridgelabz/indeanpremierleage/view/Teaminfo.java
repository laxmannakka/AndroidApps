package com.bridgelabz.indeanpremierleage.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Switch;
import android.widget.Toast;

import com.bridgelabz.indeanpremierleage.R;
import com.bridgelabz.indeanpremierleage.controller.HttpconnectionManager;
import com.bridgelabz.indeanpremierleage.model.TeamMembarsInfo;
import com.bridgelabz.indeanpremierleage.utility.DisplayMembersRecycleadapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Teaminfo extends AppCompatActivity {
    Context context;
    RecyclerView recyclerView;
    ArrayList<TeamMembarsInfo> membersList;
    DisplayMembersRecycleadapter adapter;
    public static String BASE_URL = "http://192.168.0.132/laxman/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teaminfo);
        Intent intent = getIntent();
        int value = intent.getIntExtra("Key", 0);

        Toast.makeText(getApplicationContext(), "in teaminfo activity int ne tvalue" + value, Toast.LENGTH_LONG).show();
        recyclerView = (RecyclerView) findViewById(R.id.recylerview1);
        membersList = new ArrayList<>();
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

    public class Mytask extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... params) {
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

                    membersList.add(new TeamMembarsInfo(playername, role, Battingstyle, Bowlinstyle, Nationality, player_dob, image));

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }


            return "sss";
        }

        @Override
        protected void onPostExecute(String s) {
            //  LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
            recyclerView.setLayoutManager(mLayoutManager);
/*
            recyclerView.setItemAnimator(new DefaultItemAnimator());
*/
            adapter = new DisplayMembersRecycleadapter(membersList, getApplicationContext());
            recyclerView.setAdapter(adapter);
        }
    }


}
