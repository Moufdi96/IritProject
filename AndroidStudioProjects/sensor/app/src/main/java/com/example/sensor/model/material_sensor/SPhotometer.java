package com.example.sensor.model.material_sensor;

import android.hardware.Sensor;
import android.hardware.SensorManager;

import com.example.sensor.model.GSensor;
import com.example.sensor.model.SensorCategory;
import com.example.sensor.model.SensorType;
import com.example.sensor.model.TextArea;

import java.util.Optional;

public class SPhotometer extends GSensor {
    private Optional<Sensor> mPhotometerSensor=Optional.empty();
    private static final SensorType mSensorType=SensorType.PHOTOMETER_SENSOR;
    private static SensorCategory sSensorCategory = SensorCategory.MATERIAL;
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


