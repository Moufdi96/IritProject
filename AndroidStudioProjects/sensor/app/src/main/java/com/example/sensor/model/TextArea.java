package com.example.sensor.model;

import android.app.Activity;
import android.widget.TextView;

import com.example.sensor.R;

public class TextArea  {
    private TextView mTextNameSensor;
    private TextView mTextValue1;
    private TextView mTextValue2;
    private TextView mTextValue3;

    public TextView getTextNameSensor() {
        return mTextNameSensor;
    }

    public void setTextNameSensor(TextView textNameSensor) {
        mTextNameSensor = textNameSensor;
    }

    public TextView getTextValue1() {
        return mTextValue1;
    }

    public void setTextValue1(TextView textValue1) {
        mTextValue1 = textValue1;
    }

    public TextView getTextValue2() {
        return mTextValue2;
    }

    public void setTextValue2(TextView textValue2) {
        mTextValue2 = textValue2;
    }

    public TextView getTextValue3() {
        return mTextValue3;
    }

    public void setTextValue3(TextView textValue3) {
        mTextValue3 = textValue3;
    }

    public void setVisiblityState(int visiblityState){
        mTextNameSensor.setVisibility(visiblityState);
        mTextValue1.setVisibility(visiblityState);
        mTextValue2.setVisibility(visiblityState);
        mTextValue3.setVisibility(visiblityState);
    }
}
