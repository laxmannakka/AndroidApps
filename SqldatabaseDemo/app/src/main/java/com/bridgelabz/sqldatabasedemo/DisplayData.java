package com.bridgelabz.sqldatabasedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class DisplayData extends AppCompatActivity {

    List<ContactModel> contacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_data);

        DataBaseHandler db = new DataBaseHandler(this);
         contacts = db.getAllContacts();
        AdapterCursor adapter = new AdapterCursor(contacts,DisplayData.this);
         ListView listview =(ListView)findViewById(R.id.listview);
        listview.setAdapter(adapter);



        }

    }
