package com.bridgelabz.audiovideoplayers;

import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import java.util.concurrent.TimeUnit;
import java.util.logging.Handler;

public class AudioPlayer extends AppCompatActivity {

    SeekBar seekBar;
    Button start, stop, pause;
    MediaPlayer mediaPlayer;
    Handler myHandler= new Handler();
    int startTime =12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_player);
        SeekBar progress = (SeekBar) findViewById(R.id.seekbar);
        mediaPlayer = MediaPlayer.create(this, R.raw.song);
        start = (Button) findViewById(R.id.start);
        stop = (Button) findViewById(R.id.stop);
        pause = (Button) findViewById(R.id.pause);
        seekBar.setProgress((int)startTime);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  mediaPlayer.reset();
                mediaPlayer.start();
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.pause();
            }
        });


        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
            }
        });


    }

    Runnable UpdateSongTime = new Runnable() {
        public void run() {
            startTime = mediaPlayer.getCurrentPosition();
            tx1.setText(String.format("%d min, %d sec",

                    TimeUnit.MILLISECONDS.toMinutes((long) startTime),
                    TimeUnit.MILLISECONDS.toSeconds((long) startTime) -
                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.
                                    toMinutes((long) startTime)))
            );
            seekBar.setProgress((int)startTime);
            myHandler.postDelayed(this, 100);
        }
    };

}
