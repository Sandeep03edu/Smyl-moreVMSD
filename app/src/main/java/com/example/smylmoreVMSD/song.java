package com.example.smylmoreVMSD;

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

public class song extends AppCompatActivity {
    MediaPlayer player;
    int setSongId;
    String setSongName;
    String setArtistName;
    int setSongImageId;

    SeekBar seekBar;
    Handler handler;
    Runnable runnable;

//    TextView songName = (TextView)findViewById(R.id.songName);
//    TextView artistName = (TextView)findViewById(R.id.artistName);
//    ImageView songImage = (ImageView)findViewById(R.id.songImage);
    LinearLayout songLayout = (LinearLayout)findViewById(R.id.songLayout);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song);


//// Accessing Motivational songNameShrd
        SharedPreferences MsongNameShrd = getSharedPreferences("MsongNameShrd", MODE_PRIVATE);
        String setMSongName = MsongNameShrd.getString("MsongNameESP", "");
        String setMArtistName = MsongNameShrd.getString("MartistNameESP","");
        int setMSongImageId = MsongNameShrd.getInt("MsongImageIdESP", 0);
        int setMSongId = MsongNameShrd.getInt("MsongIdESP",0);
        int setMbool = MsongNameShrd.getInt("Mbool",0);


        if(setMbool == 1){
            Toast.makeText(song.this, "Test" ,Toast.LENGTH_SHORT).show();
            String setSongName = setMSongName;
            setArtistName = setMArtistName;
            setSongImageId = setMSongImageId;
            setSongId = setMSongId;
        }
//        else{
//            Vlaunch();
//        }
//        Toast.makeText(song.this, "Hello " + setSongName + "Artist " + setArtistName , Toast.LENGTH_SHORT).show();

//Setting songName
        TextView songName = (TextView)findViewById(R.id.songName);
        songName.setText(setSongName);
//
//// Setting artistName
        TextView artistName = (TextView)findViewById(R.id.artistName);
        artistName.setText(setArtistName);
//
//// Setting songImage
        ImageView songImage = (ImageView)findViewById(R.id.songImage);
        songImage.setImageResource(setSongImageId);


// Setting Backgroung
        songLayout.setBackgroundResource(setSongImageId);

// Setting Background Alpha Value
//        songLayout.getBackground().setAlpha(180);


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

//    public void Vlaunch(){
//        // Accessing Vip songNameShrd
//        SharedPreferences VsongNameShrd = getSharedPreferences("VsongNameShrd", MODE_PRIVATE);
//        String setVSongName = VsongNameShrd.getString("VsongNameESP", "");
//        String setVArtistName = VsongNameShrd.getString("VartistNameESP","");
//        int setVSongImageId = VsongNameShrd.getInt("VsongImageIdESP", 0);
//        int setVSongId = VsongNameShrd.getInt("VsongIdESP",0);
//
//        songName.setText(setVSongName);
//        artistName.setText(setVArtistName);
//        songImage.setImageResource(setVSongImageId);
//        songLayout.setBackgroundResource(setVSongImageId);
//
//
//    }
//
//    public void Mlaunch(){
//// Accessing Motivational songNameShrd
//        SharedPreferences MsongNameShrd = getSharedPreferences("MsongNameShrd", MODE_PRIVATE);
//        String setMSongName = MsongNameShrd.getString("MsongNameESP", "");
//        String setMArtistName = MsongNameShrd.getString("MartistNameESP","");
//        int setMSongImageId = MsongNameShrd.getInt("MsongImageIdESP", 0);
//        int setMSongId = MsongNameShrd.getInt("MsongIdESP",0);
//        int setMbool = MsongNameShrd.getInt("Mbool",0);
//
//        songName.setText(setMSongName);
//        artistName.setText(setMArtistName);
//        songImage.setImageResource(setMSongImageId);
//        songLayout.setBackgroundResource(setMSongImageId);
//
//    }

}
