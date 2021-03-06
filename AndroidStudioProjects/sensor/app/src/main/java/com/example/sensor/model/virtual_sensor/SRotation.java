package com.example.sensor.model.virtual_sensor;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.example.sensor.model.SensorCategory;
import com.example.sensor.model.SensorType;
import com.example.sensor.model.TextArea;
import java.util.Optional;

/*this sensor is virtual (no such a sensor is embedded in the smartphone) the acquisition of the orientation of the smartphone
requires to combine magnetometer and accelerometer data*/


public class SRotation implements SensorEventListener {
    private static final SensorType mSensorType = SensorType.ROTATION_SENSOR;
    private static SensorCategory sSensorCategory = SensorCategory.VIRTUAL;
    private static Optional<SRotation> instance = Optional.empty();
    private float[] mMeasureAccelerometer;
    private float[] mMeasureMagnetomter;
    private float [] orientationValues = new float[3];
    private float [] rotationMatrix = new float[9];
    public TextArea mTextArea;

    private SRotation(TextArea textArea) {
        mTextArea=textArea;
        mMeasureAccelerometer=new float[3];
        mMeasureMagnetomter=new float[3];
    }


    public static Optional<SRotation> getInstance(TextArea textArea) {
        if (!instance.isPresent()) {
            instance = Optional.ofNullable(new SRotation(textArea));
        }
        return instance;
    }
    //
    @Override
    public void onSensorChanged(SensorEvent event) {
        Sensor sensor=event.sensor;
        switch(sensor.getType()){
            case Sensor.TYPE_ACCELEROMETER:
                mMeasureAccelerometer[0]=event.values[0];
                mMeasureAccelerometer[1]=event.values[1];
                mMeasureAccelerometer[2]=event.values[2];
                break;
            case Sensor.TYPE_MAGNETIC_FIELD:
                mMeasureMagnetomter[0]=event.values[0];
                mMeasureMagnetomter[1]=event.values[1];
                mMeasureMagnetomter[2]=event.values[2];
            break;
        }
        getOrientation();
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    public void getOrientation(){
        SensorManager.getRotationMatrix(rotationMatrix,null,mMeasureAccelerometer,mMeasureMagnetomter);
        SensorManager.getOrientation(rotationMatrix,orientationValues);
        mTextArea.getTextValue1().setText("X=" + (double)Math.round((orientationValues[0]*180/3.14)*100)/ 100); //Yaw
        mTextArea.getTextValue2().setText("Y=" + (double)Math.round((orientationValues[1]*180/3.14)*100)/ 100); //Pitch
        mTextArea.getTextValue3().setText("Z=" + (double)Math.round((orientationValues[2]*180/3.14)*100)/ 100); //Roll
    }
}
