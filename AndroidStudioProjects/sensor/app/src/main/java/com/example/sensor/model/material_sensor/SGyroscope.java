package com.example.sensor.model.material_sensor;

import android.hardware.Sensor;
import android.hardware.SensorManager;

import com.example.sensor.model.GSensor;
import com.example.sensor.model.SensorCategory;
import com.example.sensor.model.SensorType;
import com.example.sensor.model.TextArea;

import java.util.Optional;

public class SGyroscope extends GSensor {
    private Optional<Sensor> mAccelerometerSensor=Optional.empty();
    private static final SensorType mSensorType=SensorType.GYROSCOPE_SENSOR;
    private static SensorCategory sSensorCategory = SensorCategory.MATERIAL;
    private static Optional<SGyroscope> instance = Optional.empty();

    private SGyroscope(TextArea textArea) {
        super(textArea);
    }

    public static SGyroscope getInstance(TextArea textArea){
        if (!instance.isPresent())
        {   instance=Optional.ofNullable(new SGyroscope(textArea));
        }
        return instance.get();
    }

    public Optional<Sensor> getGyroscopeSensor() {
        return mAccelerometerSensor;
    }

    public void setADefaultGyroscopeSensor(SensorManager sensorManager) {
        mAccelerometerSensor =Optional.ofNullable(sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE));
    }
}
