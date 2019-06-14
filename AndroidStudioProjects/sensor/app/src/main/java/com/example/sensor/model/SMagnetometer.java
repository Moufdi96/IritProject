package com.example.sensor.model;

import android.hardware.Sensor;
import android.hardware.SensorManager;

import java.util.Optional;

public class SMagnetometer extends GSensor {
    private Optional<Sensor> mMagnetometerSensor=Optional.empty();
    private static final SensorType mSensorType=SensorType.MAGNETOMETER_SENSOR;
    private static Optional<SMagnetometer> instance = Optional.empty();

    private SMagnetometer(TextArea textArea){
    super(textArea);}

    public Optional<Sensor> getMagnetometerSensor() {
        return mMagnetometerSensor;
    }

    public static SMagnetometer getInstance(TextArea textArea) {
        if(!instance.isPresent()){
            instance=Optional.ofNullable(new SMagnetometer(textArea));
        }
        return instance.get();
    }


    public void setDefaultMagnetometerSensor(SensorManager sensorManager){
        mMagnetometerSensor=Optional.ofNullable(sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD));
    }
}
