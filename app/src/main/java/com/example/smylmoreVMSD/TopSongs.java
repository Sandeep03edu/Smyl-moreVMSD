package com.example.smylmoreVMSD;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class TopSongs extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.album_listview);

        // Declaring via Array List

        ArrayList<String> albumName = new ArrayList<String>();
        albumName.add("Top songs");
        albumName.add("Motivational");
        albumName.add("Romantic");
        albumName.add("Devotional");
        albumName.add("Sad songs");
        albumName.add("VIP access");

        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, albumName);
        ListView listView = (ListView) findViewById(R.id.album_list_view);
        listView.setAdapter(itemsAdapter);

    }
}
