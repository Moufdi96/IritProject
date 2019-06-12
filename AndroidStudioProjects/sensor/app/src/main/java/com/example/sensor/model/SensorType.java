package com.example.sensor.model;

public enum SensorType {
    ACCELEROMETER_SENSOR(3),PROXIMITY_SENSOR(2);

    private final int numParameters;

    private SensorType(int numParameters){
        this.numParameters = numParameters;
    }

    public int getNumParameters(){
        return numParameters;}
}
