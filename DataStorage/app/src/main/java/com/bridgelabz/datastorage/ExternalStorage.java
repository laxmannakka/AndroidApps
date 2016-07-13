package com.bridgelabz.datastorage;

import android.os.Environment;
import android.provider.DocumentsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.zip.ZipFile;

public class ExternalStorage extends AppCompatActivity {
    String Message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_external_storage);
        Button read =(Button)findViewById(R.id.read1);
        Button write =(Button)findViewById(R.id.write1);
        EditText DataWrite = (EditText)findViewById(R.id.getdata);

         Message =DataWrite.getText().toString();

        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String state;
                state = Environment.getExternalStorageState();
                if(Environment.MEDIA_MOUNTED.equals(state))
                {
                    File root = Environment.getExternalStorageDirectory();
                    File Dir  = new File(root.getAbsolutePath()+"/MYfile");
                  if(!Dir.exists()) {
                      Dir.mkdir();
                  }
                    File file = new File(Dir,"MYapp.txt");
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        fileOutputStream.write(Message.getBytes());
                        fileOutputStream.close();
                        Toast.makeText(getApplicationContext()," Message Saved",Toast.LENGTH_LONG).show();



                    }
                    catch(Exception e)
                    {

                    }
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"SD card  Not found",Toast.LENGTH_LONG).show();
                }


            }
        });


        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File root = Environment.getExternalStorageDirectory();
                File Dir  = new File(root.getAbsolutePath()+"/MYfile");
                String message;
                File file = new File(Dir,"MYapp.txt");
                try {

                    FileInputStream reader = new FileInputStream(file);
                    InputStreamReader inputStreamReader = new InputStreamReader(reader);
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    StringBuffer Buffer = new StringBuffer();
                    while ((message=bufferedReader.readLine()) != null)
                    {
                        Buffer.append(message +"\n");
                    }
                    TextView show = (TextView)findViewById(R.id.viewread);
                    show.setText(Buffer);


                }
                catch (Exception e){

                }
            }
        });

    }
}
