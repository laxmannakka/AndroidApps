package com.bridgelabz.alertdialouge;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListAlert extends AppCompatActivity implements DialogInterface.OnClickListener{

    AlertDialog ad;

    String[] names ={"laxman","shelly","Mohummad","sourabh","venalkr"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_alert);

      //ListView list = (ListView)findViewById(R.id.viewlist);
      //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,  android.R.layout.simple_list_item_1,names);
     // list.setAdapter(adapter);

        AlertDialog.Builder  builder = new AlertDialog.Builder(this);
        builder.setTitle("Select Nmaes");
        builder.setItems(names,this);
        builder.setNegativeButton("cancel",null);
        ad=builder.create();
        ad.show();





      /*  list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"item selected at position"+position,Toast.LENGTH_LONG).show();



            }
        });



*/


    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        String pos =names[which];
        Toast.makeText(getApplicationContext()," selected Item  "+pos+" position"+which,Toast.LENGTH_LONG).show();

    }
}
