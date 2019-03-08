package com.example.android.cambridge;

public class Item {
    private static final int NO_IMAGE_PROVIDED = -1;
    private String mInfo;
    private String mName;
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    public Item(String Info, String Name) {
        mInfo = Info;
        mName = Name;
    }

    public Item(String Info, String Name, int imageResourceId) {
        mInfo = Info;
        mName = Name;
        mImageResourceId = imageResourceId;
    }

    public String getInfo() {
        return mInfo;
    }

    public String getName() {
        return mName;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}