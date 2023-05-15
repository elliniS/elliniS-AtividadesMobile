package com.example.mediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    MediaPlayer mediaPlayer;
    ImageButton btPlay, btStop, btPause;

    AudioManager audioManager;

    SeekBar sbAudio, sbTime;
    TextView tvTemp;
    private Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.seminovos);
        btPlay  = findViewById(R.id.bntPlay);
        btPause = findViewById(R.id.bntPause);
        btStop = findViewById(R.id.bntStop);
        sbAudio = findViewById(R.id.sbAudio);
        tvTemp = findViewById(R.id.tvTemp);
        sbTime = findViewById(R.id.sbTime);


        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        iniciarSeekBarAudio();

        sbTime.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser) {
                    seekBar.setMax(mediaPlayer.getDuration());
                    mediaPlayer.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        sbAudio.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, AudioManager.FLAG_SHOW_UI);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        btPlay.setOnClickListener(this);
        btPause.setOnClickListener(this);
        btStop.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bntPlay:
                mediaPlayer.start();
                timerCounter();
                break;
            case R.id.bntPause:
                mediaPlayer.pause();
                break;
            case R.id.bntStop:
                mediaPlayer.stop();
                mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.seminovos);
                break;
        }
    }

    public String convertDurationMillis(Integer getDurationInMillis){

        int getDurationMillis = getDurationInMillis;
        String convertHours = String.format("%02d", TimeUnit.MILLISECONDS.toHours(getDurationMillis));
        String convertMinutes = String.format("%02d", TimeUnit.MILLISECONDS.toMinutes(getDurationMillis));
        String convertSeconds = String.format("%02d", TimeUnit.MILLISECONDS.toSeconds(getDurationMillis) -
                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(getDurationMillis)));

        String getDuration = convertHours + ":" + convertMinutes + ":" + convertSeconds;

        return getDuration;
    }
    public void recarregarTime(){
        tvTemp.setText(convertDurationMillis(mediaPlayer.getCurrentPosition()) + "/" +  convertDurationMillis(mediaPlayer.getDuration()));
        mediaPlayer.getCurrentPosition();

        sbTime.setMax(mediaPlayer.getDuration());
    }

    private void timerCounter(){
        timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        recarregarTime();
                        sbTime.setProgress(mediaPlayer.getCurrentPosition());
                    }
                });
            }
        };
        timer.schedule(task, 0, 100);
    }


    private void iniciarSeekBarAudio() {
        int volumeMaximo = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int volumeAtual = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        sbAudio.setMax(volumeMaximo);
        sbAudio.setProgress(volumeAtual);
    }

}