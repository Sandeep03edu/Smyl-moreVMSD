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

public class VSongPlaying extends AppCompatActivity {

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

//
        // Accessing songNameShrd
        SharedPreferences VsongNameShrd = getSharedPreferences("VsongNameShrd", MODE_PRIVATE);
        String VsetSongName = VsongNameShrd.getString("VsongNameESP", "");
        String VsetArtistName = VsongNameShrd.getString("VartistNameESP","");
        int VsetSongImageId = VsongNameShrd.getInt("VsongImageIdESP", 0);
        int VgivenSetSongId= VsongNameShrd.getInt("VsongIdESP",0);
        int Vbool = VsongNameShrd.getInt("Vbool",0);

//        Toast.makeText(VSongPlaying.this, "Hello " + setArtistName , Toast.LENGTH_SHORT).show();


        Vlaunch(VsetSongName, VsetArtistName, VsetSongImageId, VgivenSetSongId);

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

    public void Vlaunch(String DsetSongName, String DsetArtistName , int DsetSongImageId, int DgivenSetSongId){

        TextView songName = (TextView) findViewById(R.id.songName);
        songName.setText(DsetSongName);

        TextView artistName = (TextView) findViewById(R.id.artistName);
        artistName.setText(DsetArtistName);

        ImageView songImage = (ImageView) findViewById(R.id.songImage);
        songImage.setImageResource(DsetSongImageId);

        LinearLayout songLayout = (LinearLayout) findViewById(R.id.songLayout);
        songLayout.setBackgroundResource(DsetSongImageId);
//        songLayout.getBackground().setAlpha(200);

        setSongId = DgivenSetSongId;
    }
    public void songVideo(View view){
        startActivity(new Intent(VSongPlaying.this, VsongVideo.class));
    }
    }



