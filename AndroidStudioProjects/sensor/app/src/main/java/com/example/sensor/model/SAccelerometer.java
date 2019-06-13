package com.example.sensor.model;

import android.hardware.Sensor;
import android.hardware.SensorManager;

import java.util.Optional;

public class SAccelerometer extends GSensor {
    private Optional<Sensor> mAccelerometerSensor=Optional.empty();
    private static final SensorType mSensorType=SensorType.ACCELEROMETER_SENSOR;
    private static Optional<SAccelerometer > instance = Optional.empty();

    private SAccelerometer(TextArea textArea) {
        super(textArea);
    }

    public static SAccelerometer getInstance(TextArea textArea){
        if (!instance.isPresent())
        {   instance=Optional.ofNullable(new SAccelerometer(textArea));
        }
        return instance.get();
      }

    public Optional<Sensor> getAccelerometerSensor() {
        return mAccelerometerSensor;
    }

    public void setADefaultAccelerometerSensor(SensorManager sensorManager) {
        mAccelerometerSensor =Optional.ofNullable(sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER));
    }
}


