package com.bridgelabz.practicedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public TextView num1,num2,result;
    public Button add, sub, div, mul;
    public EditText firstNum, secondNum;

    void addFunction()
    {

    }


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = (TextView) findViewById(R.id.num1);
        num2 = (TextView) findViewById(R.id.num2);
        result = (TextView) findViewById(R.id.result);
        add = (Button) findViewById(R.id.addButton);
        sub = (Button)findViewById(R.id.subButton);
        mul= (Button)findViewById(R.id.mulButton);
        div = (Button)findViewById(R.id.divButton);
        firstNum = (EditText)findViewById(R.id.numEdittext1);
        secondNum =(EditText)findViewById(R.id.numEdittext2);

        String num1 = firstNum.getText().toString();
        String num2 =secondNum.getText().toString();


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            addFunction();

            }
        });

    }
}
