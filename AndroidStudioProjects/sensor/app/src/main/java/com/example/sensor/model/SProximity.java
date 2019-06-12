package com.example.sensor.model;


import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.widget.TextView;

public class SProximity extends GSensor {
    private static final SensorType mSENSOR_TYPE=SensorType.PROXIMITY_SENSOR;
    private Sensor mProximity;

    public SProximity(TextArea textArea) {
        super(textArea);
       // this.mProximity=proximitySensor;
    }

    public Sensor getProximity() {
        return mProximity;
    }

    public void setADefaultProximitySensor(SensorManager sensorManager) {
        mProximity=sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
    }
}