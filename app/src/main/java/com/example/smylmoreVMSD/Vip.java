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

public class Vip extends AppCompatActivity {

    public String songName;
    public String artistName;
    public int songImageId;
    public int songId;
    public int Vbool = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.album_listview);



        // Declaring via Array List
//
        ArrayList<albumVar> songsList = new ArrayList<albumVar>();
        songsList.add(new albumVar("Jab Tak","Armaan Malik",R.drawable.v_jab_tak, R.raw.v_jab_tak,"https://youtu.be/K-Ts-NFR62o?list=PLjkfphg9nSkrt0q70yHfbms1xdsI8LL43"));
        songsList.add(new albumVar("Phir Kabhi","Arijit Singh",R.drawable.v_phir_kabhi, R.raw.v_phir_kabhi,"https://www.youtube.com/watch?v=qVHaXD7zHDQ&list=PLjkfphg9nSkrt0q70yHfbms1xdsI8LL43&index=4"));
        songsList.add(new albumVar("Padhoge Likhoge","Ananya Nanda",R.drawable.v_pahoge_likhoge, R.raw.v_padhoge_likhoge,"https://www.youtube.com/watch?v=Yq6mzcWR0PE&list=PLjkfphg9nSkrt0q70yHfbms1xdsI8LL43&index=4"));
        songsList.add(new albumVar("Besabriyaan","Armaan Malik",R.drawable.v_besabriyaan, R.raw.v_besabriyaan,"https://www.youtube.com/watch?v=UBBHpoW3AKA&list=PLjkfphg9nSkrt0q70yHfbms1xdsI8LL43&index=5"));
        songsList.add(new albumVar("Kaun Tujhe","Amaal Malik",R.drawable.r_kaun_tujhe, R.raw.v_kaun_tujhe,"https://www.youtube.com/watch?v=atVof3pjT-I&list=PLjkfphg9nSkrt0q70yHfbms1xdsI8LL43&index=1"));
        songsList.add(new albumVar("Parwah Nahi","Amaal Malik",R.drawable.v_parwah_nahi, R.raw.v_parwah_nahin,"https://www.youtube.com/watch?v=PMXducIESQE&list=PLjkfphg9nSkrt0q70yHfbms1xdsI8LL43&index=6"));

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
                Vbool = 1;
//                Toast.makeText(Motivational.this,"Hello "+ songName + artistName, Toast.LENGTH_SHORT).show();
//
                // Sharing songName
                SharedPreferences VsongNameShrd = getSharedPreferences("VsongNameShrd", MODE_PRIVATE);
                SharedPreferences.Editor VsongNameEditor = VsongNameShrd.edit();
                VsongNameEditor.putString("VsongNameESP", songName);
                VsongNameEditor.putString("VartistNameESP", artistName);
                VsongNameEditor.putInt("VsongImageIdESP", songImageId);
                VsongNameEditor.putInt("VsongIdESP", songId);
                VsongNameEditor.putInt("Vbool",Vbool);
                VsongNameEditor.putString("VsongVideoIdESP", songVideoId);
                VsongNameEditor.commit();

                Toast.makeText(Vip.this, "Launching " + songName + " Song", Toast.LENGTH_SHORT).show();

                //Launching song.java Class
                startActivity(new Intent(Vip.this, VSongPlaying.class));

            }
        });
    }

}



