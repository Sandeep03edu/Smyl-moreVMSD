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

public class Motivational extends AppCompatActivity {



    public String songName;
    public String artistName;
    public int songImageId;
    public int songId;
    public int Mbool = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.album_listview);


        // Declaring via Array List
//
        ArrayList<albumVar> songsList = new ArrayList<albumVar>();
        songsList.add(new albumVar("Get Ready To Fight","Benny Dayal & Siddharth Basrur",R.drawable.m_get_ready, R.raw.m_get_ready,"https://youtu.be/h6aGikIL-I4"));
        songsList.add(new albumVar("KAR HAR MAIDAAN FATEH","Sukhwinder Singh & Shreya Ghoshal",R.drawable.m_kar_har_maidaan, R.raw.m_kar_har_maidaan,"https://youtu.be/9iIX4PBplAY"));
        songsList.add(new albumVar("RUK JANA NAHIN TU KAHIN HAAR KE","Kishore Kumar",R.drawable.m_ruk_jana_nahi, R.raw.m_ruk_jana_nahin,"https://youtu.be/dO7OKASr8lc"));
        songsList.add(new albumVar("Sultan Title Song","Sukhwinder Singh, Shadab Faridi",R.drawable.m_sultan, R.raw.m_sultan,"https://youtu.be/abiL84EAWSY"));
        songsList.add(new albumVar("Lakshya", "Shankar Mahadevan",R.drawable.m_lakshya,R.raw.m_lakshya, "https://youtu.be/8DMF0U6xV78"));
        songsList.add(new albumVar("Chale Chalo", "Srinivas, A.R. Rahman", R.drawable.m_chale_chalo, R.raw.m_chale_chalo, "https://youtu.be/LQmHKl3oNu0"));

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
                Mbool = 1;
//                Toast.makeText(Motivational.this,"Hello "+ songName + artistName, Toast.LENGTH_SHORT).show();
//
                // Sharing songName
                SharedPreferences songNameShrd = getSharedPreferences("songNameShrd", MODE_PRIVATE);
                SharedPreferences.Editor songNameEditor = songNameShrd.edit();
                songNameEditor.putString("songNameESP", songName);
                songNameEditor.putString("artistNameESP", artistName);
                songNameEditor.putInt("songImageIdESP", songImageId);
                songNameEditor.putInt("songIdESP", songId);
                songNameEditor.putString("songVideoIdESP", songVideoId);
                songNameEditor.putInt("Mbool",Mbool);
                songNameEditor.commit();

                Toast.makeText(Motivational.this, "Launching " + songName + " Song", Toast.LENGTH_SHORT).show();

                //Launching song.java Class
                startActivity(new Intent(Motivational.this, MSongPlaying.class));

            }
        });
    }

}



