package com.example.android.miwok;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
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

        LinearLayout linearTextView = (LinearLayout) listItemView.findViewById(R.id.layout_text);
        //Log.i("AAS", "Classe = " + this.getContext().getClass().toString().split(" ")[1].trim());
        Log.i("AAS", "Classe = " + NumbersActivity.class.toString());
        switch (this.getContext().getClass().toString().split(" ")[1]) {
            case "com.example.android.miwok.NumbersActivity":
            //case NumbersActivity.class.toString().split(" ")[1].trim():
                linearTextView.setBackgroundColor(ContextCompat.getColor(this.getContext(), R.color.category_numbers));
                break;
            case "com.example.android.miwok.FamilyActivity":
                linearTextView.setBackgroundColor(ContextCompat.getColor(this.getContext(), R.color.category_family));
                break;
            case "com.example.android.miwok.ColorsActivity":
                linearTextView.setBackgroundColor(ContextCompat.getColor(this.getContext(), R.color.category_colors));
                break;
            case "com.example.android.miwok.PhrasesActivity":
                linearTextView.setBackgroundColor(ContextCompat.getColor(this.getContext(), R.color.category_phrases));
                break;

        }

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
