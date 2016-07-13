package com.bridgelabz.sqldatabasedemo;

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
        Button getDetails = (Button)findViewById(R.id.Enter_Content);
        Button display  =(Button)findViewById(R.id.display);

        getDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent getData = new Intent(MainActivity.this,UserData.class);
                startActivity(getData);
            }
        });

        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent display = new Intent(MainActivity.this,DisplayData.class);
                startActivity(display);

            }
        });

        Button delete = (Button)findViewById(R.id.delete);
                delete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent delete = new Intent(MainActivity.this,DeleteData.class);
                        startActivity(delete);
                    }
                });
        Button update = (Button)findViewById(R.id.update);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent update = new Intent(MainActivity.this,UpdateData.class);
                startActivity(update);
            }
        });

    }
}
