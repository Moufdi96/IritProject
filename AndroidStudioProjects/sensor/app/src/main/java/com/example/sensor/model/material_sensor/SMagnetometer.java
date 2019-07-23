package com.example.sensor.model.material_sensor;

import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorManager;

import com.example.sensor.model.GSensor;
import com.example.sensor.model.SensorCategory;
import com.example.sensor.model.SensorSettings;
import com.example.sensor.model.SensorType;
import com.example.sensor.model.TextArea;

import java.util.Optional;

public class SMagnetometer extends GSensor {
    private Optional<Sensor> mMagnetometerSensor=Optional.empty();
    private SensorSettings mMagnetometerSettings=new SensorSettings(3,SensorType.MAGNETOMETER_SENSOR.getSettingsActivityRequestCode(),5);
    private static final SensorType mSensorType=SensorType.MAGNETOMETER_SENSOR;
    private static SensorCategory sSensorCategory = SensorCategory.MATERIAL;
    private static Optional<SMagnetometer> instance = Optional.empty();

    public Optional<Sensor> getMagnetometerSensor() {
        return mMagnetometerSensor;
    }

    public static SMagnetometer getInstance(PackageManager packageManager,SensorManager sensorManager) {
        if (!instance.isPresent()) {
            if (packageManager.hasSystemFeature(PackageManager.FEATURE_SENSOR_COMPASS)){          //check whether the device is equipped with an Accelerometer
                instance=Optional.ofNullable(new SMagnetometer());
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

    public SensorSettings getMagnetometerSettings() {
        return mMagnetometerSettings;
    }

    public void setMagnetometerSettings(SensorSettings magnetometerSettings) {
        mMagnetometerSettings = magnetometerSettings;
    }
}
