package com.mina.soundii;

import android.app.Activity;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {
    private Button playb;
    private Button nextb;
    private Button prevb;
    private TextView textView;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playb = (Button) findViewById(R.id.play);
        nextb = (Button) findViewById(R.id.next);
        prevb = (Button) findViewById(R.id.prev);
        textView = (TextView) findViewById(R.id.text);
        mediaPlayer = new MediaPlayer();
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.zkrt);
        playb.setOnClickListener(this);
        nextb.setOnClickListener(this);
        prevb.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.play:
                if (mediaPlayer.isPlaying()) {
                    pausesong();
                } else {
                    playsong();
                }
                break;
            case R.id.next:
                break;
            case R.id.prev:
                break;
        }

    }
    public void playsong(){
        if(mediaPlayer!=null){
            mediaPlayer.start();
            textView.setText("playing");
            playb.setBackgroundDrawable(getResources().getDrawable(android.R.drawable.ic_media_pause));
        }
    }
    public void pausesong(){
        if(mediaPlayer!=null){
            mediaPlayer.stop();
            textView.setText("Stoped");
            playb.setBackgroundDrawable(getResources().getDrawable(android.R.drawable.ic_media_play));
        }
    }protected void onDestroy() {
        if(mediaPlayer!=null&&mediaPlayer.isPlaying()){
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer=null;
        }
        super.onDestroy();
    }
}
