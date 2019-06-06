package com.example.sensor.controlleur;

import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.widget.Button;
import android.widget.TextView;

import com.example.sensor.R;
import com.example.sensor.model.AccelerometerMeasure;

import org.w3c.dom.Text;

import static android.support.v4.content.ContextCompat.getSystemService;


public class MainActivity extends AppCompatActivity {
    private TextView mTextTitle;
    private TextView mTextAccelerometer;
    private TextView mXAccelerometer;
    private TextView mYAccelerometer;
    private TextView mZAccelerometer;
    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private AccelerometerMeasure mMeasure;
    final SensorEventListener mSensorEventListener=new SensorEventListener() {

       @Override
       public void onSensorChanged(SensorEvent event) {
           mMeasure.setMesureX(event.values[0]);
           mMeasure.setMesureY(event.values[1]);
           mMeasure.setMesureZ(event.values[2]);
           mXAccelerometer.setText(""+mMeasure.getMesureX());
           mYAccelerometer.setText(""+mMeasure.getMesureY());
           mZAccelerometer.setText(""+mMeasure.getMesureZ());
           System.out.println("time of the new mesured value= "+event.timestamp+ "\n"+"x="+event.values[0]+"    y="+event.values[1]+"    z="+event.values[2]);

       }

       @Override
       public void onAccuracyChanged(Sensor sensor, int accuracy) {

       }
   };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextTitle= (TextView)findViewById(R.id.activity_main_text_titre);
        mTextAccelerometer=(TextView)findViewById(R.id.activity_main_text_accelerometer);
        mXAccelerometer=(TextView)findViewById(R.id.activity_main_text_xaccelerometer);
        mYAccelerometer=(TextView)findViewById(R.id.activity_main_text_yaccelerometer);
        mZAccelerometer=(TextView)findViewById(R.id.activity_main_text_zaccelerometer);
        mSensorManager= (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        mAccelerometer=mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mMeasure=new AccelerometerMeasure();
        if(mAccelerometer!=null){
            mMeasure.setSensorPowerConsumption(mAccelerometer.getPower());
            mMeasure.setMaxRange(mAccelerometer.getMaximumRange());
            mSensorManager.registerListener(mSensorEventListener,mAccelerometer,SensorManager.SENSOR_DELAY_NORMAL);
            System.out.println("power "+mMeasure.getSensorPowerConsumption()+" mA      max range"+mMeasure.getMaxRange()+ "m/s²");


        }
    }
}



