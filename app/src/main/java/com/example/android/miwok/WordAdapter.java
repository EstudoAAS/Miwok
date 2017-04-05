package com.example.android.miwok;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by aas on 01/04/17.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    public WordAdapter(Context c, ArrayList<Word> w){
        super(c, 0, w);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent, false);
        }
        Word currentWords = getItem(position);

        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        miwokTextView.setText(currentWords.getmMiwokTranslation());

        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        defaultTextView.setText(currentWords.getmDefaultTranslation());

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image_view);
        if(currentWords.hasImage()) {
            imageView.setImageResource(currentWords.getImageResourceId());
            imageView.setVisibility(View.VISIBLE);
        } else
            imageView.setVisibility(View.GONE);

        return listItemView;
    }
}
