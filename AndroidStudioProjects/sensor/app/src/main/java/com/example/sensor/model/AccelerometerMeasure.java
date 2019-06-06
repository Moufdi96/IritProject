package com.example.sensor.model;

public class AccelerometerMeasure {
    private float sensorPowerConsumption;
    private float maxRange;
    private float MesureX;
    private float MesureY;
    private float MesureZ;

    public float getSensorPowerConsumption() {
        return sensorPowerConsumption;
    }

    public void setSensorPowerConsumption(float sensorPowerConsumption) {
        this.sensorPowerConsumption = sensorPowerConsumption;
    }

    public float getMaxRange() {
        return maxRange;
    }

    public void setMaxRange(float maxRange) {
        this.maxRange = maxRange;
    }

    public float getMesureX() {
        return MesureX;
    }

    public void setMesureX(float mesureX) {
        MesureX = mesureX;
    }

    public float getMesureY() {
        return MesureY;
    }

    public void setMesureY(float mesureY) {
        MesureY = mesureY;
    }

    public float getMesureZ() {
        return MesureZ;
    }

    public void setMesureZ(float mesureZ) {
        MesureZ = mesureZ;
    }
}
