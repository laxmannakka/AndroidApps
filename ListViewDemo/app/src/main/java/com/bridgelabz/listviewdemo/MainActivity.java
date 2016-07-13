package com.bridgelabz.listviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Creating The Array of Objects of UserInfo class
        final ArrayList<UserInfo> userinfolist;
        userinfolist = new ArrayList<UserInfo>();

        // Adding The Elements in ArrayLIst userinfolist

        UserInfo user1 =new UserInfo("laxman","nakka");
        UserInfo user2 =new UserInfo("Mohummad","Chota");
        UserInfo user3 =new UserInfo("Shelly","Pichards");
        userinfolist.add(new UserInfo("venkat","ipee"));
        userinfolist.add(new UserInfo("Balaram","dyagala"));

        userinfolist.add(user1);
        userinfolist.add(user2);
        userinfolist.add(user3);

        // Creating The Adapter of THe arraylist
        UserAdapter adapter = new UserAdapter(MainActivity.this,userinfolist);
        // Initilize the listview Object
        ListView listView = (ListView) findViewById(R.id.list);

        // set the Adpter in listview
        listView.setAdapter(adapter);

        // when Clicking The Item it will show the Information about that item
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,"Selected Item at Position "+position +" "+userinfolist.get(position).getName()+" " +userinfolist.get(position).getSurname() ,Toast.LENGTH_LONG).show();

            }
        });
    }
}
