package com.bridgelabz.services;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.SeekBar;
import android.widget.Toast;

/**
 * Created by bridgelabz1 on 11/6/16.
 */
public class Myservice extends Service {
    @Nullable
   // SeekBar seekbar ;
    MediaPlayer mediaPlayer;

    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {

        Toast.makeText(getApplicationContext(),"Created Sucessfully",Toast.LENGTH_LONG).show();

        mediaPlayer = MediaPlayer.create(this, R.raw.song);
        mediaPlayer.seekTo(20);

        mediaPlayer.setLooping(false); // Set looping
        super.onCreate();
    }

    @Override
    public void onStart(Intent intent, int startId) {
        mediaPlayer.start();

    }

    @Override
    public void onDestroy() {
        mediaPlayer.stop();

    }


}

