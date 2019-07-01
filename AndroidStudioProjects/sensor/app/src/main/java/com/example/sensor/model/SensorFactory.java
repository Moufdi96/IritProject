package com.example.sensor.model;


import android.content.pm.PackageManager;
import android.hardware.SensorManager;

import com.example.sensor.model.material_sensor.SAccelerometer;
import com.example.sensor.model.material_sensor.SGyroscope;
import com.example.sensor.model.material_sensor.SMagnetometer;
import com.example.sensor.model.material_sensor.SPhotometer;
import com.example.sensor.model.material_sensor.SProximity;

public class SensorFactory {

    public GSensor creatSensor(PackageManager packageManager, SensorType sensorType, TextArea textArea, SensorManager sensorManager) {
        GSensor sensor = null;

        switch (sensorType) {
            case ACCELEROMETER_SENSOR:
                sensor = SAccelerometer.getInstance(packageManager,textArea, sensorManager);
                break;
            case MAGNETOMETER_SENSOR:
                sensor = SMagnetometer.getInstance(packageManager,textArea,sensorManager);
                break;
            case PROXIMITY_SENSOR:
                sensor = SProximity.getInstance(packageManager,textArea,sensorManager);
                break;
            case PHOTOMETER_SENSOR:
                sensor = SPhotometer.getInstance(packageManager,textArea,sensorManager);
                break;
            case GYROSCOPE_SENSOR:
                sensor= SGyroscope.getInstance(packageManager,textArea,sensorManager);
                break;
        }
        return sensor;
    }
}