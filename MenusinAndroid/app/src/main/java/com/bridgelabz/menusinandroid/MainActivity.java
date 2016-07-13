package com.bridgelabz.menusinandroid;

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

        // Initilizing the buttons
        Button optionmenu = (Button) findViewById(R.id.option_menu);
        final Button contextmenu = (Button) findViewById(R.id.context_menu);
        Button popupmenu =(Button)findViewById(R.id.popup);

        // when optionmenu Button will pressed in this function will invoked
    optionmenu.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // Creating the New Intent
            Intent O_menu = new Intent(getApplicationContext(),OptionMenu.class);
            // Starting The New Activity
            startActivity(O_menu);
        }
    });
        // when contextmenu Button will pressed in this function will invoked
   contextmenu.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // creating The intent
            Intent C_menu = new Intent(MainActivity.this,ContextMenu.class);
            // starting the activity
            startActivity(C_menu);
        }
    });

        // when popup Button will pressed in this function will invoked
        popupmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // creating Intent for this class
                Intent P_menu = new Intent(MainActivity.this,PopupActivity.class);
                // Starting the activity
                startActivity(P_menu);
            }
        });



    }
}
