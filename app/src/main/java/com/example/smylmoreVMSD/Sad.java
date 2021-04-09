package com.example.smylmoreVMSD;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class Sad extends AppCompatActivity {

    public String songName;
    public String artistName;
    public int songImageId;
    public int songId;
    public int Sbool = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.album_listview);


        // Declaring via Array List
//
        ArrayList<albumVar> songsList = new ArrayList<albumVar>();
        songsList.add(new albumVar("HelloD1","ByeD1",R.drawable.bg, R.raw.r_kaun_tujhe,""));
        songsList.add(new albumVar("HelloD2","ByeD2",R.drawable.bg, R.raw.r_kaun_tujhe,""));
        songsList.add(new albumVar("HelloD3","ByeD3",R.drawable.bg, R.raw.r_kaun_tujhe,""));
        songsList.add(new albumVar("HelloD4","ByeD4",R.drawable.bg, R.raw.r_kaun_tujhe,""));

        albumAdapter Adapter = new albumAdapter(this, songsList);
        ListView listView = (ListView) findViewById(R.id.album_list_view);
        listView.setAdapter(Adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @SuppressLint("ApplySharedPref")
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                albumVar songDetails = songsList.get(position);
                songName = songDetails.getSongName();
                artistName = songDetails.getArtistName();
                songImageId = songDetails.getSongImage();
                songId = songDetails.getSongId();
                String songVideoId = songDetails.getSongVideoId();
                Sbool = 1;
//                Toast.makeText(Motivational.this,"Hello "+ songName + artistName, Toast.LENGTH_SHORT).show();
//
                // Sharing songName
                SharedPreferences SsongNameShrd = getSharedPreferences("SsongNameShrd", MODE_PRIVATE);
                SharedPreferences.Editor SsongNameEditor = SsongNameShrd.edit();
                SsongNameEditor.putString("SsongNameESP", songName);
                SsongNameEditor.putString("SartistNameESP", artistName);
                SsongNameEditor.putInt("SsongImageIdESP", songImageId);
                SsongNameEditor.putInt("SsongIdESP", songId);
                SsongNameEditor.putInt("Sbool",Sbool);
                SsongNameEditor.putString("SsongVideoIdESP", songVideoId);
                SsongNameEditor.commit();

                Toast.makeText(Sad.this, "Happen " + artistName, Toast.LENGTH_SHORT).show();

                //Launching song.java Class
                startActivity(new Intent(Sad.this, SSongPlaying.class));

            }
        });
    }

}



