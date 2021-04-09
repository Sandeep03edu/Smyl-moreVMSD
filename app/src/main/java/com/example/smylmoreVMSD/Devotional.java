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

public class Devotional extends AppCompatActivity {

    public String songName;
    public String artistName;
    public int songImageId;
    public int songId;
    public int Dbool = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.album_listview);


        // Declaring via Array List
//
        ArrayList<albumVar> songsList = new ArrayList<albumVar>();
        songsList.add(new albumVar("Shree Krishna Govind Hare Murari","Maanya Arora",R.drawable.d_shree_krishna_govind, R.raw.d_shree_krishna_govind_hare_mura,"https://youtu.be/SszSt0o_UQI"));
        songsList.add(new albumVar("Sanwali Surat Pe Mohan Dil","Naushad Ali ",R.drawable.d_sawali_surat, R.raw.d_sawali_surat,"https://youtu.be/NpYNoJ6a0is"));
        songsList.add(new albumVar("Achutam Keshavam","Ankit Batra",R.drawable.d_achutam_keshavam, R.raw.d_achutam_keshavam,"https://youtu.be/gvu891ubYWE"));
        songsList.add(new albumVar("Namo Namo","Amit Trivedi ",R.drawable.d_namo_namo, R.raw.d_namo_namo,"https://youtu.be/dx4Teh-nv3A"));

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
                Dbool = 1;
//                Toast.makeText(Motivational.this,"Hello "+ songName + artistName, Toast.LENGTH_SHORT).show();
//
                // Sharing songName
                SharedPreferences DsongNameShrd = getSharedPreferences("DsongNameShrd", MODE_PRIVATE);
                SharedPreferences.Editor DsongNameEditor = DsongNameShrd.edit();
                DsongNameEditor.putString("DsongNameESP", songName);
                DsongNameEditor.putString("DartistNameESP", artistName);
                DsongNameEditor.putInt("DsongImageIdESP", songImageId);
                DsongNameEditor.putInt("DsongIdESP", songId);
                DsongNameEditor.putInt("Dbool",Dbool);
                DsongNameEditor.putString("DsongVidepIdESP", songVideoId);
                DsongNameEditor.commit();

                Toast.makeText(Devotional.this, "Launching " + songName + " Song", Toast.LENGTH_SHORT).show();

                //Launching song.java Class
                startActivity(new Intent(Devotional.this, DSongPlaying.class));

            }
        });
    }

}



