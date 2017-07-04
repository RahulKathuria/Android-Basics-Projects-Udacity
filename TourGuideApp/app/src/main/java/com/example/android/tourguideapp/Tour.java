package com.example.android.tourguideapp;

/**
 * Created by Rk on 15-01-2017.
 */
public class Tour {

    private String mText;

    private int mImageResourceId = NO_IMAGE_PROVIDED;

    private static final int NO_IMAGE_PROVIDED = -1;

    public Tour(String text) {
        mText = text;
    }


    public Tour(String text, int imageResourceId) {
        mText = text;
        mImageResourceId = imageResourceId;
    }

    public String getText() {
        return mText;
    }


    public int getImageResourceId() {
        return mImageResourceId;
    }

    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}

