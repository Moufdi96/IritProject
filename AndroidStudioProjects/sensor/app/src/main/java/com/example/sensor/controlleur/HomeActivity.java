package com.example.sensor.controlleur;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.sensor.R;

public class HomeActivity extends AppCompatActivity {
    private ImageButton mBAccelerometer;
    private ImageButton mBMangnetometer;
    private ImageButton mBGyroscope;
    private ImageButton mBInclinomete;
    private ImageButton mBProximeter;
    private ImageButton mBPhotomter;
    private ImageButton mBGps;
    private Button mBQuitApp;
    private PackageManager mPackageManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mPackageManager=this.getPackageManager();

        mBAccelerometer = (ImageButton) findViewById(R.id.activity_home_button_accelerometer);
        mBAccelerometer.setTag("accelerometer");

        mBMangnetometer = (ImageButton) findViewById(R.id.activity_home_button_magnetometer);
        mBMangnetometer.setTag("magnetometer");

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
                String sensorToEnable = (String) v.getTag();
                Intent mainActivity = new Intent(HomeActivity.this, MainActivity.class);
                mainActivity.putExtra("sensor to enable", sensorToEnable);
                startActivity(mainActivity);
            }
        });

        mBMangnetometer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sensorToEnable = (String) v.getTag();
                Intent mainActivity = new Intent(HomeActivity.this, MainActivity.class);
                mainActivity.putExtra("sensor to enable", sensorToEnable);
                startActivity(mainActivity);
            }
        });

        mBGyroscope.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( mPackageManager.hasSystemFeature(PackageManager.FEATURE_SENSOR_GYROSCOPE)){ //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                    String sensorToEnable = (String) v.getTag();
                    Intent mainActivity = new Intent(HomeActivity.this, MainActivity.class);
                    mainActivity.putExtra("sensor to enable", sensorToEnable);
                    startActivity(mainActivity);
                }else {
                    Toast.makeText(HomeActivity.this,"no Gyroscope detected for this device",Toast.LENGTH_SHORT).show();
                }
            }
        });

        mBInclinomete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sensorToEnable = (String) v.getTag();
                Intent mainActivity = new Intent(HomeActivity.this, MainActivity.class);
                mainActivity.putExtra("sensor to enable", sensorToEnable);
                startActivity(mainActivity);
            }
        });

        mBProximeter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sensorToEnable = (String) v.getTag();
                Intent mainActivity = new Intent(HomeActivity.this, MainActivity.class);
                mainActivity.putExtra("sensor to enable", sensorToEnable);
                startActivity(mainActivity);
            }
        });

        mBPhotomter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sensorToEnable = (String) v.getTag();
                Intent mainActivity = new Intent(HomeActivity.this, MainActivity.class);
                mainActivity.putExtra("sensor to enable", sensorToEnable);
                startActivity(mainActivity);
            }
        });

        mBGps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sensorToEnable = (String) v.getTag();
                Intent mainActivity = new Intent(HomeActivity.this, MainActivity.class);
                mainActivity.putExtra("sensor to enable", sensorToEnable);
                startActivity(mainActivity);

            }
        });

        mBQuitApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
