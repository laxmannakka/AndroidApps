package com.bridgelabz.services;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button StartedService = (Button)findViewById(R.id.started);


        StartedService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ServiceStart = new Intent(MainActivity.this, StartService.class);
                startActivity(ServiceStart);
            }
        });





    }
}
