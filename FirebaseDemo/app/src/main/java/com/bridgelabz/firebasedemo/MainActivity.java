package com.bridgelabz.firebasedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

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
        Map<String ,String> map = null;


        FirebaseDatabase database =FirebaseDatabase.getInstance();
        DatabaseReference myref = database.getReference("Player");
        // myref.setValue("hello,woeld");

      myref.addValueEventListener(new ValueEventListener() {
          @Override
          public void onDataChange(DataSnapshot dataSnapshot) {

              Map<String ,String> map = dataSnapshot.getValue(Map.class);
             String name = map.get("name");
              Toast.makeText(getApplicationContext(),"mesage is"+name,Toast.LENGTH_LONG).show();


          }

              @Override
          public void onCancelled(DatabaseError databaseError) {

          }
      });




    }
}
