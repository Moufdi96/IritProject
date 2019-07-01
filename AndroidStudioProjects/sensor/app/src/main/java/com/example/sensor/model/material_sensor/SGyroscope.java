package com.example.sensor.model.material_sensor;

import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.widget.TextView;

import com.example.sensor.model.GSensor;
import com.example.sensor.model.SensorCategory;
import com.example.sensor.model.SensorType;
import com.example.sensor.model.TextArea;

import java.util.Optional;

public class SGyroscope extends GSensor {
    private Optional<Sensor> mGyroscopeSensor=Optional.empty();
    private static final SensorType mSensorType=SensorType.GYROSCOPE_SENSOR;
    private static SensorCategory sSensorCategory = SensorCategory.MATERIAL;
    private static Optional<SGyroscope> instance = Optional.empty();

    private SGyroscope(TextArea textArea) {
        super(textArea);
    }

    public static SGyroscope getInstance(PackageManager packageManager,TextArea textArea,SensorManager sensorManager){
        if (!instance.isPresent()) {
            if (packageManager.hasSystemFeature(PackageManager.FEATURE_SENSOR_GYROSCOPE)){          //check whether the device is equipped with an Accelerometer
                instance=Optional.ofNullable(new SGyroscope(textArea));
            }
        }

        if(instance.isPresent()){
            instance.get().mGyroscopeSensor = Optional.ofNullable(sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE));
        }
        return instance.get();
    }

    public Optional<Sensor> getGyroscopeSensor() {
        return mGyroscopeSensor;
    }

    public void setADefaultGyroscopeSensor(SensorManager sensorManager) {
        if(instance.isPresent()){
            mGyroscopeSensor =Optional.ofNullable(sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE));
        }
    }
}
