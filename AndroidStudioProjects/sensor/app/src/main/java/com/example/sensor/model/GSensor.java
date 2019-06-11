package com.example.sensor.model;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.widget.TextView;

public class GSensor implements SensorEventListener {
    private AccelerometerMeasure mMeasure;
    private TextView mValue1;
    private TextView mValue2;
    private TextView mValue3;
    private static float sensorPowerConsumption;
    private static float maxRange;
    //private Sensor mSensor;
    public GSensor(SensorManager sensorManager, TextView value1, TextView value2, TextView value3) {
        //mSensor=sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mMeasure = new AccelerometerMeasure();
        sensorPowerConsumption = mSensor.getPower();
        //maxRange =mSensor.getMaximumRange();
        mValue1=value1;
        mValue2=value2;
        mValue3=value3;
    }


    @Override
    public void onSensorChanged(SensorEvent event) {
        mMeasure.setMesureX(event.values[0]);
        mMeasure.setMesureY(event.values[1]);
        mMeasure.setMesureZ(event.values[2]);
        mValue1.setText("X=" + (double) Math.round(mMeasure.getMesureX() * 1000) / 1000);
        mValue2.setText("Y=" + (double) Math.round(mMeasure.getMesureY() * 1000) / 1000);
        mValue3.setText("Z=" + (double) Math.round(mMeasure.getMesureZ() * 1000) / 1000);
        //System.out.println("time of the new mesured value= "+event.timestamp+ "\n"+"x="+event.values[0]+"    y="+event.values[1]+"    z="+event.values[2]);

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    public TextView getValue1() {
        return mValue1;
    }

    public void setValue1(TextView value1) {
        mValue1 = value1;
    }

    public TextView getValue2() {
        return mValue2;
    }

    public void setValue2(TextView value2) {
        mValue2 = value2;
    }

    public TextView getValue3() {
        return mValue3;
    }

    public void setValue3(TextView value3) {
        mValue3 = value3;
    }

    public static float getSensorPowerConsumption() {
        return sensorPowerConsumption;
    }

    public static void setSensorPowerConsumption(float sensorPowerConsumption) {
        GSensor.sensorPowerConsumption = sensorPowerConsumption;
    }

    public static float getMaxRange() {
        return maxRange;
    }

    public static void setMaxRange(float maxRange) {
        GSensor.maxRange = maxRange;
    }

    public Sensor getSensor() {
        return mSensor;
    }

    public void setSensor(Sensor sensor) {
        mSensor = sensor;
    }
}
