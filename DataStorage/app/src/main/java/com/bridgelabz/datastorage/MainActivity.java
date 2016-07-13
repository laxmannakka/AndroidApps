package com.bridgelabz.datastorage;

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

        // creating the Objects of buttons
        Button button1 =(Button)findViewById(R.id.internal);
        Button button2 = (Button)findViewById(R.id.external);

        // When Button1 Press it will open the Internal Storag class
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Internal = new Intent(MainActivity.this,InternalStorage.class);
                startActivity(Internal);
            }
        });

        // when Button2 press it will open the ExternalStorage class

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent External =new Intent(MainActivity.this,ExternalStorage.class);
                startActivity(External);

            }
        });
    }
}
