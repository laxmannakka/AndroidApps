package com.bridgelabz.services;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartService extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_service);

        Button start = (Button) findViewById(R.id.start);
        Button stop = (Button) findViewById(R.id.stop);
        Button back = (Button) findViewById(R.id.back);

        start.setOnClickListener(this);
        stop.setOnClickListener(this);
        back.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start:
                startService(new Intent(this, Myservice.class));

                break;

            case R.id.stop:
                stopService(new Intent(this, Myservice.class));
                break;
            case R.id.back:
                Intent back = new Intent(this, MainActivity.class);
                startActivity(back);
                break;
        }

    }


}

