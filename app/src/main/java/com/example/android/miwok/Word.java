package com.example.android.miwok;

/**
 * Created by aas on 01/04/17.
 */

public class Word {

    private String mDefaultTranslation;


    private String mMiwokTranslation;


    public Word(String mDefaultTranslation, String mMiwokTranslation) {
        this.mDefaultTranslation = mDefaultTranslation;
        this.mMiwokTranslation = mMiwokTranslation;
    }

    public String getmDefaultTranslation() {
        return mDefaultTranslation;
    }

    public String getmMiwokTranslation() {
        return mMiwokTranslation;
    }

}
