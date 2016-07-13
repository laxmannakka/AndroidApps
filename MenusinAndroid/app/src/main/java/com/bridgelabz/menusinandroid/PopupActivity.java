package com.bridgelabz.menusinandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PopupActivity extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_menu);
        // initilize the Button oject
        button = (Button) findViewById(R.id.popup);
        // when button clicked this operation will perform
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // creating the object of popupmenu
                PopupMenu popupmenu = new PopupMenu(PopupActivity.this, button);

                // getting the xml file
                popupmenu.getMenuInflater().inflate(R.menu.popup, popupmenu.getMenu());
                popupmenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(PopupActivity.this, "You Clicked : " + item.getTitle(), Toast.LENGTH_SHORT).show();
                        return true;

                    }
                });
                popupmenu.show();//showing popup menu

            }


        });//closing the setOnClickListener method
    }



}