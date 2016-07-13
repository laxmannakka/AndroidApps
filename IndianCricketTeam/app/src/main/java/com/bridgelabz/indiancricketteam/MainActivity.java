package com.bridgelabz.indiancricketteam;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recycleview;
    public static final String BASE_URL ="http://192.168.0.118/laxman/";

    ArrayList<ModelTeamPlayer> listofplayers;
    TeamAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String url = "team1.json";
        recycleview = (RecyclerView)findViewById(R.id.recycleview);

        listofplayers = new ArrayList<ModelTeamPlayer>();
        MyTask Operation = new MyTask();
        Operation.execute(BASE_URL+url);
    }

  public  class MyTask extends AsyncTask<String, String, String> {



        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... params) {
            String jsondata = HttpconnectionManager.getDataFromjson(params[0]);
            try {

                JSONArray  jsonArray = new JSONArray(jsondata);
                for(int i =0;i<jsonArray.length();i++){
                    JSONObject Teamobject =  jsonArray.getJSONObject(i);
                    String name = Teamobject.getString(Keyconstant.KEY_NAME);
                    String url = Teamobject.getString(Keyconstant.KEY_IMAGE);
                    Bitmap photo = HttpconnectionManager.imageDownload(BASE_URL+url);
                    String  role = Teamobject.getString(Keyconstant.KEY_PLAYROLE);
                    String  BattingStyle = Teamobject.getString(Keyconstant.KEY_BATTINGSTYLE);
                    String Bowlingstyle = Teamobject.getString(Keyconstant.KEY_BOWLINGSTYLE);
                    listofplayers.add(new ModelTeamPlayer(name,photo,role,BattingStyle,Bowlingstyle));
                    savephotoInternalstorage(photo);
                    InternalDatabase db = new InternalDatabase(MainActivity.this);
                    db.adddatatoDatabase(new ModelTeamPlayer(name,photo,role,BattingStyle,Bowlingstyle));

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }


            return "success";
        }


      @Override
        protected void onPostExecute(String s) {
          adapter = new TeamAdapter(listofplayers);
          RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
          recycleview.setLayoutManager(mLayoutManager);
          recycleview.setItemAnimator(new DefaultItemAnimator());
          recycleview.setAdapter(adapter);
      }
    }
    void savephotoInternalstorage(Bitmap photo){




    }


}

