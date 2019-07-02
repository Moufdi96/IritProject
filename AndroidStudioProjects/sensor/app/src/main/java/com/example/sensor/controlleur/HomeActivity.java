package com.example.sensor.controlleur;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.sensor.R;

public class HomeActivity extends AppCompatActivity {
    private ImageButton mBAccelerometer;
    private ImageButton mBMagnetometer;
    private ImageButton mBGyroscope;
    private ImageButton mBInclinomete;
    private ImageButton mBProximeter;
    private ImageButton mBPhotomter;
    private ImageButton mBGps;
    private Button mBQuitApp;
    private PackageManager mPackageManager;
    private boolean mGpsRequest=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mPackageManager=this.getPackageManager();


        mBAccelerometer = (ImageButton) findViewById(R.id.activity_home_button_accelerometer);
        mBAccelerometer.setTag("accelerometer");

        mBMagnetometer = (ImageButton) findViewById(R.id.activity_home_button_magnetometer);
        mBMagnetometer.setTag("magnetometer");

        mBGyroscope = (ImageButton) findViewById(R.id.activity_home_button_gyroscope);
        mBGyroscope.setTag("gyroscope");

        mBInclinomete = (ImageButton) findViewById(R.id.activity_home_button_inclinometer);
        mBInclinomete.setTag("inclinometer");

        mBProximeter = (ImageButton) findViewById(R.id.activity_home_button_proximeter);
        mBProximeter.setTag("proximeter");

        mBPhotomter = (ImageButton) findViewById(R.id.activity_home_button_photometer);
        mBPhotomter.setTag("photometer");

        mBGps = (ImageButton) findViewById(R.id.activity_home_button_gps);
        mBGps.setTag("gps");

        mBQuitApp = (Button) findViewById(R.id.activity_home_button_quitApp);




        mBAccelerometer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean mSensorExistence;
                mSensorExistence=mPackageManager.hasSystemFeature(PackageManager.FEATURE_SENSOR_ACCELEROMETER);
                if (mSensorExistence){
                    String sensorToEnable = (String) v.getTag();
                    Intent mainActivity = new Intent(HomeActivity.this, MainActivity.class);
                    mainActivity.putExtra("sensor to enable", sensorToEnable);
                    startActivity(mainActivity);
                }else {
                    Toast.makeText(HomeActivity.this,"Accelerometer not detected for this device",Toast.LENGTH_SHORT).show();
                }
            }
        });

        mBMagnetometer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean mSensorExistence;
                mSensorExistence=mPackageManager.hasSystemFeature(PackageManager.FEATURE_SENSOR_COMPASS);
                if (mSensorExistence){
                    String sensorToEnable = (String) v.getTag();
                    Intent mainActivity = new Intent(HomeActivity.this, MainActivity.class);
                    mainActivity.putExtra("sensor to enable", sensorToEnable);
                    startActivity(mainActivity);
                }else {
                    Toast.makeText(HomeActivity.this,"Magnetometer not detected for this device",Toast.LENGTH_SHORT).show();
                }
            }
        });

        mBGyroscope.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean mSensorExistence;
                mSensorExistence=mPackageManager.hasSystemFeature(PackageManager.FEATURE_SENSOR_GYROSCOPE);
                if (mSensorExistence){
                    String sensorToEnable = (String) v.getTag();
                    Intent mainActivity = new Intent(HomeActivity.this, MainActivity.class);
                    mainActivity.putExtra("sensor to enable", sensorToEnable);
                    startActivity(mainActivity);
                }else {
                    Toast.makeText(HomeActivity.this,"Gyroscope not detected for this device",Toast.LENGTH_SHORT).show();
                }
            }
        });

        mBInclinomete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean mSensorExistence;
                mSensorExistence = mPackageManager.hasSystemFeature(PackageManager.FEATURE_SENSOR_COMPASS) && mPackageManager.hasSystemFeature(PackageManager.FEATURE_SENSOR_ACCELEROMETER);
                if (mSensorExistence) {
                    String sensorToEnable = (String) v.getTag();
                    Intent mainActivity = new Intent(HomeActivity.this, MainActivity.class);
                    mainActivity.putExtra("sensor to enable", sensorToEnable);
                    startActivity(mainActivity);
                } else {
                    Toast.makeText(HomeActivity.this, "Magnetometer or Accelerometer not detected for this device", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mBProximeter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean mSensorExistence;
                mSensorExistence=mPackageManager.hasSystemFeature(PackageManager.FEATURE_SENSOR_PROXIMITY);
                if (mSensorExistence){
                    String sensorToEnable = (String) v.getTag();
                    Intent mainActivity = new Intent(HomeActivity.this, MainActivity.class);
                    mainActivity.putExtra("sensor to enable", sensorToEnable);
                    startActivity(mainActivity);
                }else {
                    Toast.makeText(HomeActivity.this,"Proximity sensor not detected for this device",Toast.LENGTH_SHORT).show();
                }
            }
        });

        mBPhotomter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean mSensorExistence;
                mSensorExistence=mPackageManager.hasSystemFeature(PackageManager.FEATURE_SENSOR_LIGHT);
                if (mSensorExistence){
                    String sensorToEnable = (String) v.getTag();
                    Intent mainActivity = new Intent(HomeActivity.this, MainActivity.class);
                    mainActivity.putExtra("sensor to enable", sensorToEnable);
                    startActivity(mainActivity);
                }else {
                    Toast.makeText(HomeActivity.this,"Photometer or Accelerometer not detected for this device",Toast.LENGTH_SHORT).show();
                }
            }
        });

        mBGps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ActivityCompat.checkSelfPermission(HomeActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)!=PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(HomeActivity.this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},0);
                }
                boolean mSensorExistence;
                mSensorExistence=mPackageManager.hasSystemFeature(PackageManager.FEATURE_LOCATION);
                if (mSensorExistence && ActivityCompat.checkSelfPermission(HomeActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)==PackageManager.PERMISSION_GRANTED){
                    String sensorToEnable = (String) v.getTag();
                    Intent mainActivity = new Intent(HomeActivity.this, MainActivity.class);
                    mainActivity.putExtra("sensor to enable", sensorToEnable);
                    startActivity(mainActivity);
                }else {
                    if(ActivityCompat.checkSelfPermission(HomeActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)!=PackageManager.PERMISSION_GRANTED){
                        Toast.makeText(HomeActivity.this,"Permission denied\n can't access GPS",Toast.LENGTH_SHORT).show();
                    }
                    if (!mSensorExistence){
                        Toast.makeText(HomeActivity.this,"GPS not detected for this device",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        mBQuitApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 0:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    mGpsRequest=true;
                }
            break;
        }
    }

    public static Context getContext(){
        return getContext();
    }
}
