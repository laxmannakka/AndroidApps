package com.bridgelabz.alertdialouge;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Custom extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);
        Dialog dialog = new Dialog(Custom.this);
        dialog.setTitle("Custom Dialog");
        dialog.setContentView(R.layout.custom);

        dialog.show();
    }
}
