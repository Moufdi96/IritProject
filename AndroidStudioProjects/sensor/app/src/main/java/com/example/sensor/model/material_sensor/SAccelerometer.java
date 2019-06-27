package com.example.sensor.model.material_sensor;

import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorManager;

import com.example.sensor.model.GSensor;
import com.example.sensor.model.SensorCategory;
import com.example.sensor.model.SensorType;
import com.example.sensor.model.TextArea;

import java.util.Optional;

public class SAccelerometer extends GSensor {
    private Optional<Sensor> mAccelerometerSensor=Optional.empty();
    private static final SensorType mSensorType=SensorType.ACCELEROMETER_SENSOR;
    private static SensorCategory sSensorCategory = SensorCategory.MATERIAL;
    private static Optional<SAccelerometer > instance = Optional.empty();

    private SAccelerometer(TextArea textArea) {
        super(textArea);
    }

    public static SAccelerometer getInstance(PackageManager packageManager,TextArea textArea){
        if (!instance.isPresent()) {
            if (packageManager.hasSystemFeature(PackageManager.FEATURE_SENSOR_ACCELEROMETER)){          //check whether the device is equipped with an Accelerometer
                instance=Optional.ofNullable(new SAccelerometer(textArea));
            }
        }
        return instance.get();
      }

    public Optional<Sensor> getAccelerometerSensor() {
        return mAccelerometerSensor;
    }

    public void setADefaultAccelerometerSensor(SensorManager sensorManager){
        if(instance.isPresent()){
            mAccelerometerSensor =Optional.ofNullable(sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER));
        }
    }
}


