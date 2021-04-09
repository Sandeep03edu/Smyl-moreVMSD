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

public class SongPlayingAdapter extends ArrayAdapter<SongPlayingVar> {

    public SongPlayingAdapter(Activity context, ArrayList<SongPlayingVar> SongPlayingVar) {
        super(context, 0, SongPlayingVar);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.song, parent, false);
        }

        SongPlayingVar currentSong = getItem(position);

        TextView songName = (TextView) listItemView.findViewById(R.id.songName);
        songName.setText(currentSong.getSongName());

        TextView artistName = (TextView) listItemView.findViewById(R.id.artistName);
        artistName.setText(currentSong.getArtistName());

        ImageView songImageId = (ImageView) listItemView.findViewById(R.id.songImage);
        songImageId.setImageResource(currentSong.getSongImageId());

        return listItemView;
    }

}
