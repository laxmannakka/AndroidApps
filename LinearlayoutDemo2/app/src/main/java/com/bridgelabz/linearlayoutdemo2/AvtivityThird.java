package com.bridgelabz.linearlayoutdemo2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AvtivityThird extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avtivity_third);

        String key = getIntent().getStringExtra("match");

        Bundle b = getIntent().getExtras();
        String serch = b.getString("match");

        if (key.equals("A")) {
            // Receiving The Intent Data  and Storing in Respective Variables
            String extract = getIntent().getStringExtra("key");
            String cc = getIntent().getStringExtra("CC");
            String msg = getIntent().getStringExtra("MSG");
            Log.i(extract, " ");
            Toast.makeText(getApplicationContext(), "" + extract, Toast.LENGTH_LONG).show();

            // Initializing The EditTEXTS and Set The data to that EditText

            EditText edit = (EditText) findViewById(R.id.to);
            edit.setText(extract);
            EditText cc1 = (EditText) findViewById(R.id.id);
            cc1.setText(cc);
            EditText msg1 = (EditText) findViewById(R.id.message);
            msg1.setText(msg);
        } else if (serch.equals("B")) {

            String username = b.getString("key");
            String CC = b.getString("cc");
            String MSG = b.getString("msg");
            EditText edit = (EditText) findViewById(R.id.to);
            edit.setText(username);
            EditText cc1 = (EditText) findViewById(R.id.id);
            cc1.setText(CC);
            EditText msg2 = (EditText) findViewById(R.id.message);
            msg2.setText(MSG);

        }

        // it is going for back activity
        Button button = (Button) findViewById(R.id.back);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });


    }


}
