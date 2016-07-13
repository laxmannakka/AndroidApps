package com.bridgelabz.menusinandroid;

import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.view.ContextMenu.ContextMenuInfo;

public class ContextMenu extends AppCompatActivity {
ListView listview;
    String contacts[]= {"laxman","shelly","mohamud","venkat"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context_menu);

        // Creating the Object of listview
        listview =(ListView) findViewById(R.id.listview);
        // creating the Array adapter to to stores the contacts
        ArrayAdapter<String> list= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,contacts);

        // seting the adapter array to list
        listview.setAdapter(list);
        // Prevents a context menu to be shown for the given view
        registerForContextMenu(listview);
    }

//    onCreateContextMen will be called when it is time to show the context menu.
    @Override
    public void onCreateContextMenu(android.view.ContextMenu menu, View v, ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Select The Action");
        menu.add(0, v.getId(), 0, "Call");//groupId, itemId, order, title
        menu.add(0, v.getId(), 0, "SMS");
    }

    // When Item was selected from a list this function will invokes
    @Override
    public boolean onContextItemSelected(MenuItem item){
        if(item.getTitle()=="Call"){
            Toast.makeText(getApplicationContext(),"calling code",Toast.LENGTH_LONG).show();
        }
        else if(item.getTitle()=="SMS"){
            Toast.makeText(getApplicationContext(),"sending sms code",Toast.LENGTH_LONG).show();
        }else{
            return false;
        }
        return true;
    }
}




