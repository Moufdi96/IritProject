package com.example.sensor.model;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.widget.TextView;

public class SProximity extends GSensor {
    private Sensor mProximity;

    public SProximity(/*Sensor proximitySensor*/SensorManager sensorManager, TextView value1, TextView value2) {
        super(value1,value2);
       // this.mProximity=proximitySensor;
        this.mProximity=sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
    }

    public Sensor getProximity() {
        return mProximity;
    }

    public void setProximity(Sensor proximity) {
        mProximity = proximity;
    }
}