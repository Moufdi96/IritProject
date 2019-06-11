package com.example.sensor.model;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public class SProximity extends Activity implements SensorEventListener {
    public Sensor getProximity() {
        return mProximity;
    }

    public void setProximity(Sensor proximity) {
        mProximity = proximity;
    }

    Sensor mProximity;

    public SProximity(SensorManager sensorManager) {
        mProximity=sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

    }


    @Override
    public void onSensorChanged(SensorEvent event) {
        System.out.println(event.values[2]);


    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
