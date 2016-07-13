package com.bridgelabz.datastorage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayReadData extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_read_data);
        Intent myintent = getIntent();
        String msg = myintent.getExtras().getString("key");
        TextView view =(TextView)findViewById(R.id.display);
        view.setText(msg);

    }
}
