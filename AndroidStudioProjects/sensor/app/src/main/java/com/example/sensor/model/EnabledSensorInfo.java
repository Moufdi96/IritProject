package com.example.sensor.model;

public class EnabledSensorInfo {
    private final String mSensorName;
    private final String mSnsorVersion;
    private final String mSensorPower;
    private final String mSensorMaxRange;
    private final String mSensorMinDelay;
    private final String mSensorMaxDelay;
    private final String mSensorResolution;
    private  String mSensorAcquisitionRate;

    public EnabledSensorInfo(String sensorName, String snsorVersion, String sensorPower, String sensorMaxRange, String sensorMinDelay, String sensorMaxDelay, String sensorResolution, String sensorAcquisitionRate) {
        mSensorName = sensorName;
        mSnsorVersion = snsorVersion;
        mSensorPower = sensorPower;
        mSensorMaxRange = sensorMaxRange;
        mSensorMinDelay = sensorMinDelay;
        mSensorMaxDelay = sensorMaxDelay;
        mSensorResolution = sensorResolution;
        mSensorAcquisitionRate = sensorAcquisitionRate;
    }

    public String getSensorName() {
        return mSensorName;
    }

    public String getSnsorVersion() {
        return mSnsorVersion;
    }

    public String getSensorPower() {
        return mSensorPower;
    }

    public String getSensorMaxRange() {
        return mSensorMaxRange;
    }

    public String getSensorMinDelay() {
        return mSensorMinDelay;
    }

    public String getSensorMaxDelay() {
        return mSensorMaxDelay;
    }

    public String getSensorResolution() {
        return mSensorResolution;
    }

    public String getSensorAcquisitionRate() {
        return mSensorAcquisitionRate;
    }

    public void setSensorAcquisitionRate(String sensorAcquisitionRate) {
        mSensorAcquisitionRate = sensorAcquisitionRate;
    }
}

