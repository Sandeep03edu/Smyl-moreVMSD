package com.example.smylmoreVMSD;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class album_layout extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.album_layout);


// Declaring via Array List
//
//            ArrayList<String> albumName = new ArrayList<String>();
//            albumName.add("Top songs");
//            albumName.add("Motivational");
//            albumName.add("Romantic");
//            albumName.add("Devotional");
//            albumName.add("Sad songs");
//            albumName.add("VIP access");
//
//         ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, albumName);
//         ListView listView = (ListView) findViewById(R.id.album_list_view);
//         listView.setAdapter(itemsAdapter);
//
//

//        ArrayList<albumVar> album = new ArrayList<albumVar>();
//
//        album.add(new albumVar("Motivational", R.drawable.bg_album));
//        album.add(new albumVar("Motivational", R.drawable.bg_album));
//        album.add(new albumVar("Motivational", R.drawable.bg_album));
//        album.add(new albumVar("Motivational", R.drawable.bg_album));
//
//        albumAdapter Adapter = new albumAdapter(this, album);
//        ListView listView = (ListView) findViewById(R.id.album_list_view);
//        listView.setAdapter(Adapter);

//        ArrayList<albumVar> number = new ArrayList<albumVar>();
////                        Word w = new Word("One" , "lutti");
////                        number.add(w);
//        number.add(new albumVar("One" , R.drawable.placeholder));
//        number.add(new albumVar("Two" , R.drawable.placeholder));
//        number.add(new albumVar("One" , R.drawable.placeholder));
//        number.add(new albumVar("Two" , R.drawable.placeholder));
//
//        albumAdapter Adapter = new albumAdapter(this, number);
//        ListView listView = (ListView) findViewById(R.id.album_list_view);
//        listView.setAdapter(Adapter);

    }
//    public void TOP(View view){
//        startActivity(new Intent(album_layout.this, MusicMainActivity.class));
//    }

    public void romantic(View view){
        startActivity(new Intent(album_layout.this, Romantic.class));
    }

    public void motivational(View view){
        startActivity(new Intent(album_layout.this, Motivational.class));
    }
    public void devotional(View view){
        startActivity(new Intent(album_layout.this, Devotional.class));
    }
//    public void sad(View view){
//        startActivity(new Intent(album_layout.this, Sad.class));
//    }
    public void vip(View view){
        startActivity(new Intent(album_layout.this, VIPTestCase.class));
    }
    public void musicPlayer(View view){
        startActivity(new Intent(album_layout.this, MusicMainActivity.class));
    }

}
