package com.bridgelabz.linearlayoutdemo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import android.widget.AdapterView.OnItemSelectedListener;

public class ActivitySpinner extends AppCompatActivity implements OnItemSelectedListener {

    ArrayAdapter<CharSequence> adapter;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        // Initilizing the Spinner object
        spinner = (Spinner) findViewById(R.id.spinner);

        // calling on item selected listner
        spinner.setOnItemSelectedListener(ActivitySpinner.this);

        // Spinner Drop down elements
        // Creating The array List
        ArrayList<String> categories = new ArrayList<String>();
        // Adding Element to List
        categories.add("india");
        categories.add("pakistan");
        categories.add("afganistan");
        categories.add("bangladsh");
        categories.add("newzeland");
        categories.add("srilanka");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);

    }
        @Override
        public void onItemSelected (AdapterView < ? > parent, View view,int position, long id){
            // On selecting a spinner item
            String item = parent.getItemAtPosition(position).toString();

            // Showing selected spinner item
            Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
        }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

}








