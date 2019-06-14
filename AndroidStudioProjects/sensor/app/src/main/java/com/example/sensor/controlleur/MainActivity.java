package com.example.sensor.controlleur;

import android.content.Context;
import android.hardware.Sensor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.hardware.SensorManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.sensor.R;
import com.example.sensor.model.MainLayoutDesign;
import com.example.sensor.model.SAccelerometer;
import com.example.sensor.model.SMagnetometer;
import com.example.sensor.model.SPhotometer;
import com.example.sensor.model.SProximity;
import com.example.sensor.model.SRotation;
import com.example.sensor.model.SensorFactory;
import com.example.sensor.model.SensorType;
import com.example.sensor.model.TextArea;

public class MainActivity extends AppCompatActivity {
    private MainLayoutDesign mMainLayoutDesign;
    private SensorFactory mSensorFactory;
    private SensorManager mSensorManager;

    private TextArea mTextAreaAccelerometer;
    private TextArea mTextAreaProximity;
    private TextArea mTextAreaPhotometer;
    private TextArea mTextAreaMagnetometer;
    private TextArea mTextAreaRotation;

    private SAccelerometer mSAccelerometer;
    private SProximity mSProximity;
    private SPhotometer mSPhotometer;
    private SMagnetometer mSMagnetometer;
    private SRotation mSRotation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMainLayoutDesign=MainLayoutDesign.getInstance();
        mSensorFactory=new SensorFactory();
        mSensorManager=(SensorManager)getSystemService(Context.SENSOR_SERVICE);

        mTextAreaAccelerometer = new TextArea();
        mTextAreaProximity = new TextArea();
        mTextAreaPhotometer = new TextArea();
        mTextAreaMagnetometer = new TextArea();
        mTextAreaRotation= new TextArea();


        mMainLayoutDesign.setTextTitle((TextView)findViewById(R.id.activity_main_text_titre));
        mMainLayoutDesign.setButton((Button)findViewById(R.id.activity_main_QuitApp));

        mTextAreaAccelerometer.setTextNameSensor((TextView)findViewById(R.id.activity_main_text_accelerometer));
        mTextAreaAccelerometer.setTextValue1((TextView)findViewById(R.id.activity_main_text_xaccelerometer));
        mTextAreaAccelerometer.setTextValue2((TextView)findViewById(R.id.activity_main_text_yaccelerometer));
        mTextAreaAccelerometer.setTextValue3((TextView)findViewById(R.id.activity_main_text_zaccelerometer));

        mTextAreaProximity.setTextNameSensor((TextView)findViewById(R.id.activity_main_text_proximity));
        mTextAreaProximity.setTextValue1((TextView)findViewById(R.id.activity_main_text_proximity1));

        mTextAreaPhotometer.setTextNameSensor((TextView)findViewById(R.id.activity_main_text_photometer));
        mTextAreaPhotometer.setTextValue1((TextView)findViewById(R.id.activity_main_text_photometer1));

        mTextAreaMagnetometer.setTextNameSensor((TextView)findViewById(R.id.activity_main_text_magnetometer));
        mTextAreaMagnetometer.setTextValue1((TextView)findViewById(R.id.activity_main_text_xmagnetometer));
        mTextAreaMagnetometer.setTextValue2((TextView)findViewById(R.id.activity_main_text_ymagnetometer));
        mTextAreaMagnetometer.setTextValue3((TextView)findViewById(R.id.activity_main_text_zmagnetometer));

        mTextAreaRotation.setTextNameSensor((TextView)findViewById(R.id.activity_main_text_rotation));
        mTextAreaRotation.setTextValue1((TextView)findViewById(R.id.activity_main_text_xrotation));
        mTextAreaRotation.setTextValue2((TextView)findViewById(R.id.activity_main_text_yrotation));
        mTextAreaRotation.setTextValue3((TextView)findViewById(R.id.activity_main_text_zrotation));

        mSAccelerometer=(SAccelerometer)mSensorFactory.creatSensor(SensorType.ACCELEROMETER_SENSOR,mTextAreaAccelerometer);
        mSProximity=(SProximity)mSensorFactory.creatSensor(SensorType.PROXIMITY_SENSOR,mTextAreaProximity);
        mSPhotometer=(SPhotometer)mSensorFactory.creatSensor(SensorType.PHOTOMETER_SENSOR,mTextAreaPhotometer);
        mSMagnetometer=(SMagnetometer)mSensorFactory.creatSensor(SensorType.MAGNETOMETER_SENSOR,mTextAreaMagnetometer);
        //mSRotation=(SRotation) mSensorFactory.creatSensor(SensorType.ROTATION_SENSOR,mTextAreaRotation);
        mSRotation=SRotation.getInstance(mTextAreaRotation).get();

        mSAccelerometer.setADefaultAccelerometerSensor(mSensorManager);
        mSProximity.setADefaultProximitySensor(mSensorManager);
        mSPhotometer.setADefaultPhotometerSensor(mSensorManager);
        mSMagnetometer.setDefaultMagnetometerSensor(mSensorManager);

        mMainLayoutDesign.getButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    protected void onResume() {
        super.onResume();

        if (mSAccelerometer.getAccelerometerSensor().isPresent()){
            mSensorManager.registerListener(mSAccelerometer, mSAccelerometer.getAccelerometerSensor().get(),SensorManager.SENSOR_DELAY_UI);
        }

        if (mSProximity.getProximitySensor().isPresent()) {
            mSensorManager.registerListener(mSProximity, mSProximity.getProximitySensor().get(), SensorManager.SENSOR_DELAY_FASTEST);
        }

        if (mSPhotometer.getPhotometerSensor().isPresent()){
            mSensorManager.registerListener(mSPhotometer, mSPhotometer.getPhotometerSensor().get(),SensorManager.SENSOR_DELAY_UI);
        }

        if(mSMagnetometer.getMagnetometerSensor().isPresent()){
            mSensorManager.registerListener(mSMagnetometer,mSMagnetometer.getMagnetometerSensor().get(),SensorManager.SENSOR_DELAY_UI);
        }

        if(mSMagnetometer.getMagnetometerSensor().isPresent()&&mSAccelerometer.getAccelerometerSensor().isPresent()){
            mSensorManager.registerListener(mSRotation,mSAccelerometer.getAccelerometerSensor().get(),SensorManager.SENSOR_DELAY_UI);
            mSensorManager.registerListener(mSRotation,mSMagnetometer.getMagnetometerSensor().get(),SensorManager.SENSOR_DELAY_UI);
        }



    }

    protected void onPause(){
        super.onPause();
        mSensorManager.unregisterListener(mSProximity,mSProximity.getProximitySensor().get());
        mSensorManager.unregisterListener(mSAccelerometer,mSAccelerometer.getAccelerometerSensor().get());
        mSensorManager.unregisterListener(mSPhotometer,mSPhotometer.getPhotometerSensor().get());
        mSensorManager.unregisterListener(mSMagnetometer,mSMagnetometer.getMagnetometerSensor().get());
    }
}



