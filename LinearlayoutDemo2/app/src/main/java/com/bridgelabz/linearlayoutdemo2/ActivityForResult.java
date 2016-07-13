package com.bridgelabz.linearlayoutdemo2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ActivityForResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_result);

    }
    // when Press the submit button this operation perform
    public void submitButtonClick(View view){
        // initilizing the Edit text object
        EditText text=(EditText)findViewById(R.id.text);

        // Creating the intent for main class
        Intent intent=new Intent(ActivityForResult.this,MainActivity.class);
        // adding data to intent
        intent.putExtra("MESSAGE",text.getText().toString());

        //Call this to set the result that your activity will return to its caller
        setResult(245,intent);
        // closing the activity
        finish();
    }
}
