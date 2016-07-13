package com.bridgelabz.mvcpracticeexrcise.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.bridgelabz.mvcpracticeexrcise.model.Model;
import com.bridgelabz.mvcpracticeexrcise.R;
import com.bridgelabz.mvcpracticeexrcise.controller.Controller;

import java.util.ArrayList;

public class Mainactivity extends AppCompatActivity {
    Model player;
    Controller mController ;
    ArrayList<Model> listofdata;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainactivity);


        RecyclerView recyleview = (RecyclerView)findViewById(R.id.recyclewview);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyleview.setLayoutManager(mLayoutManager);
        recyleview.setItemAnimator(new DefaultItemAnimator());

        mController = new Controller();
        player=mController.model;
        listofdata = mController.getArrayList();
        ModelAdapter madapter = new ModelAdapter(listofdata);

        recyleview.setAdapter(madapter);


        for(int i=0;i<4;i++) {
            mController.setdata();
        }
       // mController.getdata();
        for(int i=0;i<4;i++) {
            Log.i("TAG", "" + player.getName());
            Log.i("TAG", "" + player.getId());
            Log.i("TAG", "" + player.getRole());
        }
    }
}
