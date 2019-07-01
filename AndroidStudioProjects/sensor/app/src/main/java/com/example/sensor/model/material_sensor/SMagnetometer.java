package com.example.sensor.model.material_sensor;

import android.content.pm.PackageManager;
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

    public static SMagnetometer getInstance(PackageManager packageManager,TextArea textArea,SensorManager sensorManager) {
        if (!instance.isPresent()) {
            if (packageManager.hasSystemFeature(PackageManager.FEATURE_SENSOR_COMPASS)){          //check whether the device is equipped with an Accelerometer
                instance=Optional.ofNullable(new SMagnetometer(textArea));
            }
        }

        if(instance.isPresent()){
            instance.get().mMagnetometerSensor = Optional.ofNullable(sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD));
        }
        return instance.get();
    }


    public void setDefaultMagnetometerSensor(SensorManager sensorManager){
        if(instance.isPresent()){
            mMagnetometerSensor=Optional.ofNullable(sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD));
        }
    }
}
