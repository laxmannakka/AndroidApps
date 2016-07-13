package com.bridgelabz.indeanpremierleage.viewmodel;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

import com.bridgelabz.indeanpremierleage.controller.HttpconnectionManager;
import com.bridgelabz.indeanpremierleage.model.TotalNumberofTeams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


/**
 * Created by bridgelabz1 on 5/7/16.
 */

public class IplTeam  extends AppCompatActivity {

    ArrayList<TotalNumberofTeams> teams;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);


    }
}