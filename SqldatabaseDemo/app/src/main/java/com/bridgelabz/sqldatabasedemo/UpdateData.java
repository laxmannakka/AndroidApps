package com.bridgelabz.sqldatabasedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateData extends AppCompatActivity {

    DataBaseHandler db = new DataBaseHandler(this);
    String newname;
    String id;
    String newnumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_data);


        final Button submit = (Button)findViewById(R.id.update);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText edit1 = (EditText) findViewById(R.id.newid);
                EditText edit2 =(EditText)findViewById(R.id.newname);
                EditText edit3 =(EditText)findViewById(R.id.newnumber);

                id =   edit1.getText().toString();
                newname   =       edit2.getText().toString();
                newnumber =  edit3.getText().toString();
              Integer update =  db.updateContact(id,newname,newnumber);
                Toast.makeText(getApplicationContext(),"contact whose id="+id+" Updated Successfully",Toast.LENGTH_LONG).show();
            }
        });

    }
}
