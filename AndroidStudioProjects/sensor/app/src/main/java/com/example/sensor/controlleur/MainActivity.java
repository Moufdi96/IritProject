package com.example.sensor.controlleur;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.hardware.SensorManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.sensor.R;
import com.example.sensor.model.MainLayoutDesign;
import com.example.sensor.model.material_sensor.SAccelerometer;

import com.example.sensor.model.material_sensor.SGyroscope;
import com.example.sensor.model.material_sensor.SMagnetometer;
import com.example.sensor.model.material_sensor.SPhotometer;
import com.example.sensor.model.material_sensor.SProximity;
import com.example.sensor.model.virtual_sensor.SRotation;
import com.example.sensor.model.SensorFactory;
import com.example.sensor.model.SensorType;
import com.example.sensor.model.TextArea;

public class MainActivity extends AppCompatActivity /*implements LocationListener*/ {
    private MainLayoutDesign mMainLayoutDesign;
    private SensorFactory mSensorFactory;
    private SensorManager mSensorManager;
    //private LocationManager mLocationManager;


    private TextArea mTextAreaAccelerometer;
    private TextArea mTextAreaProximity;
    private TextArea mTextAreaPhotometer;
    private TextArea mTextAreaMagnetometer;
    private TextArea mTextAreaGyroscope;
    private TextArea mTextAreaRotation;
    private TextArea mTextAreaGPS;

