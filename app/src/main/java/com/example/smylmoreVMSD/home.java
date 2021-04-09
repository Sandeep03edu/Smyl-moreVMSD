package com.example.smylmoreVMSD;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class home extends AppCompatActivity {
    int hindiLang;
    int latestSong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
    }
    public void disabled(View view){
        Toast.makeText(home.this, "Coming Soon!!!!", Toast.LENGTH_SHORT).show();
    }

    public void hindiLang(View view){
        hindiLang = 1;
        Button ButtonHindi = (Button) findViewById(R.id.hindiLang);
        ButtonHindi.setBackgroundColor(Color.RED);
    }

    public void latestSong(View view){
        latestSong = 1;
        Button ButtonLatest = (Button) findViewById(R.id.latestSong);
        ButtonLatest.setBackgroundColor(Color.RED);
    }

    public void submission(View view){
        if(hindiLang==1 && latestSong==1){
            Toast.makeText(home.this, "Launching Albums", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(home.this, album_layout.class));
            latestSong = 0;
            hindiLang = 0;
            Button ButtonHindi = (Button) findViewById(R.id.hindiLang);
            ButtonHindi.setBackgroundColor(R.drawable.button_border);
            Button ButtonLatest = (Button) findViewById(R.id.latestSong);
            ButtonLatest.setBackgroundColor(R.drawable.button_border);
            Button ButtonClassic = (Button) findViewById(R.id.classic);
            ButtonClassic.setBackgroundColor(R.drawable.button_border);
            Button ButtonEnglish = (Button) findViewById(R.id.english);
            ButtonEnglish.setBackgroundColor(R.drawable.button_border);
        }
        else{
            Toast.makeText(home.this, "Choose options!!", Toast.LENGTH_SHORT).show();
            latestSong = 0;
            hindiLang = 0;

            Button ButtonHindi = (Button) findViewById(R.id.hindiLang);
            ButtonHindi.setBackgroundColor(R.drawable.button_border);
            Button ButtonLatest = (Button) findViewById(R.id.latestSong);
            ButtonLatest.setBackgroundColor(R.drawable.button_border);
            Button ButtonClassic = (Button) findViewById(R.id.classic);
            ButtonClassic.setBackgroundColor(R.drawable.button_border);
            Button ButtonEnglish = (Button) findViewById(R.id.english);
            ButtonEnglish.setBackgroundColor(R.drawable.button_border);
        }
    }
}
