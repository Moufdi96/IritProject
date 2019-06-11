package com.example.sensor.model;

public enum SensorType {
    ACCELEROMETER(3),TEMPERATURE(1);

    private int numParams;

    private SensorType(int numParams
    ){
        this.numParams = numParams;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
