package com.example.sensor.model;

import android.hardware.Sensor;
import android.hardware.SensorManager;

public class SAccelerometer extends GSensor {
    private Sensor mAccelerometer;
    private static final SensorType mSensorType=SensorType.ACCELEROMETER_SENSOR;
    private static SAccelerometer instance=null;

    private SAccelerometer(TextArea textArea) {
        super(textArea);
    }

    public static SAccelerometer getInstance(TextArea textArea){
        if (instance == null)
        {   instance= new SAccelerometer(textArea);
        }
        return instance;
      }

    public Sensor getAccelerometer() {
        return mAccelerometer;
    }

    public void setADefaultAccelerometerSensor(SensorManager sensorManager) {
        mAccelerometer =sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }

}


