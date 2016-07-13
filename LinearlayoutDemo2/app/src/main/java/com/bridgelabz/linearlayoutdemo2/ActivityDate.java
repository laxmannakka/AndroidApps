package com.bridgelabz.linearlayoutdemo2;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class ActivityDate extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);
        //initilizing the button for set date
        Button set = (Button) findViewById(R.id.setdate);

        if (set != null) {
            // defination of setonclicklistener function
            set.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Open Date picker dialog.

                    new DatePickerDialog(ActivityDate.this, new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                            TextView date = (TextView) findViewById(R.id.date);
                            date.setText("" + dayOfMonth + " / " + monthOfYear + " / " + year);
                        }
                    }, 2015, 10, 10).show();
                }
            });
        }

        Button time = (Button) findViewById(R.id.button);
        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new TimePickerDialog(ActivityDate.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        TextView time = (TextView) findViewById(R.id.time);
                        time.setText("" + hourOfDay + " : " + minute);
                    }
                }, 11, 56, true).show();


            }
        });


    }
}

