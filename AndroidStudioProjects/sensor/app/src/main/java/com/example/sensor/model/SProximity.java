package com.example.sensor.model;



import android.hardware.Sensor;
import android.hardware.SensorManager;


public class SProximity extends GSensor {
    private static final SensorType mSENSOR_TYPE=SensorType.PROXIMITY_SENSOR;
    private Sensor mProximity;
    private static SProximity instance =null;

    public SProximity(TextArea textArea) {
        super(textArea);
    }

    public static SProximity getInstance(TextArea textArea){
        if (instance == null)
        {   instance= new SProximity(textArea);
        }
        return instance;
    }

    public Sensor getProximity() {
        return mProximity;
    }

    public void setADefaultProximitySensor(SensorManager sensorManager) {
        mProximity=sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
    }
}