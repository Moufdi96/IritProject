package com.example.sensor.model.material_sensor;

import android.hardware.Sensor;
import android.hardware.SensorManager;

import com.example.sensor.model.GSensor;
import com.example.sensor.model.SensorCategory;
import com.example.sensor.model.SensorType;
import com.example.sensor.model.TextArea;

import java.util.Optional;

public class SMagnetometer extends GSensor {
    private Optional<Sensor> mMagnetometerSensor=Optional.empty();
    private static final SensorType mSensorType=SensorType.MAGNETOMETER_SENSOR;
    private static SensorCategory sSensorCategory = SensorCategory.MATERIAL;
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
