package com.bridgelabz.alertdialouge;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    public void startAlarm()
    {
        EditText text = (EditText)findViewById(R.id.TextAlarm);
        String num =  text.getText().toString();
        int i = Integer.parseInt(num);

        Intent brodcast = new Intent(this,Mybroadcast.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this,1234,brodcast,0);

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP,  System.currentTimeMillis()+(i*1000),pendingIntent);
        Toast.makeText(this, "Alarm set in " + i + " seconds", Toast.LENGTH_LONG).show();



    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button Alert = (Button) findViewById(R.id.alert);

        if (Alert != null) {
            Alert.setOnClickListener(new View.OnClickListener() {


                public void onClick(View v) {
                    AlertDialog .Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage("Do you Want Close")
                            .setCancelable(false)
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    finish();
                                }
                            }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.setTitle("ALert !!!!1");
                    alertDialog.show();

                }
            });
        }

        Button list = (Button)findViewById(R.id.intent);
        if (list != null) {
            list.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent list = new Intent(MainActivity.this,ListAlert.class);
                    startActivity(list);
                }
            });
        }

        Button custom = (Button)findViewById(R.id.custom);
        if (custom != null) {
            custom.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent custom = new Intent(MainActivity.this,Custom.class);
                    startActivity(custom);

                }
            });
        }


        Button Alarm = (Button)findViewById(R.id.AlaramButton);
        Alarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startAlarm();
            }
        });



    }

}