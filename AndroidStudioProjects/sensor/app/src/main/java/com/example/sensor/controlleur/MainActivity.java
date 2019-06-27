package com.example.sensor.controlleur;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
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
    private PackageManager mPackageManager;
    //private LocationManager mLocationManager;


    private TextArea mAcuisitionDisplayArea;
    //private TextArea mAcuisitionDisplayArea;

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

        mMainLayoutDesign = MainLayoutDesign.getInstance();
        mSensorFactory = new SensorFactory();
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mPackageManager=this.getPackageManager();

        //boolean gyro = PM.hasSystemFeature(PackageManager.FEATURE_SENSOR_GYROSCOPE);
        //System.out.println("PRESENCE "+gyro);
        mMainLayoutDesign.setTextTitle((TextView) findViewById(R.id.activity_main_text_titre));
        mMainLayoutDesign.setButton((Button)findViewById(R.id.activity_main_QuitApp));

        Intent intent= getIntent();
        String sensorToEnable= intent.getStringExtra("sensor to enable");
        System.out.println("sensor to enable "+sensorToEnable);
        switch(sensorToEnable){
            case "accelerometer":
                mAcuisitionDisplayArea = new TextArea();
                mAcuisitionDisplayArea.setTextNameSensor((TextView)findViewById(R.id.activity_main_text_sensortype));
                mAcuisitionDisplayArea.setTextValue1((TextView)findViewById(R.id.activity_main_text_value1));
                mAcuisitionDisplayArea.setTextValue2((TextView)findViewById(R.id.activity_main_text_value2));
                mAcuisitionDisplayArea.setTextValue3((TextView)findViewById(R.id.activity_main_text_value3));
                mSAccelerometer = (SAccelerometer) mSensorFactory.creatSensor(mPackageManager,SensorType.ACCELEROMETER_SENSOR,mAcuisitionDisplayArea);
                mSAccelerometer.setADefaultAccelerometerSensor(mSensorManager);
                mAcuisitionDisplayArea.getTextNameSensor().setText("Acceleration (m/s²)");
                //mAcuisitionDisplayArea.setVisiblityState(View.VISIBLE);
                break;
            case "magnetometer":
                mAcuisitionDisplayArea = new TextArea();
                mAcuisitionDisplayArea.setTextNameSensor((TextView)findViewById(R.id.activity_main_text_sensortype));
                mAcuisitionDisplayArea.setTextValue1((TextView)findViewById(R.id.activity_main_text_value1));
                mAcuisitionDisplayArea.setTextValue2((TextView)findViewById(R.id.activity_main_text_value2));
                mAcuisitionDisplayArea.setTextValue3((TextView)findViewById(R.id.activity_main_text_value3));
                mSMagnetometer= (SMagnetometer)mSensorFactory.creatSensor(mPackageManager,SensorType.MAGNETOMETER_SENSOR,mAcuisitionDisplayArea);
                mSMagnetometer.setDefaultMagnetometerSensor(mSensorManager);
                mAcuisitionDisplayArea.getTextNameSensor().setText("Magnetic field (nTesla)");
                break;
            case "gyroscope":
               mAcuisitionDisplayArea = new TextArea();
                mAcuisitionDisplayArea.setTextNameSensor((TextView)findViewById(R.id.activity_main_text_sensortype));
                mAcuisitionDisplayArea.setTextValue1((TextView)findViewById(R.id.activity_main_text_value1));
                mAcuisitionDisplayArea.setTextValue2((TextView)findViewById(R.id.activity_main_text_value2));
                mAcuisitionDisplayArea.setTextValue3((TextView)findViewById(R.id.activity_main_text_value3));
                mSGyroscope = (SGyroscope) mSensorFactory.creatSensor(mPackageManager,SensorType.GYROSCOPE_SENSOR,mAcuisitionDisplayArea);
                mSGyroscope.setADefaultGyroscopeSensor(mSensorManager);
                mAcuisitionDisplayArea.getTextNameSensor().setText("Angular Velocity (rad/s)");
                break;
            case "inclinometer":
                mAcuisitionDisplayArea = new TextArea();
                mAcuisitionDisplayArea.setTextNameSensor((TextView)findViewById(R.id.activity_main_text_sensortype));
                mAcuisitionDisplayArea.setTextValue1((TextView)findViewById(R.id.activity_main_text_value1));
                mAcuisitionDisplayArea.setTextValue2((TextView)findViewById(R.id.activity_main_text_value2));
                mAcuisitionDisplayArea.setTextValue3((TextView)findViewById(R.id.activity_main_text_value3));
                mSRotation = SRotation.getInstance(mAcuisitionDisplayArea).get();
                mAcuisitionDisplayArea.getTextNameSensor().setText("Orientation (deg°)");
                break;
            case "proximeter":
                mAcuisitionDisplayArea = new TextArea();
                mAcuisitionDisplayArea.setTextNameSensor((TextView)findViewById(R.id.activity_main_text_sensortype));
                mAcuisitionDisplayArea.setTextValue1((TextView)findViewById(R.id.activity_main_text_value1));
                mSProximity=(SProximity)mSensorFactory.creatSensor(mPackageManager,SensorType.PROXIMITY_SENSOR,mAcuisitionDisplayArea);
                mSProximity.setADefaultProximitySensor(mSensorManager);
                mAcuisitionDisplayArea.getTextNameSensor().setText("Proximity sensor");
                ((TextView)findViewById(R.id.activity_main_text_value2)).setVisibility(View.INVISIBLE);
                ((TextView)findViewById(R.id.activity_main_text_value3)).setVisibility(View.INVISIBLE);
                break;
            case "photometer":
                mAcuisitionDisplayArea = new TextArea();
                mAcuisitionDisplayArea.setTextNameSensor((TextView)findViewById(R.id.activity_main_text_sensortype));
                mAcuisitionDisplayArea.setTextValue1((TextView)findViewById(R.id.activity_main_text_value1));
                mSPhotometer =(SPhotometer) mSensorFactory.creatSensor(mPackageManager,SensorType.PHOTOMETER_SENSOR,mAcuisitionDisplayArea);
                mSPhotometer.setADefaultPhotometerSensor(mSensorManager);
                mAcuisitionDisplayArea.getTextNameSensor().setText("Luminosity (lux)");
                ((TextView)findViewById(R.id.activity_main_text_value2)).setVisibility(View.INVISIBLE);
                ((TextView)findViewById(R.id.activity_main_text_value3)).setVisibility(View.INVISIBLE);
                break;
        }
        /*mLocationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        LocationProvider locationProvider = mLocationManager.getProvider(mLocationManager.NETWORK_PROVIDER);
        System.out.println("Provider name   " + locationProvider.getName() + "required power   " + locationProvider.getPowerRequirement() + "\n");
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED ) {
            requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION},1);
            return;
        }*/
        //mAcuisitionDisplayArea=new TextArea();

        /*mAcuisitionDisplayArea.setTextNameSensor((TextView)findViewById(R.id.activity_main_text_gps));
        mAcuisitionDisplayArea.setTextValue1((TextView)findViewById(R.id.activity_main_text_latitude));
        mAcuisitionDisplayArea.setTextValue2((TextView)findViewById(R.id.activity_main_text_longitude));
        mAcuisitionDisplayArea.setTextValue3((TextView)findViewById(R.id.activity_main_text_altitude));*/

        /*mMainLayoutDesign.getButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });*/
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
                    mAcuisitionDisplayArea.getTextValue1().setText(""+(double)Math.round(mLocationManager.getLastKnownLocation("gps").getLatitude()* 100000000) / 100000000+"°");
                    mAcuisitionDisplayArea.getTextValue2().setText(""+(double)Math.round(mLocationManager.getLastKnownLocation("gps").getLongitude()* 100000000) / 100000000+"°");
                    mAcuisitionDisplayArea.getTextValue3().setText(""+(double)Math.round(mLocationManager.getLastKnownLocation("gps").getAltitude()* 100) / 100+" (m)");
                }
        }
    }*/

    protected void onResume() {
        super.onResume();

        if(mSAccelerometer!=null) {
            if (mSAccelerometer.getAccelerometerSensor().isPresent()) {
                mSensorManager.registerListener(mSAccelerometer, mSAccelerometer.getAccelerometerSensor().get(), SensorManager.SENSOR_DELAY_UI);
            }
        }

        if(mSProximity!=null){
            if (mSProximity.getProximitySensor().isPresent()) {
                mSensorManager.registerListener(mSProximity, mSProximity.getProximitySensor().get(), SensorManager.SENSOR_DELAY_UI);
            }
        }

        if(mSPhotometer!=null){
            if (mSPhotometer.getPhotometerSensor().isPresent()) {
                mSensorManager.registerListener(mSPhotometer, mSPhotometer.getPhotometerSensor().get(), SensorManager.SENSOR_DELAY_UI);
            }
        }

        if(mSMagnetometer!=null){
            if (mSMagnetometer.getMagnetometerSensor().isPresent()) {
                mSensorManager.registerListener(mSMagnetometer, mSMagnetometer.getMagnetometerSensor().get(), SensorManager.SENSOR_DELAY_UI);
            }
        }

        if(mSMagnetometer!=null&&mSAccelerometer!=null){
            if (mSMagnetometer.getMagnetometerSensor().isPresent() && mSAccelerometer.getAccelerometerSensor().isPresent()) {
                mSensorManager.registerListener(mSRotation, mSAccelerometer.getAccelerometerSensor().get(), SensorManager.SENSOR_DELAY_UI);
                mSensorManager.registerListener(mSRotation, mSMagnetometer.getMagnetometerSensor().get(), SensorManager.SENSOR_DELAY_UI);
            }
        }

        if(mSGyroscope!=null&&this.getPackageManager().hasSystemFeature(PackageManager.FEATURE_SENSOR_GYROSCOPE)){
            if (mSGyroscope.getGyroscopeSensor().isPresent()) {
                try {
                    mSensorManager.registerListener(mSGyroscope, mSGyroscope.getGyroscopeSensor().get(), SensorManager.SENSOR_DELAY_UI);
                } catch (Exception e){


                }

            }
        }
    }

    protected void onPause() {
        super.onPause();
        if(mSAccelerometer!=null) {
            mSensorManager.unregisterListener(mSAccelerometer, mSAccelerometer.getAccelerometerSensor().get());
        }

        if(mSMagnetometer!=null) {

        }

        if(mSProximity!=null) {
            mSensorManager.unregisterListener(mSProximity, mSProximity.getProximitySensor().get());
        }

        if(mSPhotometer!=null) {
            mSensorManager.unregisterListener(mSPhotometer, mSPhotometer.getPhotometerSensor().get());
        }

        if(mSGyroscope!=null){
            mSensorManager.unregisterListener(mSGyroscope,mSGyroscope.getGyroscopeSensor().get());
        }

        finish();
    }
    /*@Override

    public void onLocationChanged(Location location) {
        mAcuisitionDisplayArea.getTextValue1().setText(""+(double)Math.round(mLocationManager.getLastKnownLocation("gps").getLatitude()* 100000000) / 100000000+"°");
        mAcuisitionDisplayArea.getTextValue2().setText(""+(double)Math.round(mLocationManager.getLastKnownLocation("gps").getLongitude()* 100000000) / 100000000+"°");
        mAcuisitionDisplayArea.getTextValue3().setText(""+(double)Math.round(mLocationManager.getLastKnownLocation("gps").getAltitude()* 100) / 100+" (m)");
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


