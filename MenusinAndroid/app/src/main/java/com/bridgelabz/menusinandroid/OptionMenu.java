package com.bridgelabz.menusinandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class OptionMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option_menu);

    }

    // When Creating the the options menu
    public boolean onCreateOptionsMenu(Menu menu) {
    // This function takes the xml file from menu.xml
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    // Onitem selected Functions
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch(item.getItemId())
        {
            case R.id.item1:
                Toast.makeText(getApplicationContext(),"Item1 Selected",Toast.LENGTH_LONG).show();
            case R.id.item2:
                Toast.makeText(getApplicationContext(),"Item2 Selected",Toast.LENGTH_LONG).show();
            case R.id.item3 :
                Toast.makeText(getApplicationContext(),"Item3 Selected",Toast.LENGTH_LONG).show();
                default:
                    return super.onOptionsItemSelected(item);


        }

    }
}

