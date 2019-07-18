package com.example.sensor.model.material_sensor;

import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorManager;

import com.example.sensor.controlleur.SettingsActivity;
import com.example.sensor.model.GSensor;
import com.example.sensor.model.SensorCategory;
import com.example.sensor.model.SensorSettings;
import com.example.sensor.model.SensorType;
import com.example.sensor.model.TextArea;

import java.util.Optional;

public class SAccelerometer extends GSensor {
    private Optional<Sensor> mAccelerometerSensor=Optional.empty();
    private static final SensorType mSensorType=SensorType.ACCELEROMETER_SENSOR;
    private static SensorCategory sSensorCategory = SensorCategory.MATERIAL;
    private static Optional<SAccelerometer > instance = Optional.empty();
    private SensorSettings mAccelerometerSettings=new SensorSettings(3);


    public static SAccelerometer getInstance(PackageManager packageManager,SensorManager sensorManager ){
        if (!instance.isPresent()) {
            if (packageManager.hasSystemFeature(PackageManager.FEATURE_SENSOR_ACCELEROMETER)){          //check whether the device is equipped with an Accelerometer
                instance=Optional.ofNullable(new SAccelerometer());
            }
        }

        if(instance.isPresent()){
            instance.get().mAccelerometerSensor = Optional.ofNullable(sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER));
        }
        return instance.get();
      }

    public Optional<Sensor> getAccelerometerSensor() {
        return mAccelerometerSensor;
    }

    /*public void setADefaultAccelerometerSensor(SensorManager sensorManager){
        if(instance.isPresent()){
            mAccelerometerSensor = Optional.ofNullable(sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER));
        }
    }*/

    public SensorSettings getAccelerometerSettings() {
        return mAccelerometerSettings;
    }

    public void setAccelerometerSettings(SensorSettings accelerometerSettings) {
        mAccelerometerSettings = accelerometerSettings;
    }
}


