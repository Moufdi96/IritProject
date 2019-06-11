package com.example.sensor.model;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.widget.TextView;

/**
 * this is a GENERIC SENSOR
 *
 * blabla
 */
public class GSensor implements SensorEventListener {
    private Measure mMeasure;
    private TextView mValue1;
    private TextView mValue2;
    private TextView mValue3;
    private static float sensorPoweronsumption;
    private static float maxRange;



    public GSensor(TextView value1, TextView value2, TextView value3) {
        mMeasure = new Measure();
        mValue1=value1;
        mValue2=value2;
        mValue3=value3;
    }

    public GSensor(TextView value1, TextView value2) {
        mMeasure = new Measure();
        mValue1=value1;
        mValue2=value2;
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        Sensor sensor=event.sensor;
        mMeasure.setMesureX(event.values[0]);
        mMeasure.setMesureY(event.values[1]);
        mMeasure.setMesureZ(event.values[2]);
        mValue1.setText("X=" + (double)Math.round(mMeasure.getMesureX() * 100) / 100);
        mValue2.setText("Y=" + (double)Math.round(mMeasure.getMesureY() * 100) / 100);
        if(sensor.getType()==Sensor.TYPE_ACCELEROMETER){
            mValue3.setText("Z=" + (double)Math.round(mMeasure.getMesureZ() * 100) / 100);
        }
        System.out.println("time of the new mesured value= "+event.timestamp+ "\n"+"x="+event.values[0]+"    y="+event.values[1]+"    z="+event.values[2]);

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    public TextView getValue1() {
        return mValue1;
    }

    public void setValue1(TextView value1) {
        mValue1 = value1;
    }

    public TextView getValue2() {
        return mValue2;
    }

    public void setValue2(TextView value2) {
        mValue2 = value2;
    }

    public TextView getValue3() {
        return mValue3;
    }

    public void setValue3(TextView value3) {
        mValue3 = value3;
    }
}
