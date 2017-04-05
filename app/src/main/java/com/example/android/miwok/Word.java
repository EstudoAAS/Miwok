package com.example.android.miwok;

/**
 * Created by aas on 01/04/17.
 */

public class Word {

    private String mDefaultTranslation;


    private String mMiwokTranslation;

    private int mImageResourceId = NO_IMAGE_PROVIDED;

    private static final int NO_IMAGE_PROVIDED = -1;


    public Word(String mDefaultTranslation, String mMiwokTranslation) {
        this.mDefaultTranslation = mDefaultTranslation;
        this.mMiwokTranslation = mMiwokTranslation;
    }

    public Word(String mDefaultTranslation, String mMiwokTranslation, int mImageResourceId) {
        this.mDefaultTranslation = mDefaultTranslation;
        this.mMiwokTranslation = mMiwokTranslation;
        this.mImageResourceId = mImageResourceId;
    }

    public String getmDefaultTranslation() {
        return mDefaultTranslation;
    }

    public String getmMiwokTranslation() {
        return mMiwokTranslation;
    }

    public int getImageResourceId(){
        return mImageResourceId;
    }

    public boolean hasImage(){
        if(this.mImageResourceId == NO_IMAGE_PROVIDED)
            return false;
        else
            return true;
    }

}
