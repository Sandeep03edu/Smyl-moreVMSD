package com.example.smylmoreVMSD;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class song2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song);

//        Motivational song = new Motivational();

        // Accessing songNameShrd
        SharedPreferences songNameShrd = getSharedPreferences("songNameShrd", MODE_PRIVATE);
        String setSongName = songNameShrd.getString("songNameESP", "");
        String setArtistName = songNameShrd.getString("artistNameShrd","");
        int setSongImageId = songNameShrd.getInt("songImageIdESP", 0);


        Toast.makeText(song2.this, "Hello " + setArtistName , Toast.LENGTH_SHORT).show();

        TextView songName = (TextView)findViewById(R.id.songName);
        songName.setText(setSongName);

        TextView artistName = (TextView)findViewById(R.id.artistName);
        artistName.setText(setArtistName);

        ImageView songImage = (ImageView)findViewById(R.id.songImage);
        songImage.setImageResource(setSongImageId);




        // Declaring via Array List
//
//        ArrayList<String> albumName = new ArrayList<String>();
//        albumName.add("Top songs");
//        albumName.add("Motivational");
//        albumName.add("Romantic");
//        albumName.add("Devotional");
//        albumName.add("Sad songs");
//        albumName.add("VIP access");
//
//        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, albumName);
//        ListView listView = (ListView) findViewById(R.id.album_list_view);
//        listView.setAdapter(itemsAdapter);



    }
}

