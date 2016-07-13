package com.bridgelabz.linearlayoutdemo2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.telephony.gsm.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class IntentSecond extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_second);

        Button send = (Button) findViewById(R.id.send);

        // sms Intent Sending Sms
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText1 = (EditText) findViewById(R.id.editText);
                EditText editText2 = (EditText) findViewById(R.id.editText1);
                String number = editText1.getText().toString();
                String msg = editText2.getText().toString();
                Intent sendIntent = new Intent(Intent.ACTION_VIEW);
                //setData is used to Set the data to though link
                sendIntent.setData(Uri.parse("sms:"));
                // Add extended data to the intent
                sendIntent.putExtra("sms_body", msg);
                sendIntent.putExtra("address", number);
                startActivity(sendIntent);
               // Toast.makeText(getApplicationContext(),"MEssage send Succesfully",Toast.LENGTH_LONG).show();
            }
        });



    }
}
