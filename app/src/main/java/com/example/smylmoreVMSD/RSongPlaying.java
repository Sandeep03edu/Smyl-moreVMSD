package com.example.smylmoreVMSD;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RSongPlaying extends AppCompatActivity {

    MediaPlayer player;
    int setSongId;
    String setSongName;
    String setArtistName;
    int setSongImageId;

    SeekBar seekBar;
    Handler handler;
    Runnable runnable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song);


        // Accessing songNameShrd
        SharedPreferences RsongNameShrd = getSharedPreferences("RsongNameShrd", MODE_PRIVATE);
        String RsetSongName = RsongNameShrd.getString("RsongNameESP", "");
        String RsetArtistName = RsongNameShrd.getString("RartistNameESP","");
        int RsetSongImageId = RsongNameShrd.getInt("RsongImageIdESP", 0);
        int RgivenSetSongId= RsongNameShrd.getInt("RsongIdESP",0);
        int Rbool = RsongNameShrd.getInt("Rbool",0);

//        Toast.makeText(RSongPlaying.this, "Hello " + setArtistName , Toast.LENGTH_SHORT).show();


        Rlaunch(RsetSongName, RsetArtistName, RsetSongImageId, RgivenSetSongId);

        // Setting seekBar
        seekBar = (SeekBar)findViewById(R.id.seekBar);

        handler = new Handler();
        player = MediaPlayer.create(this, setSongId);
        player.setAudioStreamType(AudioManager.STREAM_MUSIC);

        seekBar.setMax(player.getDuration());
        playCycle();

        // seekBar Playing
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean input) {
                if(input){
                    player.seekTo(progress);
                }
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }

    public void playCycle(){
        seekBar.setProgress(player.getCurrentPosition());
        if (player.isPlaying()){
            runnable = new Runnable() {
                @Override
                public void run() {
                    playCycle();
                }
            };
            handler.postDelayed(runnable,1000);
        }
    }


    public void playSong(View v) {
        if (player == null) {
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopPlayer();
                }
            });
        }
        player.start();
    }

    public void pauseSong(View v) {
        if (player != null) {
            player.pause();
        }
    }

    public void stopSong(View v) {
        seekBar.setProgress(0);
        stopPlayer();
    }

    private void stopPlayer() {
        if (player != null) {
            player.release();
            player = null;
            Toast.makeText(this, "MediaPlayer Stopped", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onStop() {
        super.onStop();
        stopPlayer();
        // New
        handler.removeCallbacks(runnable);
    }

    public void Rlaunch(String DsetSongName, String DsetArtistName , int DsetSongImageId, int DgivenSetSongId){

        TextView songName = (TextView) findViewById(R.id.songName);
        songName.setText(DsetSongName);

        TextView artistName = (TextView) findViewById(R.id.artistName);
        artistName.setText(DsetArtistName);

        ImageView songImage = (ImageView) findViewById(R.id.songImage);
        songImage.setImageResource(DsetSongImageId);

        LinearLayout songLayout = (LinearLayout) findViewById(R.id.songLayout);
        songLayout.setBackgroundResource(DsetSongImageId);
        songLayout.getBackground().setAlpha(180);

        setSongId = DgivenSetSongId;
    }
    public void songVideo(View view){
        startActivity(new Intent(RSongPlaying.this, RsongVideo.class));
    }
}

