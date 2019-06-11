package com.example.sensor.model;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.widget.TextView;

public class ProximityMeasure {
private TextView photometer1;
private TextView photometer2;
private Sensor mProximity;
private static float sensorPowerConsumption;
private static float maxRange;

    public ProximityMeasure(SensorManager sensorManager, TextView photometer1, TextView photometer2) {
        this.mProximity=sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        this.photometer1 = photometer1;
        this.photometer2 = photometer2;

    }
}
