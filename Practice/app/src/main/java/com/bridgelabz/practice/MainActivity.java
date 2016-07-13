package com.bridgelabz.practice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button but = (Button) findViewById(R.id.button);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //     processdata();
                jsonarraydata();
                Toast.makeText(getApplicationContext(), "NAme is", Toast.LENGTH_LONG).show();
            }
        });


    }


   /* void processdata() {
        String JSON_STRING = "{\"employee\":{\"name\":\"Sachin\",\"salary\":56000}}";
       // String Json ="{\"student\":{\"id\":\"21\"}}";
        try {
            JSONObject obj = (new JSONObject(JSON_STRING)).getJSONObject("employee");
            String empname = obj.getString("name");
            String sal = obj.getString("salary");
            Toast.makeText(getApplicationContext(), "NAme is " + empname  "salary is " + sal, Toast.LENGTH_LONG).show();

        } catch (JSONException e) {
            e.printStackTrace();
        }
        }*/


    void jsonarraydata() {

        String JsonArray = "{\"student\":[{\"Name\":\"laxman\",\"id\":\"21\"}, {\"Name\" :\"sourav\",\"id\":\"22\"}]}";
        JSONObject obj = null;
        try {
            obj = new JSONObject(JsonArray);

            JSONArray array = obj.getJSONArray("student");
            for (int i = 0; i < array.length(); i++) {
                JSONObject jsonObject = array.getJSONObject(i);
                String name = jsonObject.optString("Name").toString();
                int id = Integer.parseInt(jsonObject.optString("id").toString());
                Toast.makeText(getApplicationContext(), "Name is " + name + "\n" + "id is" + id, Toast.LENGTH_LONG).show();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

}


