package com.example.sensor.controlleur;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.widget.TextView;
import com.example.sensor.R;
import com.example.sensor.model.SAccelerometer;


public class MainActivity extends AppCompatActivity {
    private TextView mTextTitle;
    private TextView mTextAccelerometer;
    private TextView mXAccelerometer;
    private TextView mYAccelerometer;
    private TextView mZAccelerometer;
    private SensorManager mSensorManager;
    private SAccelerometer mSAccelerometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextTitle= (TextView)findViewById(R.id.activity_main_text_titre);
        mTextAccelerometer=(TextView)findViewById(R.id.activity_main_text_accelerometer);
        mXAccelerometer=(TextView)findViewById(R.id.activity_main_text_xaccelerometer);
        mYAccelerometer=(TextView)findViewById(R.id.activity_main_text_yaccelerometer);
        mZAccelerometer=(TextView)findViewById(R.id.activity_main_text_zaccelerometer);
        mSensorManager=(SensorManager)getSystemService(Context.SENSOR_SERVICE);
        mSAccelerometer=new SAccelerometer(mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),mXAccelerometer,mYAccelerometer,mZAccelerometer);
        if(mSAccelerometer.getAccelerometer()!=null){
            mSensorManager.registerListener(mSAccelerometer,mSAccelerometer.getAccelerometer(),SensorManager.SENSOR_DELAY_NORMAL);
            System.out.println("power "+SAccelerometer.getSensorPowerConsumption()+" mA      max range"+SAccelerometer.getMaxRange()+ "m/s²"+mSAccelerometer.getAccelerometer().isWakeUpSensor());
        }
    }
}



