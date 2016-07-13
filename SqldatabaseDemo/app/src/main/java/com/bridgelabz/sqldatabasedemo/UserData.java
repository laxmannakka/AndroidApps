package com.bridgelabz.sqldatabasedemo;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UserData extends AppCompatActivity {
    DataBaseHandler db;
    String name1,number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_data);

         db = new DataBaseHandler(this);

        Button submit = (Button)findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText name = (EditText)findViewById(R.id.name);
                EditText num  =(EditText)findViewById(R.id.number);

                String name1,number;
                name1=name.getText().toString();
                number = num.getText().toString();
                db.addContactToDataBase(new ContactModel(name1,number));
                Toast.makeText(getApplicationContext(),"added data Sucessfully ",Toast.LENGTH_LONG).show();


            }
        });
    }
}
