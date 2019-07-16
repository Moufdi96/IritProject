package com.example.sensor.view;

import android.widget.ImageView;
import android.widget.TextView;

public class TechInfoPage {
    private TextView mSensorType;
    private TextView mSensorName;
    private TextView mSensorRange;
    private TextView mSensorVersion;
    private TextView mSensorPowerConsumption;
    private TextView mSensorMinDelay;
    private TextView mSensorMaxDelay;
    private TextView mSensorResolution;
    private ImageView mCloseButton;

    public TextView getSensorName() {

        return mSensorName;
    }

    public TextView getSensorType() {
        return mSensorType;
    }

    public void setSensorType(TextView sensorType) {
        mSensorType = sensorType;
    }

    public void setSensorName(TextView sensorName) {
        mSensorName = sensorName;
    }

    public TextView getSensorRange() {
        return mSensorRange;
    }

    public void setSensorRange(TextView sensorRange) {
        mSensorRange = sensorRange;
    }

    public TextView getSensorVersion() {
        return mSensorVersion;
    }

    public void setSensorVersion(TextView sensorVersion) {
        mSensorVersion = sensorVersion;
    }

    public TextView getSensorPowerConsumption() {
        return mSensorPowerConsumption;
    }

    public void setSensorPowerConsumption(TextView sensorPowerConsumption) {
        mSensorPowerConsumption = sensorPowerConsumption;
    }

    public TextView getSensorMinDelay() {
        return mSensorMinDelay;
    }

    public void setSensorMinDelay(TextView sensorMinDelay) {
        mSensorMinDelay = sensorMinDelay;
    }

    public TextView getSensorMaxDelay() {
        return mSensorMaxDelay;
    }

    public void setSensorMaxDelay(TextView sensorMaxDelay) {
        mSensorMaxDelay = sensorMaxDelay;
    }

    public TextView getSensorResolution() {
        return mSensorResolution;
    }

    public void setSensorResolution(TextView sensorResolution) {
        mSensorResolution = sensorResolution;
    }

    public ImageView getCloseButton() {
        return mCloseButton;
    }

    public void setCloseButton(ImageView closeButton) {
        mCloseButton = closeButton;
    }
}
