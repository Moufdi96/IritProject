package com.example.sensor.model;

import android.widget.Button;
import android.widget.TextView;

public class MainLayoutDesign {
    private TextView mTextTitle;
    private Button mButton;
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

    public Button getButton() {
        return mButton;
    }

    public void setButton(Button button) {
        mButton = button;
    }
}
