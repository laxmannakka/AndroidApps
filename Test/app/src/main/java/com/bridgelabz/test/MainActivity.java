package com.bridgelabz.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    LinearLayout ll;

    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.abc);
        b= (Button)findViewById(R.id.button);
        b.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(b==v)
        {
            Intent i = new Intent(this,Cc.class);
            startActivity(i);
        }

    }
}
