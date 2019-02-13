package com.karasu.multiscreen;

public class Word {
    private String mDefaultTranslation,mMiwokTranslation;
    private int mImageResourceId,mSongId;
    public Word(String t1,String t2,int sid){
        mDefaultTranslation=t2;
        mMiwokTranslation=t1;
        mSongId = sid;
    }

    public Word(String t1,String t2,int id,int sid){
        mDefaultTranslation=t2;
        mMiwokTranslation=t1;
        mImageResourceId=id;
        mSongId=sid;
    }

    public String getDefaultTranslation(){
        return mDefaultTranslation;
    }
    public String getMiwokTranslation(){
        return  mMiwokTranslation;
    }
    public int getImageResourceId(){
        return mImageResourceId;
    }
    public int getmSongId() {
        return mSongId;
    }
}
