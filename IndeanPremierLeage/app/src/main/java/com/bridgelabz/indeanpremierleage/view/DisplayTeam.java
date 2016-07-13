package com.bridgelabz.indeanpremierleage.view;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.bridgelabz.indeanpremierleage.R;
import com.bridgelabz.indeanpremierleage.controller.HttpconnectionManager;
import com.bridgelabz.indeanpremierleage.model.TotalNumberofTeams;
import com.bridgelabz.indeanpremierleage.utility.ClickListener;
import com.bridgelabz.indeanpremierleage.utility.RecyclerviewTouchEvent;
import com.bridgelabz.indeanpremierleage.utility.RecylerviewAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class DisplayTeam extends AppCompatActivity {


    ArrayList<TotalNumberofTeams> teams;
    RecyclerView recyclerView;
    RecylerviewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_team);
        recyclerView = (RecyclerView) findViewById(R.id.recylerview);
        teams = new ArrayList<TotalNumberofTeams>();
        String url = "http://192.168.0.132/laxman/Teamownerandlogos.json";
        Mytask getTeamsinfo = new Mytask();
        getTeamsinfo.execute(url);
    }

    class Mytask extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... params) {
            String mJsondata = HttpconnectionManager.getDataFromjson(params[0]);
            JSONArray jsonArray = null;
            try {
                jsonArray = new JSONArray(mJsondata);
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject object = jsonArray.getJSONObject(i);
                    String Teamname = object.getString("Teamname");
                    String Ownername = object.getString("owner");
                    String url = object.getString("image");
                    Bitmap logo = HttpconnectionManager.imageDownload(url);
                    teams.add(new TotalNumberofTeams(Teamname, Ownername, logo));

                }


            } catch (JSONException e) {
                e.printStackTrace();
            }
            return "completed";
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String s) {
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
            recyclerView.setLayoutManager(mLayoutManager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            adapter = new RecylerviewAdapter(teams);
            recyclerView.setAdapter(adapter);
            recyclerView.addOnItemTouchListener(new RecyclerviewTouchEvent(getApplicationContext(), recyclerView, new ClickListener() {

                @Override
                public void onClick(View view, int position) {
                    TotalNumberofTeams obj = teams.get(position);
                    Toast.makeText(getApplicationContext(), "message clicked on" + position + "---" + obj.getmTeamname(), Toast.LENGTH_LONG).show();
                    Intent displyteaminfo;

                    displyteaminfo = new Intent(DisplayTeam.this, Teaminfo.class);
                    displyteaminfo.putExtra("Key",position);
                    startActivity(displyteaminfo);

                }

                @Override
                public void onLongClick(View view, int position) {

                }
            }));

        }
    }


}


