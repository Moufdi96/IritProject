package com.example.sensor.controlleur;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.sensor.R;
import com.example.sensor.model.SAccelerometer;
import com.example.sensor.model.SProximity;
import com.example.sensor.model.SensorFactory;

import java.util.Optional;


public class MainActivity extends AppCompatActivity {
    private TextView mTextTitle;
    private TextView mTextAccelerometer;
    private TextView mAccelerometerValue1;
    private TextView mAccelerometerValue2;
    private TextView mAccelerometerValue3;
    private TextView mTextPhotometer;
    private TextView mPhotometerValue1;
    private TextView mPhotometerValue2;
    private SAccelerometer mSAccelerometer;
    private SProximity mSProximity;
    private Button mButton;
    private SensorManager mSensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextTitle= (TextView)findViewById(R.id.activity_main_text_titre);
        mTextAccelerometer=(TextView)findViewById(R.id.activity_main_text_accelerometer);
        mAccelerometerValue1=(TextView)findViewById(R.id.activity_main_text_xaccelerometer);
        mAccelerometerValue2=(TextView)findViewById(R.id.activity_main_text_yaccelerometer);
        mAccelerometerValue3=(TextView)findViewById(R.id.activity_main_text_zaccelerometer);
        mTextPhotometer=(TextView)findViewById(R.id.activity_main_text_photometer);
        mPhotometerValue1=(TextView)findViewById(R.id.activity_main_text_photometer1);
        mPhotometerValue2=(TextView)findViewById(R.id.activity_main_text_photometer2);
        mButton=(Button)findViewById(R.id.activity_main_QuitApp);
        mSensorManager=(SensorManager)getSystemService(Context.SENSOR_SERVICE);
        mSAccelerometer=new SAccelerometer(mSensorManager,mAccelerometerValue1,mAccelerometerValue2,mAccelerometerValue3);
        mSProximity=new SProximity(mSensorManager,mPhotometerValue1,mPhotometerValue2);


        mButton.setOnClickListener(new View.OnClickListener() {
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



