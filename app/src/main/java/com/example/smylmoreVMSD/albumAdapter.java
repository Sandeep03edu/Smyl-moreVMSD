package com.example.smylmoreVMSD;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;


public class albumAdapter extends ArrayAdapter<albumVar>{

    public albumAdapter(Activity context, ArrayList<albumVar> albumVar) {
        super(context, 0, albumVar);
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.songs_layout, parent, false);
        }

        albumVar currentSong = getItem(position);

        TextView songName = (TextView) listItemView.findViewById(R.id.songName);
        songName.setText(currentSong.getSongName());

        TextView artistName = (TextView) listItemView.findViewById(R.id.songArtist);
        artistName.setText(currentSong.getArtistName());

        ImageView songImage = (ImageView) listItemView.findViewById(R.id.songImage);
        songImage.setImageResource(currentSong.getSongImage());

        return listItemView;
    }
}
//}