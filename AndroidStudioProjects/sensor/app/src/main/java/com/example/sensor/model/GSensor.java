package com.example.sensor.model;

import android.content.pm.PackageManager;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

/**
 * GSensor for "generic sensor" is the mother class of all material sensors classes
 * it gathers the main and common attributes and methods that have to be included in each material (physical) sensor class,
 * therefor each of these classes (with the SensorCategory enum = MATERIAL) must extend it.
 * it implements the SensorEventListener interface,thus it allows receiving new notification from SensorManager when there's new sensor data
 *
 * @author
 */
public class GSensor implements SensorEventListener {
    private Measure mMeasure;
    public TextArea mTextArea;
    private static float sensorPoweronsumption;
    private static float maxRange;




    public GSensor(TextArea textArea) {
        mMeasure = new Measure();
        mTextArea=new TextArea();
        mTextArea.setTextValue1(textArea.getTextValue1());
        mTextArea.setTextValue2(textArea.getTextValue2());
        mTextArea.setTextValue3(textArea.getTextValue3());
    }

    /* this method is called when a new sensor event is detected by the sensor event listener
     it reads the sensor type that has transmitted the measured data and perform the suitable action to that type
     for example if the sensor type was an accelerometer it displays the results in a 3D form (s,y,z)
     if sensor was a photometer or a proximity sensor it displays only one value  */

    @Override
    public void onSensorChanged(SensorEvent event) {
        Sensor sensor=event.sensor;
        mMeasure.setMesureX(event.values[0]);
        mMeasure.setMesureY(event.values[1]);
        mMeasure.setMesureZ(event.values[2]);




        String xValue = Double.toString(Math.round(mMeasure.getMesureX() * 100) / 100);
        String yValue = Double.toString(Math.round(mMeasure.getMesureY() * 100) / 100);
        String zValue = Double.toString(Math.round(mMeasure.getMesureZ() * 100) / 100);




        switch(sensor.getType()){
            case Sensor.TYPE_ACCELEROMETER:
                mTextArea.getTextValue1().setText("X=" + xValue +" m/s²");
                mTextArea.getTextValue2().setText("Y=" + yValue+" m/s²");
                mTextArea.getTextValue3().setText("Z=" + zValue+" m/s²");
                System.out.println("\n");
                System.out.println("Acceleration measure\n");
                System.out.println("time of the new measured value= "+event.timestamp+ "\n"+"x="+event.values[0]+"    y="+event.values[1]+"    z="+event.values[2]);
                System.out.println("\n");
                break;
            case Sensor.TYPE_GYROSCOPE:
                mTextArea.getTextValue1().setText("X=" + xValue +" rad/s");
                mTextArea.getTextValue2().setText("Y=" + yValue+" rad/s");
                mTextArea.getTextValue3().setText("Z=" + zValue+" rad/s");
                System.out.println("\n");
                System.out.println("Gyroscope measure\n");
                System.out.println("time of the new measured value= "+event.timestamp+ "\n"+"x="+event.values[0]+"    y="+event.values[1]+"    z="+event.values[2]);
                System.out.println("\n");
                break;
            case Sensor.TYPE_MAGNETIC_FIELD:
                mTextArea.getTextValue1().setText("X=" + xValue +" nT");
                mTextArea.getTextValue2().setText("Y=" + yValue+" nT");
                mTextArea.getTextValue3().setText("Z=" + zValue+" nT");
                System.out.println("\n");
                System.out.println("Magnetic field measure");
                System.out.println("time of the new measured value= "+event.timestamp+ "\n"+"x="+event.values[0]+"    y="+event.values[1]+"    z="+event.values[2]);
                System.out.println("\n");
                break;
            case Sensor.TYPE_PROXIMITY:
                if (mMeasure.getMesureX()==0){
                    mTextArea.getTextValue1().setText("Object detected");
                    mTextArea.getTextValue1().setBackgroundColor(Color.GREEN);
                } else {
                    mTextArea.getTextValue1().setText("no object detected");
                    mTextArea.getTextValue1().setBackgroundColor(0xffffffff);
                }
                System.out.println("\n");
                System.out.println("Proximity measure\n");
                System.out.println("time of the new measured value= "+event.timestamp+ "\n"+"x="+event.values[0]);
                System.out.println("\n");
                break;
            case Sensor.TYPE_LIGHT:
                mTextArea.getTextValue1().setText("" + (double)Math.round(mMeasure.getMesureX() * 100) / 100+"lux");
                System.out.println("\n");
                System.out.println("Luminosity measure\n");
                System.out.println("time of the new measured value= "+event.timestamp+ "\n"+"x="+event.values[0]);
                System.out.println("\n");
        }
    }

    //not yet implemented

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    public Measure getMeasure() {
        return mMeasure;
    }

    public void setMeasure(Measure measure) {
        mMeasure = measure;
    }

    public TextArea getTextArea() {
        return mTextArea;
    }

    public void setTextArea(TextArea textArea) {
        mTextArea = textArea;
    }

    public static float getSensorPoweronsumption() {
        return sensorPoweronsumption;
    }

    public static void setSensorPoweronsumption(float sensorPoweronsumption) {
        GSensor.sensorPoweronsumption = sensorPoweronsumption;
    }

    public static float getMaxRange() {
        return maxRange;
    }

    public static void setMaxRange(float maxRange) {
        GSensor.maxRange = maxRange;
    }
}
