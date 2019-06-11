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


public class MainActivity extends AppCompatActivity {
    private TextView mTextTitle;
    private TextView mTextAccelerometer;
    private TextView mXAccelerometer;
    private TextView mYAccelerometer;
    private TextView mZAccelerometer;
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
        mXAccelerometer=(TextView)findViewById(R.id.activity_main_text_xaccelerometer);
        mYAccelerometer=(TextView)findViewById(R.id.activity_main_text_yaccelerometer);
        mZAccelerometer=(TextView)findViewById(R.id.activity_main_text_zaccelerometer);
        mButton=(Button)findViewById(R.id.activity_main_QuitApp);
        mSensorManager=(SensorManager)getSystemService(Context.SENSOR_SERVICE);
        //mSAccelerometer=new SAccelerometer(mSensorManager,mXAccelerometer,mYAccelerometer,mZAccelerometer);
        mSProximity=new SProximity(mSensorManager);
        if(mSProximity.getProximity()!=null){
            //mSensorManager.registerListener(mSAccelerometer,mSAccelerometer.getAccelerometer(),SensorManager.SENSOR_DELAY_NORMAL);
            //System.out.println("power "+SAccelerometer.getSensorPowerConsumption()+" mA      max range"+SAccelerometer.getMaxRange()+ "m/s²");
        }

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    protected void onResume(){
        super.onResume();
       // mSensorManager.registerListener(mSAccelerometer,mSAccelerometer.getAccelerometer(),SensorManager.SENSOR_DELAY_NORMAL);
        mSensorManager.registerListener(mSProximity,mSProximity.getProximity(),SensorManager.SENSOR_DELAY_NORMAL);
    }

    protected void onPause(){
        super.onPause();
        mSensorManager.unregisterListener(mSProximity,mSProximity.getProximity());
    }
}



