package com.example.sensor.model;

import android.hardware.Sensor;

public class SensorSettings {
    private int mAcquisitionRate;

    public SensorSettings(int acquisitionRate) {
        mAcquisitionRate = acquisitionRate;
    }

    public int getAcquisitionRate() {
        return mAcquisitionRate;
    }

    public void setAcquisitionRate(int acquisitionRate) {
        mAcquisitionRate = acquisitionRate;
    }
}
