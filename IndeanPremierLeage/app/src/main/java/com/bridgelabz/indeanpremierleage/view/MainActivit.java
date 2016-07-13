package com.bridgelabz.indeanpremierleage.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.bridgelabz.indeanpremierleage.R;

public class MainActivit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button mTeams = (Button) findViewById(R.id.listofteams);
        mTeams.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mListofteams;
                mListofteams = new Intent(MainActivit.this,DisplayTeam.class);
                startActivity(mListofteams);
            }
        });

    }
}
