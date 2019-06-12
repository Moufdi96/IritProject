package com.example.sensor.model;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.widget.TextView;

public class SAccelerometer extends GSensor {
    private Sensor mAccelerometer;
    private static final SensorType mSensorType=SensorType.ACCELEROMETER_SENSOR;
    private static SAccelerometer instance;

    public SAccelerometer(TextArea textArea) {
        super(textArea);
    }

    /*private static class SAccelerometerHolder{
        private static final SAccelerometer instance= new SAccelerometer();
    }

    public static SAccelerometer getInstance(){
        return SAccelerometerHolder.instance; }*/

    public Sensor getAccelerometer() {
        return mAccelerometer;
    }

    public void setADefaultAccelerometerSensor(SensorManager sensorManager) {
        mAccelerometer =sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }

}


