package com.bridgelabz.myapplicationfirebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static android.R.attr.data;

public class MainActivity extends AppCompatActivity {

    ArrayList<Model> listmodel;

    public class Data{
        int birthYear;
        String fullName;

        public int getBirthYear() {
            return birthYear;
        }

        public void setBirthYear(int birthYear) {
            this.birthYear = birthYear;
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("ppp");
        /*for(int i=0;i<6;i++)
            myRef.push().setValue(new Data("jdlkj","difjui","dfi"));*/

        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                //final Data readdata= new Data();

                GenericTypeIndicator<Map<String,Data>> t=new GenericTypeIndicator<Map<String,Data>>(){};
                Map<String,Data> userList=dataSnapshot.getValue(t);
                ArrayList<Data> list = userList.get("key");

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}




















       /* myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
            *//*Map<String ,String> map = dataSnapshot.getValue(Map.class);
                String name = map.get("name");
                String position =map.get("develpment");
                String id =map.get("id");*//*
                String data = dataSnapshot.toString();
                try {
                    JSONArray jsonroot = new JSONArray(dataSnapshot.toString());
                    for (int i=0;i<jsonroot.length();i++){
                        JSONObject jsonObject=jsonroot.getJSONObject(i);
                        jsonObject.getString("name");
                        jsonObject.getString("id");
                        jsonObject.getString("develpment");
                        Toast.makeText(MainActivity.this,"Data : "+jsonObject.getString("name")+
                                jsonObject.getString("id")+
                                jsonObject.getString("develpment"),Toast.LENGTH_LONG).show();

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

*/




