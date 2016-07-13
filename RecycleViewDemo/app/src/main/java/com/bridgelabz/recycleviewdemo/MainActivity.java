package com.bridgelabz.recycleviewdemo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Employee> emplyeelist;
    RecyclerView recyclerview;
    EmployeeAdapter madapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        emplyeelist = new ArrayList<Employee>();
        recyclerview = (RecyclerView) findViewById(R.id.recyclerView);
        madapter = new EmployeeAdapter(emplyeelist);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerview.setLayoutManager(mLayoutManager);
        recyclerview.setItemAnimator(new DefaultItemAnimator());
        recyclerview.setAdapter(madapter);
        getdata();
    }

    private void getdata() {

        emplyeelist.add(new Employee("laxman","1","Android"));
        emplyeelist.add(new Employee("Mohummud","2","Android"));
        emplyeelist.add(new Employee("shell","3","ios"));
        emplyeelist.add(new Employee("Eshwar","4","Android"));
        emplyeelist.add(new Employee("Sourabh","5","java"));
        emplyeelist.add(new Employee("balram","6","java"));
        emplyeelist.add(new Employee("ippe","7","android"));

        for(Employee lax : emplyeelist) {
        Log.i("TAg",lax.name+" "+lax.id+" "+lax.designation);

        }

    }


  

}
