package com.bridgelabz.practicerecycleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<StudentData> list ;
    StudentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = new ArrayList<StudentData>();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycle);
        adapter = new StudentAdapter(list);
    //    RecyclerView.LayoutManager mlayoutmanager = new LinearLayoutManager(getApplicationContext());
     //   recyclerView.setLayoutManager(mlayoutmanager);
        recyclerView.setAdapter(adapter);






        list.add(new StudentData("laxman","1","hindi"));
        list.add(new StudentData("shelly","2","maths"));
        list.add(new StudentData("sourav","3","chemistry"));

    }
}
