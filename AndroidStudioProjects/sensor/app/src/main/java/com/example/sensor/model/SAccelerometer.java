package com.example.sensor.model;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.widget.TextView;

public class SAccelerometer extends GSensor {
    private Sensor mAccelerometer;
    //private static SAccelerometer instance;

    private SAccelerometer(SensorManager sensorManager,TextView value1,TextView value2, TextView value3) {
        super(value1,value2,value3);
        this.mAccelerometer=sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }

   /* public static SAccelerometer getInstance(){

    return }

    private static class SAccelerometerHolder{
        private static final SAccelerometer instance= new SAccelerometer();
    }*/


    public Sensor getAccelerometer() {
        return mAccelerometer;
    }

    public void setAccelerometer(Sensor accelerometer) {
        mAccelerometer = accelerometer;
    }

}


