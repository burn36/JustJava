package com.example.android.justjava;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SecondActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mediaPlayer = MediaPlayer.create(this, R.raw.sample);

    }
    public void play(View view){
        mediaPlayer.start();

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mediaPlayer.stop();
    }
    public void back(View v){
        onBackPressed();
    }


}
