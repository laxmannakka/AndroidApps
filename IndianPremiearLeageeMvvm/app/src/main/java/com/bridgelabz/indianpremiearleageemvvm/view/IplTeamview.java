package com.bridgelabz.indianpremiearleageemvvm.view;

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

import com.bridgelabz.indianpremiearleageemvvm.R;
import com.bridgelabz.indianpremiearleageemvvm.adapters.RecyclerviewAdapter;
import com.bridgelabz.indianpremiearleageemvvm.controller.IplTeamsinfoController;
import com.bridgelabz.indianpremiearleageemvvm.iplteamviewmodel.IplTeamsinfoViewmodel;
import com.bridgelabz.indianpremiearleageemvvm.model.IplTeamsinfo;
import com.bridgelabz.indianpremiearleageemvvm.utility.ClickListener;
import com.bridgelabz.indianpremiearleageemvvm.utility.HttpconnectionManager;
import com.bridgelabz.indianpremiearleageemvvm.utility.RecyclerviewTouchEvent;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class IplTeamview extends AppCompatActivity {

    RecyclerView recyclerview; // Recylerview foe displaying data
    ArrayList<IplTeamsinfo> mteamlist; // Arraylist used for Stotes the Teams data
    RecyclerviewAdapter adapter; // To handle the data collection and bind it to the view

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ipl_teamview);

        recyclerview = (RecyclerView) findViewById(R.id.recylerview); // Initilizing the recyclerview
        mteamlist = new ArrayList<>(); // Initilizing the mteamlist Arraylist

        String url = "http://192.168.0.132/laxman/Teamownerandlogos.json"; // Local database url
        Mytask operation = new Mytask();   // Creating the class of Mytask class
        operation.execute(url);  // start the asyntask

    }


    public class Mytask extends AsyncTask<String, String, ArrayList> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected ArrayList doInBackground(String... params) {

            String jsondata = HttpconnectionManager.getDataFromjson(params[0]);
            JSONArray jsonArray = null;

            try {
                jsonArray = new JSONArray(jsondata);
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    String Teamname = jsonObject.getString("Teamname");
                    String Ownername = jsonObject.getString("owner");
                    String url = jsonObject.getString("image");
                    Bitmap logo = HttpconnectionManager.imageDownload(url);
                    mteamlist.add(new IplTeamsinfo(Teamname, Ownername, logo, url));

                }


            } catch (JSONException e) {
                e.printStackTrace();
            }


            return mteamlist;
        }

        @Override
        protected void onPostExecute(ArrayList mteammemberslist) {

            final ArrayList<IplTeamsinfoViewmodel> viewmodel = IplTeamsinfoController.setViewModel(mteammemberslist);
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
            recyclerview.setLayoutManager(mLayoutManager);
            recyclerview.setItemAnimator(new DefaultItemAnimator());
            adapter = new RecyclerviewAdapter(viewmodel, IplTeamview.this);
            recyclerview.setAdapter(adapter);
            recyclerview.addOnItemTouchListener(new RecyclerviewTouchEvent(getApplicationContext(), recyclerview, new ClickListener() {

                @Override
                public void onClick(View view, int position) {
                    IplTeamsinfoViewmodel obj = viewmodel.get(position);
                    Toast.makeText(getApplicationContext(), "message clicked on" + position + "---" + obj.getTeamname(), Toast.LENGTH_LONG).show();
                    Intent displyteaminfo;

                    displyteaminfo = new Intent(IplTeamview.this, IplPlayersview.class);
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









