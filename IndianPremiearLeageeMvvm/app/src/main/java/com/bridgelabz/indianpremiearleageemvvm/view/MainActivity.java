package com.bridgelabz.indianpremiearleageemvvm.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.bridgelabz.indianpremiearleageemvvm.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Initilizing the Button
        Button  mlistofteams = (Button) findViewById(R.id.listofteams);

        //when Button press it display teams
        mlistofteams.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent teams = new Intent(MainActivity.this,IplTeamview.class);
                startActivity(teams);
            }
        });

    }
}
