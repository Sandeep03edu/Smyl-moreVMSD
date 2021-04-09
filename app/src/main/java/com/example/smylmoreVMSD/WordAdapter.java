package com.example.smylmoreVMSD;

import android.app.Activity;
//import android.support.annotation.NonNull;
//import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class WordAdapter extends ArrayAdapter<Word> {

    public WordAdapter(Activity context, ArrayList<Word> Word) {
        super(context, 0, Word);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.songs_layout, parent, false);
        }

        Word currentWord = getItem(position);

        TextView songName = (TextView) listItemView.findViewById(R.id.songName);
        songName.setText(currentWord.getSongName());

        TextView songArtist = (TextView) listItemView.findViewById(R.id.songArtist);
        songArtist.setText(currentWord.getSongArtist());

// Setting up image view
//            // Find the ImageView in the list_item.xml layout with the ID list_item_icon
//            ImageView iconView = (ImageView) listItemView.findViewById(R.id.list_item_icon);
//            // Get the image resource ID from the current AndroidFlavor object and
//            // set the image to iconView
//            iconView.setImageResource(currentAndroidFlavor.getImageResourceId());

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
//}