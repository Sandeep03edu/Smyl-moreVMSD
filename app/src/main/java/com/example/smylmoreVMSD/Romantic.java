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

public class Romantic extends AppCompatActivity {

    public String songName;
    public String artistName;
    public int songImageId;
    public int songId;
    public int Rbool = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.album_listview);


        // Declaring via Array List
//
        ArrayList<albumVar> songsList = new ArrayList<albumVar>();
        songsList.add(new albumVar("Jaan Ban Gaye","Mithoon",R.drawable.r_jaan_ban_gaye, R.raw.r_jaan_ban_gaye,"https://youtu.be/a6cJAFFQn_I"));
        songsList.add(new albumVar("Lut Gaye","Jubin Nautiyal",R.drawable.r_lut_gaye, R.raw.r_lut_gaye,"https://youtu.be/tGOAbgrCu9Q"));
        songsList.add(new albumVar("Dil Meri Na Sune","Atif Aslam",R.drawable.r_dil_meri_na_sune, R.raw.r_dil_meri_na_sune,"https://youtu.be/YZLKoG_vhDY"));
        songsList.add(new albumVar("Tera Fitoor","Arijit Singh",R.drawable.r_tera_fitoor, R.raw.r_tera_fitoor,"https://youtu.be/saYfjjUQ6xw"));
        songsList.add(new albumVar("Kaun Tujhe","Armaan Malik",R.drawable.r_kaun_tujhe, R.raw.r_kaun_tujhe,"https://youtu.be/U6-17svR6qw"));
        songsList.add(new albumVar("Khamoshiyan","Arijit Singh",R.drawable.r_khamoshiyan, R.raw.r_khamoshiyan,"https://youtu.be/Mv3SZDP7QUo"));

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
                Rbool = 1;
//                Toast.makeText(Motivational.this,"Hello "+ songName + artistName, Toast.LENGTH_SHORT).show();
//
                // Sharing songName
                SharedPreferences RsongNameShrd = getSharedPreferences("RsongNameShrd", MODE_PRIVATE);
                SharedPreferences.Editor RsongNameEditor = RsongNameShrd.edit();
                RsongNameEditor.putString("RsongNameESP", songName);
                RsongNameEditor.putString("RartistNameESP", artistName);
                RsongNameEditor.putInt("RsongImageIdESP", songImageId);
                RsongNameEditor.putInt("RsongIdESP", songId);
                RsongNameEditor.putInt("Rbool",Rbool);
                RsongNameEditor.putString("RsongVideoIdESP", songVideoId);
                RsongNameEditor.commit();

                Toast.makeText(Romantic.this, "Launching " + songName + " Song", Toast.LENGTH_SHORT).show();

                //Launching song.java Class
                startActivity(new Intent(Romantic.this, RSongPlaying.class));

            }
        });
    }

}



