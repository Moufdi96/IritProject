package com.example.sensor.controlleur;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.hardware.SensorManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.sensor.R;
import com.example.sensor.model.MainLayoutDesign;
import com.example.sensor.model.SAccelerometer;
import com.example.sensor.model.SProximity;
import com.example.sensor.model.SensorFactory;
import com.example.sensor.model.SensorType;
import com.example.sensor.model.TextArea;

public class MainActivity extends AppCompatActivity {
    private MainLayoutDesign mMainLayoutDesign;
    private TextArea mTextAreaAccelerometer;
    private TextArea mTextAreaProximity;
    private SAccelerometer mSAccelerometer;
    private SProximity mSProximity;
    private SensorFactory mSensorFactory;

    private SensorManager mSensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMainLayoutDesign=MainLayoutDesign.getInstance();
        mSensorFactory=new SensorFactory();
        mTextAreaAccelerometer=new TextArea();
        mTextAreaProximity=new TextArea();
        mMainLayoutDesign.setTextTitle((TextView)findViewById(R.id.activity_main_text_titre));
        mMainLayoutDesign.setButton((Button)findViewById(R.id.activity_main_QuitApp));
        mTextAreaAccelerometer.setTextNameSensor((TextView)findViewById(R.id.activity_main_text_accelerometer));
        mTextAreaAccelerometer.setTextValue1((TextView)findViewById(R.id.activity_main_text_xaccelerometer));
        mTextAreaAccelerometer.setTextValue2((TextView)findViewById(R.id.activity_main_text_yaccelerometer));
        mTextAreaAccelerometer.setTextValue3((TextView)findViewById(R.id.activity_main_text_zaccelerometer));
        mTextAreaProximity.setTextNameSensor((TextView)findViewById(R.id.activity_main_text_photometer));
        mTextAreaProximity.setTextValue1((TextView)findViewById(R.id.activity_main_text_photometer1));
        mTextAreaProximity.setTextValue2((TextView)findViewById(R.id.activity_main_text_photometer2));
        mSensorManager=(SensorManager)getSystemService(Context.SENSOR_SERVICE);
        mSAccelerometer=(SAccelerometer)mSensorFactory.creatSensor(SensorType.ACCELEROMETER_SENSOR,mTextAreaAccelerometer);
        mSProximity=(SProximity)mSensorFactory.creatSensor(SensorType.PROXIMITY_SENSOR,mTextAreaProximity);
        mSAccelerometer.setADefaultAccelerometerSensor(mSensorManager);
        mSProximity.setADefaultProximitySensor(mSensorManager);
        mMainLayoutDesign.getButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    protected void onResume(){
        super.onResume();
        //si en creeant une boite avec getAccelerometer(), j'ai qq chose dedans la boite...
        //if(Optional.ofNullable(mSAccelerometer.getAccelerometer()).isPresent())
       //if(mSAccelerometer.getAccelerometer()!=null){
            mSensorManager.registerListener(mSAccelerometer,mSAccelerometer.getAccelerometer(),SensorManager.SENSOR_DELAY_NORMAL);
            mSensorManager.registerListener(mSProximity,mSProximity.getProximity(),SensorManager.SENSOR_DELAY_NORMAL);
        }


    protected void onPause(){
        super.onPause();
        mSensorManager.unregisterListener(mSProximity,mSProximity.getProximity());
        mSensorManager.unregisterListener(mSAccelerometer,mSAccelerometer.getAccelerometer());
    }
}



