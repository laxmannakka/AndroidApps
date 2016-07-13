package com.bridgelabz.datastorage;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class InternalStorage extends AppCompatActivity {

    // filename
    String filename = "Bridgelabz";
    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal_storage);
        // creating the objects of Buttons
        Button write = (Button) findViewById(R.id.write);
        Button read = (Button) findViewById(R.id.read);


        // write Button press This action will perform
        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Initilizing the Edit text
                EditText Textmessage = (EditText) findViewById(R.id.entertext);

                // taking the data from Edittext
                message = Textmessage.getText().toString();
                try {
                    //file outpi=ut stream t will create if file not exist
                    FileOutputStream file = openFileOutput(filename, MODE_PRIVATE);
                    // Writing the data to file
                    file.write(message.getBytes());
                    // closing the file
                    file.close();

                } catch (Exception e) {

                }
            }
        });


        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Message;
                // for Stores the reading data
                StringBuffer  ReadMsg = new StringBuffer();
                try
                {
                    //to open a file
                    FileInputStream file = openFileInput(filename);
                    // for reading the Streams
                    InputStreamReader Inputreader = new InputStreamReader(file);
                    //it will read the Buffer
                    BufferedReader Bufferreader = new BufferedReader(Inputreader);
                    while ((message = Bufferreader.readLine()) != null) {
                        ReadMsg.append(message +"\n");
                    }


                }
                catch(Exception e)
                {

                }
                // showing the data in another activit
                Intent display = new Intent(getApplicationContext(),DisplayReadData.class);
                display.putExtra("key",ReadMsg.toString()); // putting the data into intent
                startActivity(display);//start the activitjy



            }
        });

    }
}