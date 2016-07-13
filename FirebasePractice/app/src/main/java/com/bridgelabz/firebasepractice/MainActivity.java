package com.bridgelabz.firebasepractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FirebaseDatabase mref = FirebaseDatabase.getInstance();

         DatabaseReference myRef = mref.getReference("Player ");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Map<String ,String> map = dataSnapshot.getValue(Map.class);
                String name = map.get("name");
                String pos =map.get("position");
                Log.i("Tag","NAme is "+name+"posittion "+pos);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                String laxman="";

            }
        });

    }
}