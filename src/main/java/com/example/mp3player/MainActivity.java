package com.example.mp3player;

import android.app.Activity;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.mp3player.R;

//import static com.example.myapplication.R.id.firstSong;

public class MainActivity extends AppCompatActivity {

    ImageView image;
    MediaPlayer musicPlayer;
    RadioGroup radioGroup;
    RadioButton radioButton;
    RadioButton radioButton1;
    RadioButton radioButton2;
    RadioButton radioButton3;
    RadioButton radioButton4;
    boolean initial = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioGroup = findViewById(R.id.radioGroup);
        image = (ImageView) findViewById(R.id.imageView3);

    }

    public void playMusic(View v)
    {
        int radioID = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioID);
        radioButton1= findViewById(R.id.firstSong);
        radioButton2 = findViewById(R.id.secondSong);
        radioButton3 = findViewById(R.id.thirdSong);

        if (radioButton != radioButton4)
        {
            stopMusic(v);
        }
        radioButton4 = radioButton;
        if (radioButton == radioButton1)
        {
            if (musicPlayer == null)
            {
                image.setImageResource(R.drawable.boxershorts);
                musicPlayer = MediaPlayer.create(this, R.raw.poorboxershortss);
                musicPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        releasePlayer();
                    }
                });
            }
        }
        else if (radioButton == radioButton2)
        {
            if (musicPlayer == null)
            {
                image.setImageResource(R.drawable.vapepng);
                musicPlayer = MediaPlayer.create(this, R.raw.vapenationn);
                musicPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        releasePlayer();
                    }
                });
            }
        }
        else if (radioButton == radioButton3)
        {
            if (musicPlayer == null)
            {
                image.setImageResource(R.drawable.max);
                musicPlayer = MediaPlayer.create(this, R.raw.youcanteatcatskevinn);
                musicPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        releasePlayer();
                    }
                });
            }
        }


        musicPlayer.start();
    }

    public void pauseMusic (View v)
    {
        if (musicPlayer != null)
        {
            musicPlayer.pause();
        }
    }

    public void stopMusic (View v)
    {
        releasePlayer();
    }

    private void releasePlayer()
    {
        if (musicPlayer != null)
        {
            musicPlayer.release();
            musicPlayer = null;

        }
    }



}
