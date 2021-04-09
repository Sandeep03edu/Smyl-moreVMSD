package com.example.smylmoreVMSD;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class songs_layout extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.songslist);

    // Use of WordAdapter class
            ArrayList<Word> number = new ArrayList<Word>();
            number.add(new Word("One", "Ek"));
            number.add(new Word("Two", "Do"));
            number.add(new Word("Three", "Teen"));
            number.add(new Word("Four", "Chaar"));
            number.add(new Word("Five", "Paanch"));
            number.add(new Word("Six", "Chaih"));
            number.add(new Word("Seven", "Saat"));
            number.add(new Word("Eight", "Aath"));
            number.add(new Word("Nine", "No"));
            number.add(new Word("Ten", "Das"));

            WordAdapter Adapter = new WordAdapter(this, number);
            ListView listView = (ListView) findViewById(R.id.number);
            listView.setAdapter(Adapter);

    }
}