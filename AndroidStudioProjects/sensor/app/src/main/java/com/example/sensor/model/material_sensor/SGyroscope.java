package com.example.sensor.model.material_sensor;

import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.widget.TextView;

import com.example.sensor.model.GSensor;
import com.example.sensor.model.SensorCategory;
import com.example.sensor.model.SensorSettings;
import com.example.sensor.model.SensorType;
import com.example.sensor.model.TextArea;

import java.util.Optional;

public class SGyroscope extends GSensor {
    private Optional<Sensor> mGyroscopeSensor=Optional.empty();
    private SensorSettings mGyroscopeSettings=new SensorSettings(3,SensorType.GYROSCOPE_SENSOR.getSettingsActivityRequestCode(),5);
    private static final SensorType mSensorType=SensorType.GYROSCOPE_SENSOR;
    private static SensorCategory sSensorCategory = SensorCategory.MATERIAL;
    private static Optional<SGyroscope> instance = Optional.empty();

    public static SGyroscope getInstance(PackageManager packageManager,SensorManager sensorManager){
        if (!instance.isPresent()) {
            if (packageManager.hasSystemFeature(PackageManager.FEATURE_SENSOR_GYROSCOPE)){          //check whether the device is equipped with an Accelerometer
                instance=Optional.ofNullable(new SGyroscope());
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

    public SensorSettings getGyroscopeSettings() {
        return mGyroscopeSettings;
    }

    public void setGyroscopeSettings(SensorSettings gyroscopeSettings) {
        mGyroscopeSettings = gyroscopeSettings;
    }

    public void setADefaultGyroscopeSensor(SensorManager sensorManager) {
        if(instance.isPresent()){
            mGyroscopeSensor =Optional.ofNullable(sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE));
        }

    }
}
