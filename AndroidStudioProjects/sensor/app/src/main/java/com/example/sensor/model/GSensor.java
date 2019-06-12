package com.example.sensor.model;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.widget.TextView;

/**
 * this is a GENERIC SENSOR
 *
 * blabla
 */
public class GSensor implements SensorEventListener {
    private Measure mMeasure;
    public TextArea mTextArea;
    private static float sensorPoweronsumption;
    private static float maxRange;



    public GSensor(TextArea textArea) {
        mMeasure = new Measure();
        mTextArea=new TextArea();
        mTextArea.setTextValue1(textArea.getTextValue1());
        mTextArea.setTextValue2(textArea.getTextValue2());
        mTextArea.setTextValue3(textArea.getTextValue3());
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        Sensor sensor=event.sensor;
        mMeasure.setMesureX(event.values[0]);
        mMeasure.setMesureY(event.values[1]);
        mMeasure.setMesureZ(event.values[2]);
        mTextArea.getTextValue1().setText("X=" + (double)Math.round(mMeasure.getMesureX() * 100) / 100);
        mTextArea.getTextValue2().setText("Y=" + (double)Math.round(mMeasure.getMesureY() * 100) / 100);
        if(sensor.getType()==Sensor.TYPE_ACCELEROMETER){
            mTextArea.getTextValue3().setText("Z=" + (double)Math.round(mMeasure.getMesureZ() * 100) / 100);
        }
        System.out.println("time of the new measured value= "+event.timestamp+ "\n"+"x="+event.values[0]+"    y="+event.values[1]+"    z="+event.values[2]);

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    public Measure getMeasure() {
        return mMeasure;
    }

    public void setMeasure(Measure measure) {
        mMeasure = measure;
    }

    public TextArea getTextArea() {
        return mTextArea;
    }

    public void setTextArea(TextArea textArea) {
        mTextArea = textArea;
    }

    public static float getSensorPoweronsumption() {
        return sensorPoweronsumption;
    }

    public static void setSensorPoweronsumption(float sensorPoweronsumption) {
        GSensor.sensorPoweronsumption = sensorPoweronsumption;
    }

    public static float getMaxRange() {
        return maxRange;
    }

    public static void setMaxRange(float maxRange) {
        GSensor.maxRange = maxRange;
    }
}
