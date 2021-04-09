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

public class MSongPlaying extends AppCompatActivity {

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
        SharedPreferences songNameShrd = getSharedPreferences("songNameShrd", MODE_PRIVATE);
        String setSongName = songNameShrd.getString("songNameESP", "");
        String setArtistName = songNameShrd.getString("artistNameESP","");
        int setSongImageId = songNameShrd.getInt("songImageIdESP", 0);
        int givenSetSongId= songNameShrd.getInt("songIdESP",0);
        String givenVideoId = songNameShrd.getString("songVideoIdESP", "");
        int Mbool = songNameShrd.getInt("Mbool",0);


//        Toast.makeText(MSongPlaying.this, "Hello " + setArtistName , Toast.LENGTH_SHORT).show();

        if(Mbool == 1 && Mbool !=0) {
            TextView songName = (TextView) findViewById(R.id.songName);
            songName.setText(setSongName);

            TextView artistName = (TextView) findViewById(R.id.artistName);
            artistName.setText(setArtistName);

            ImageView songImage = (ImageView) findViewById(R.id.songImage);
            songImage.setImageResource(setSongImageId);

            LinearLayout songLayout = (LinearLayout) findViewById(R.id.songLayout);
            songLayout.setBackgroundResource(setSongImageId);
            songLayout.getBackground().setAlpha(180);

            setSongId = givenSetSongId;
        }
//        else if(Dbool == 1 && Dbool !=0){Dlaunch(DsetSongName, DsetArtistName, DsetSongImageId, DgivenSetSongId);}

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


    public void songVideo(View view){
        startActivity(new Intent(MSongPlaying.this, MsongVideo.class));
    }
}

