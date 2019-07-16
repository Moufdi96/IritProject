package com.example.sensor.model;

import android.widget.ImageView;
import android.widget.TextView;

public class MainLayoutDesign {
    private TextView mTextTitle;
    private ImageView mButton;
    private static MainLayoutDesign instance;

    private MainLayoutDesign() {
    }

    public static MainLayoutDesign getInstance(){
        if(instance==null){
            instance= new MainLayoutDesign();
        }
        return  instance;
    }

    public TextView getTextTitle() {
        return mTextTitle;
    }

    public void setTextTitle(TextView textTitle) {
        mTextTitle = textTitle;
    }

    public ImageView getButton() {
        return mButton;
    }

    public void setButton(ImageView button) {
        mButton = button;
    }
}
