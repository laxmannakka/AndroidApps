package com.bridgelabz.databindingpractice2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<UserModel> listofdata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recylerview);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);

        recyclerView.setItemAnimator(new DefaultItemAnimator());


        listofdata = new ArrayList<>();
        listofdata.add(new UserModel("laxman","nakka",R.drawable.one));
        listofdata.add(new UserModel("Eshvar","mali"));
        listofdata.add(new UserModel("Chotta","Mohuumad"));
        listofdata.add(new UserModel("Shelly","Pichard"));
        RecyclerviewAdapter adapter= new RecyclerviewAdapter(this,listofdata);
        recyclerView.setAdapter(adapter);







    }
}
