package com.example.android.miwok;

/**
 * Created by aas on 01/04/17.
 */

public class Word {

    private String mDefaultTranslation;


    private String mMiwokTranslation;

    private int mImageResourceId = NO_IMAGE_PROVIDED;

    private int mSoundResourceId;

    private static final int NO_IMAGE_PROVIDED = -1;


    public Word(String mDefaultTranslation, String mMiwokTranslation, int mSoundResourceId) {
        this.mDefaultTranslation = mDefaultTranslation;
        this.mMiwokTranslation = mMiwokTranslation;
        this.mSoundResourceId = mSoundResourceId;
    }

    public Word(String mDefaultTranslation, String mMiwokTranslation, int mSoundResourceId, int mImageResourceId) {
        this.mDefaultTranslation = mDefaultTranslation;
        this.mMiwokTranslation = mMiwokTranslation;
        this.mSoundResourceId = mSoundResourceId;
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

    public int getmSoundResourceId() {
        return this.mSoundResourceId;
    }

}
