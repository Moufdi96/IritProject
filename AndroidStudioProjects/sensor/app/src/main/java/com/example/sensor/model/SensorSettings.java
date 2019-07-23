package com.example.sensor.model;


public class SensorSettings {
    private int mAcquisitionRate;
    private int mAccuracy;
    public int mSettingsActivityRequestCode;

    public SensorSettings(int acquisitionRate,int settingsActivityRequestCode,int accuracy) {
        mAcquisitionRate = acquisitionRate;
        mSettingsActivityRequestCode=settingsActivityRequestCode;
        mAccuracy=accuracy;
    }

    public int getAcquisitionRate() {
        return mAcquisitionRate;
    }

    public void setAcquisitionRate(int acquisitionRate) {
        mAcquisitionRate = acquisitionRate;
    }

    public int getSettingsActivityRequestCode() {
        return mSettingsActivityRequestCode;
    }

    public void setSettingsActivityRequestCode(int settingsActivityRequestCode) {
        this.mSettingsActivityRequestCode = settingsActivityRequestCode;
    }

    public int getAccuracy() {
        return mAccuracy;
    }

    public void setAccuracy(int accuracy) {
        this.mAccuracy = accuracy;
    }
}
