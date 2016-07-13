package com.bridgelabz.firebasechatapplication.view;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.bridgelabz.firebasechatapplication.R;
import com.bridgelabz.firebasechatapplication.viewholder.TeamviewHolder;
import com.bridgelabz.firebasechatapplication.model.TeamsModel;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Creating the fire database referance

        FirebaseDatabase database = FirebaseDatabase.getInstance();

        // getting the REfernce
        DatabaseReference myRef = database.getReference("ipl");

        // Initilizing the recylerview
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);

        /*Creating the FireBaseRecycler adapter
        * it will take model class  ,modelview class,layout and referance
        * Automatically fetch the data from firebase
        * */

        FirebaseRecyclerAdapter<TeamsModel,TeamviewHolder> adapter = new FirebaseRecyclerAdapter<TeamsModel, TeamviewHolder>(TeamsModel.class,R.layout.recyle,TeamviewHolder.class,myRef) {

            /* Populateview holer Method  we have to set the viewholder data */

            @Override
           protected void populateViewHolder(final TeamviewHolder viewHolder, TeamsModel model, final int position) {

               viewHolder.Teamname.setText(model.getTeamname());
               viewHolder.owner.setText(model.getOwner());

                // Creating the Firebase Refferance
                StorageReference mystorage = FirebaseStorage.getInstance().getReference();
               // Pointing to root node
                mystorage = mystorage.getRoot();
                // Taking url from model
               String uri = model.getUrl();
               mystorage = mystorage.child(uri);

                //Method for Downloading the image
                final long ONE_MEGABYTE = 1024 * 1024;
               mystorage.getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
                    @Override
                    public void onSuccess(byte[] bytes) {
                        // Converting bytes array to Bitmap
                        Bitmap bitmap = BitmapFactory.decodeByteArray(bytes , 0, bytes .length);
                        // Setting the image to our view
                        viewHolder.imageView.setImageBitmap(bitmap);

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        // Handle any errors
                    }
                });

               // when image clicks it will open new activity
                viewHolder.imageView.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       Intent  intent = new Intent(MainActivity.this,TeamPlayerview.class);
                       // Storing the position of intent
                       intent.putExtra("Key",position);
                       Toast.makeText(getApplicationContext(),"Message"+position,Toast.LENGTH_LONG).show();
                       startActivity(intent);
                   }
               });

            }
       };

        // Recycler view setthe adapter
        recyclerView.setAdapter(adapter);
    }

}
