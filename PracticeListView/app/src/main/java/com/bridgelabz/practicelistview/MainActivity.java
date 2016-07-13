package com.bridgelabz.practicelistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Employee employee;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView list = (ListView)findViewById(R.id.listview);
        employee= new Employee("laxman","21","Android");
        Employee emp2  = new Employee("shelly","22","ios");

        ArrayList<Employee> employees = new ArrayList<Employee>();
        Employee emp1 = new Employee("mahumad","24","android");
        employees.add(emp1);
        employees.add(new Employee("Sourav","21","llllaxman"));
        employees.add(new Employee("venkat","21","java"));

        UserAdapter adapter = new UserAdapter(this,employees);


        list.setAdapter(adapter);


/*
        for(Employee lax:employees)
        {
            Log.i("TAG",lax.name+ " "+lax.id+" "+lax.designation);
        }*/









    }
}
