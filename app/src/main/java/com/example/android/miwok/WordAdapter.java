package com.example.android.miwok;

import android.content.Context;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by aas on 01/04/17.
 */

public class WordAdapter extends ArrayAdapter<Word> {
    private int mColorResourceId;
    private int mSoundResourceId;
    //private MediaPlayer mediaPlayer;

    public WordAdapter(Context context, ArrayList<Word> words, int colorResourceId){
        super(context, 0, words);
        this.mColorResourceId = colorResourceId;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent, false);
        }
        Word currentWords = getItem(position);
        //final int resourceSound = currentWords.getmSoundResourceId();
        this.mSoundResourceId = currentWords.getmSoundResourceId();

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

        View textContainer = listItemView.findViewById(R.id.text_container);
        textContainer.setBackgroundColor(ContextCompat.getColor(this.getContext(),mColorResourceId));
        textContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //mediaPlayer = MediaPlayer.create(getContext(), R.raw.color_black);
                //Toast.makeText(getContext(),mSoundResourceId, Toast.LENGTH_SHORT);
                MediaPlayer mediaPlayer = MediaPlayer.create(getContext(), getItem(position).getmSoundResourceId());
                //mediaPlayer = MediaPlayer.create(getContext(), currentWords.getmSoundResourceId());

                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
            }
        });

        return listItemView;
    }
}
