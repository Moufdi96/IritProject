package com.example.sensor.model;

import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainLayoutDesign {
    private TextView mTextTitle;
    private ImageView mReturnHome;
    private ImageButton mSensorInfoButton;
    private ImageButton mSensorSettings;
    private ImageButton mSensorStart;
    private ImageButton mSensorPause;
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

    public ImageView getReturnHome() {
        return mReturnHome;
    }

    public void setReturnHome(ImageView returnHome) {
        mReturnHome = returnHome;
    }

    public ImageButton getSensorInfoButton() {
        return mSensorInfoButton;
    }

    public void setSensorInfoButton(ImageButton sensorInfoButton) {
        mSensorInfoButton = sensorInfoButton;
    }

    public ImageButton getSensorSettings() {
        return mSensorSettings;
    }

    public void setSensorSettings(ImageButton sensorSettings) {
        mSensorSettings = sensorSettings;
    }

    public ImageButton getSensorStart() {
        return mSensorStart;
    }

    public void setSensorStart(ImageButton sensorStart) {
        mSensorStart = sensorStart;
    }

    public ImageButton getSensorPause() {
        return mSensorPause;
    }

    public void setSensorPause(ImageButton sensorPause) {
        mSensorPause = sensorPause;
    }
}
