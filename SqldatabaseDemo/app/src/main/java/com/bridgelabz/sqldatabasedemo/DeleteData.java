package com.bridgelabz.sqldatabasedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteData extends AppCompatActivity {

    DataBaseHandler db = new DataBaseHandler(this);

    EditText edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_data);
        edit= (EditText) findViewById(R.id.text1);
        Button delete = (Button)findViewById(R.id.delete1);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer deleterow = db.deletedata(edit.getText().toString());
                if(deleterow>0)
                    Toast.makeText(getApplicationContext(),"Item deleted Suscesfully",Toast.LENGTH_LONG).show();
            }
        });
    }
}
