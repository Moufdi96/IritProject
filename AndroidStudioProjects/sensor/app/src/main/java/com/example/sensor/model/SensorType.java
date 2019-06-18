package com.example.sensor.model;

public enum SensorType {
    ACCELEROMETER_SENSOR(3),PROXIMITY_SENSOR(2),PHOTOMETER_SENSOR(1),
    ROTATION_SENSOR(3),MAGNETOMETER_SENSOR(3),GYROSCOPE_SENSOR(3),VELOCITY_SENSOR(3);

    private final int numParameters;

    private SensorType(int numParameters){
        this.numParameters = numParameters;
    }

    public int getNumParameters(){
        return numParameters;}
}
