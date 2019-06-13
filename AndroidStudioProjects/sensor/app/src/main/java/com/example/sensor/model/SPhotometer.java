package com.example.sensor.model;

import android.hardware.Sensor;
import android.hardware.SensorManager;

import java.util.Optional;

public class SPhotometer extends GSensor {
    private Optional<Sensor> mPhotometerSensor=Optional.empty();
    private static final SensorType mSensorType=SensorType.ACCELEROMETER_SENSOR;
    private static Optional<SPhotometer > instance = Optional.empty();

    private SPhotometer(TextArea textArea) {
        super(textArea);
    }

    public static SPhotometer getInstance(TextArea textArea){
        if (!instance.isPresent())
        {   instance=Optional.ofNullable(new SPhotometer(textArea));
        }
        return instance.get();
    }

    public Optional<Sensor> getPhotometerSensor() {
        return mPhotometerSensor;
    }

    public void setADefaultPhotometerSensor(SensorManager sensorManager) {
        mPhotometerSensor =Optional.ofNullable(sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT));
    }
}


