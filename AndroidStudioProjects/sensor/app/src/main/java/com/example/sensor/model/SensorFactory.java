package com.example.sensor.model;


import com.example.sensor.model.material_sensor.SAccelerometer;
import com.example.sensor.model.material_sensor.SGyroscope;
import com.example.sensor.model.material_sensor.SMagnetometer;
import com.example.sensor.model.material_sensor.SPhotometer;
import com.example.sensor.model.material_sensor.SProximity;

public class SensorFactory {

    public GSensor creatSensor(SensorType sensorType,TextArea textArea) {
        GSensor sensor=null,sensor2 = null;

        switch (sensorType) {
            case ACCELEROMETER_SENSOR:
                sensor = SAccelerometer.getInstance(textArea);
                sensor2=SAccelerometer.getInstance(textArea);
                break;
            case MAGNETOMETER_SENSOR:
                sensor = SMagnetometer.getInstance(textArea);
                break;
            case PROXIMITY_SENSOR:
                sensor = SProximity.getInstance(textArea);
                break;
            case PHOTOMETER_SENSOR:
                sensor = SPhotometer.getInstance(textArea);
                break;
            case GYROSCOPE_SENSOR:
                sensor= SGyroscope.getInstance(textArea);
                break;
        }
        return sensor;
    }
}