    private SAccelerometer mSAccelerometer;
    private SProximity mSProximity;
    private SPhotometer mSPhotometer;
    private SMagnetometer mSMagnetometer;
    private SGyroscope mSGyroscope;
    private SRotation mSRotation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*mLocationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        LocationProvider locationProvider = mLocationManager.getProvider(mLocationManager.NETWORK_PROVIDER);
        System.out.println("Provider name   " + locationProvider.getName() + "required power   " + locationProvider.getPowerRequirement() + "\n");
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED ) {
            requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION},1);
            return;
        }*/

        mMainLayoutDesign = MainLayoutDesign.getInstance();
        mSensorFactory = new SensorFactory();
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);


        mTextAreaAccelerometer = new TextArea();
        mTextAreaProximity = new TextArea();
        mTextAreaPhotometer = new TextArea();
        mTextAreaMagnetometer = new TextArea();
        mTextAreaGyroscope = new TextArea();
        mTextAreaRotation = new TextArea();
        mTextAreaGPS=new TextArea();


        mMainLayoutDesign.setTextTitle((TextView) findViewById(R.id.activity_main_text_titre));
        mMainLayoutDesign.setButton((Button) findViewById(R.id.activity_main_QuitApp));

        mTextAreaAccelerometer.setTextNameSensor((TextView) findViewById(R.id.activity_main_text_accelerometer));
        mTextAreaAccelerometer.setTextValue1((TextView) findViewById(R.id.activity_main_text_xaccelerometer));
        mTextAreaAccelerometer.setTextValue2((TextView) findViewById(R.id.activity_main_text_yaccelerometer));
        mTextAreaAccelerometer.setTextValue3((TextView) findViewById(R.id.activity_main_text_zaccelerometer));

        mTextAreaProximity.setTextNameSensor((TextView) findViewById(R.id.activity_main_text_proximity));
        mTextAreaProximity.setTextValue1((TextView) findViewById(R.id.activity_main_text_proximity1));

        mTextAreaPhotometer.setTextNameSensor((TextView) findViewById(R.id.activity_main_text_photometer));
        mTextAreaPhotometer.setTextValue1((TextView) findViewById(R.id.activity_main_text_photometer1));

        mTextAreaMagnetometer.setTextNameSensor((TextView) findViewById(R.id.activity_main_text_magnetometer));
        mTextAreaMagnetometer.setTextValue1((TextView) findViewById(R.id.activity_main_text_xmagnetometer));
        mTextAreaMagnetometer.setTextValue2((TextView) findViewById(R.id.activity_main_text_ymagnetometer));
        mTextAreaMagnetometer.setTextValue3((TextView) findViewById(R.id.activity_main_text_zmagnetometer));

        mTextAreaRotation.setTextNameSensor((TextView) findViewById(R.id.activity_main_text_rotation));
        mTextAreaRotation.setTextValue1((TextView) findViewById(R.id.activity_main_text_xrotation));
        mTextAreaRotation.setTextValue2((TextView) findViewById(R.id.activity_main_text_yrotation));
        mTextAreaRotation.setTextValue3((TextView) findViewById(R.id.activity_main_text_zrotation));

        mTextAreaGyroscope.setTextNameSensor((TextView) findViewById(R.id.activity_main_text_gyroscope));
        mTextAreaGyroscope.setTextValue1((TextView) findViewById(R.id.activity_main_text_xgyroscope));
        mTextAreaGyroscope.setTextValue2((TextView) findViewById(R.id.activity_main_text_ygyroscope));
        mTextAreaGyroscope.setTextValue3((TextView) findViewById(R.id.activity_main_text_zgyroscope));

        /*mTextAreaGPS.setTextNameSensor((TextView)findViewById(R.id.activity_main_text_gps));
        mTextAreaGPS.setTextValue1((TextView)findViewById(R.id.activity_main_text_latitude));
        mTextAreaGPS.setTextValue2((TextView)findViewById(R.id.activity_main_text_longitude));
        mTextAreaGPS.setTextValue3((TextView)findViewById(R.id.activity_main_text_altitude));*/

        mSAccelerometer = (SAccelerometer) mSensorFactory.creatSensor(SensorType.ACCELEROMETER_SENSOR, mTextAreaAccelerometer);
        mSProximity = (SProximity) mSensorFactory.creatSensor(SensorType.PROXIMITY_SENSOR, mTextAreaProximity);
        mSPhotometer = (SPhotometer) mSensorFactory.creatSensor(SensorType.PHOTOMETER_SENSOR, mTextAreaPhotometer);
        mSMagnetometer = (SMagnetometer) mSensorFactory.creatSensor(SensorType.MAGNETOMETER_SENSOR, mTextAreaMagnetometer);
        mSGyroscope = (SGyroscope) mSensorFactory.creatSensor(SensorType.GYROSCOPE_SENSOR, mTextAreaGyroscope);
        mSRotation = SRotation.getInstance(mTextAreaRotation).get();

        mSAccelerometer.setADefaultAccelerometerSensor(mSensorManager);
        mSProximity.setADefaultProximitySensor(mSensorManager);
        mSPhotometer.setADefaultPhotometerSensor(mSensorManager);
        mSMagnetometer.setDefaultMagnetometerSensor(mSensorManager);
        mSGyroscope.setADefaultGyroscopeSensor(mSensorManager);

        mMainLayoutDesign.getButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    /*@Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        System.out.println("ffff"+grantResults[0]);
        System.out.println("RQ"+requestCode);
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    mLocationManager.requestLocationUpdates("network", 5000, 0, this);
                    System.out.println("latitude  "+mLocationManager.getLastKnownLocation("gps").getAltitude());
                    mTextAreaGPS.getTextValue1().setText(""+(double)Math.round(mLocationManager.getLastKnownLocation("gps").getLatitude()* 100000000) / 100000000+"°");
                    mTextAreaGPS.getTextValue2().setText(""+(double)Math.round(mLocationManager.getLastKnownLocation("gps").getLongitude()* 100000000) / 100000000+"°");
                    mTextAreaGPS.getTextValue3().setText(""+(double)Math.round(mLocationManager.getLastKnownLocation("gps").getAltitude()* 100) / 100+" (m)");
                }
        }
    }*/

    protected void onResume() {
        super.onResume();

        if (mSAccelerometer.getAccelerometerSensor().isPresent()) {
            mSensorManager.registerListener(mSAccelerometer, mSAccelerometer.getAccelerometerSensor().get(), SensorManager.SENSOR_DELAY_UI);
        }

        if (mSProximity.getProximitySensor().isPresent()) {
            mSensorManager.registerListener(mSProximity, mSProximity.getProximitySensor().get(), SensorManager.SENSOR_DELAY_UI);
        }

        if (mSPhotometer.getPhotometerSensor().isPresent()) {
            mSensorManager.registerListener(mSPhotometer, mSPhotometer.getPhotometerSensor().get(), SensorManager.SENSOR_DELAY_UI);
        }

        if (mSMagnetometer.getMagnetometerSensor().isPresent()) {
            mSensorManager.registerListener(mSMagnetometer, mSMagnetometer.getMagnetometerSensor().get(), SensorManager.SENSOR_DELAY_UI);
        }

        if (mSMagnetometer.getMagnetometerSensor().isPresent() && mSAccelerometer.getAccelerometerSensor().isPresent()) {
            mSensorManager.registerListener(mSRotation, mSAccelerometer.getAccelerometerSensor().get(), SensorManager.SENSOR_DELAY_UI);
            mSensorManager.registerListener(mSRotation, mSMagnetometer.getMagnetometerSensor().get(), SensorManager.SENSOR_DELAY_UI);
        }

        if (mSGyroscope.getGyroscopeSensor().isPresent()) {
            mSensorManager.registerListener(mSGyroscope, mSGyroscope.getGyroscopeSensor().get(), SensorManager.SENSOR_DELAY_UI);
        }
    }

    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(mSProximity, mSProximity.getProximitySensor().get());
        mSensorManager.unregisterListener(mSAccelerometer, mSAccelerometer.getAccelerometerSensor().get());
        mSensorManager.unregisterListener(mSPhotometer, mSPhotometer.getPhotometerSensor().get());
        mSensorManager.unregisterListener(mSMagnetometer, mSMagnetometer.getMagnetometerSensor().get());
    }

    /*@Override

    public void onLocationChanged(Location location) {
        mTextAreaGPS.getTextValue1().setText(""+(double)Math.round(mLocationManager.getLastKnownLocation("gps").getLatitude()* 100000000) / 100000000+"°");
        mTextAreaGPS.getTextValue2().setText(""+(double)Math.round(mLocationManager.getLastKnownLocation("gps").getLongitude()* 100000000) / 100000000+"°");
        mTextAreaGPS.getTextValue3().setText(""+(double)Math.round(mLocationManager.getLastKnownLocation("gps").getAltitude()* 100) / 100+" (m)");
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }*/
}


