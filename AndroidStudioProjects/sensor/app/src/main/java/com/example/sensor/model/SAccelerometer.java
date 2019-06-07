package com.example.sensor.model;


import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.widget.TextView;

public class SAccelerometer implements SensorEventListener {
    private AccelerometerMeasure mMeasure;
    private TextView mXAccelerometer;
    private TextView mYAccelerometer;
    private TextView mZAccelerometer;
    private Sensor mAccelerometer;
    private static float sensorPowerConsumption;
    private static float maxRange;

    public SAccelerometer(Sensor accelerometer, TextView xAccelerometer, TextView yAccelerometer, TextView zAccelerometer) {
        mAccelerometer = accelerometer;
        mMeasure = new AccelerometerMeasure();
        sensorPowerConsumption = accelerometer.getPower();
        maxRange = accelerometer.getMaximumRange();
        mXAccelerometer = xAccelerometer;
        mYAccelerometer = yAccelerometer;
        mZAccelerometer = zAccelerometer;
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        mMeasure.setMesureX(event.values[0]);
        mMeasure.setMesureY(event.values[1]);
        mMeasure.setMesureZ(event.values[2]);
        mXAccelerometer.setText("" + mMeasure.getMesureX());
        mYAccelerometer.setText("" + mMeasure.getMesureY());
        mZAccelerometer.setText("" + mMeasure.getMesureZ());
        //System.out.println("time of the new mesured value= "+event.timestamp+ "\n"+"x="+event.values[0]+"    y="+event.values[1]+"    z="+event.values[2]);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }


    public static float getSensorPowerConsumption() {
        return sensorPowerConsumption;
    }

    public static void setSensorPowerConsumption(float sensorPowerConsumption) {
        SAccelerometer.sensorPowerConsumption = sensorPowerConsumption;
    }

    public static float getMaxRange() {
        return maxRange;
    }

    public static void setMaxRange(float maxRange) {
        SAccelerometer.maxRange = maxRange;
    }

    public AccelerometerMeasure getMeasure() {
        return mMeasure;
    }

    public void setMeasure(AccelerometerMeasure measure) {
        mMeasure = measure;
    }

    public TextView getXAccelerometer() {
        return mXAccelerometer;
    }

    public void setXAccelerometer(TextView XAccelerometer) {
        mXAccelerometer = XAccelerometer;
    }

    public TextView getYAccelerometer() {
        return mYAccelerometer;
    }

    public void setYAccelerometer(TextView YAccelerometer) {
        mYAccelerometer = YAccelerometer;
    }

    public TextView getZAccelerometer() {
        return mZAccelerometer;
    }

    public void setZAccelerometer(TextView ZAccelerometer) {
        mZAccelerometer = ZAccelerometer;
    }

    public Sensor getAccelerometer() {
        return mAccelerometer;
    }

    public void setAccelerometer(Sensor accelerometer) {
        mAccelerometer = accelerometer;
    }

}


