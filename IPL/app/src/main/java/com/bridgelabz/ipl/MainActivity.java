package com.bridgelabz.ipl;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data);
        GridView gridView = (GridView) findViewById(R.id.gridview);
        gridView.setAdapter(new Imageadapter(this));


    }
}
