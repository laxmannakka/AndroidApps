package com.bridgelabz.audiovideoplayers;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button audioButton, videoButton, recorderButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        audioButton = (Button) findViewById(R.id.audiobutton);
        videoButton = (Button) findViewById(R.id.videobutton);
        recorderButton = (Button) findViewById(R.id.recorder);

        audioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Audioplayer = new Intent(MainActivity.this, AudioPlayer.class);
                startActivity(Audioplayer);
            }
        });

        videoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Videoplayer = new Intent(MainActivity.this, VideoPlayer.class);
                startActivity(Videoplayer);
            }
        });
        recorderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Recorder = new Intent(MainActivity.this, RecorderVoice.class);
            }


        });


    }
}











