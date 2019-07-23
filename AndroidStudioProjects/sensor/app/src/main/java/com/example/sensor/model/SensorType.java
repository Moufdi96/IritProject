package com.example.sensor.model;

public enum SensorType {
    ACCELEROMETER_SENSOR(0),PROXIMITY_SENSOR(1),PHOTOMETER_SENSOR(2),
    ROTATION_SENSOR(3),MAGNETOMETER_SENSOR(4),GYROSCOPE_SENSOR(5),
    GPS_SENSOR(6);


    private final int mSettingsActivityRequestCode;

    private SensorType(int settingsActivityRequestCode){
        this.mSettingsActivityRequestCode = settingsActivityRequestCode;
    }

    public int getSettingsActivityRequestCode(){
        return mSettingsActivityRequestCode;}
}
