package com.example.sensor.controlleur;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.location.LocationProvider;
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

public class MainActivity extends AppCompatActivity {
    private MainLayoutDesign mMainLayoutDesign;
    private SensorFactory mSensorFactory;
    private SensorManager mSensorManager;
    private LocationManager mLocationManager;
    Criteria critere = new Criteria();


    private TextArea mTextAreaAccelerometer;
    private TextArea mTextAreaProximity;
    private TextArea mTextAreaPhotometer;
    private TextArea mTextAreaMagnetometer;
    private TextArea mTextAreaGyroscope;
    private TextArea mTextAreaRotation;

    private SAccelerometer mSAccelerometer;
    private SProximity mSProximity;
    private SPhotometer mSPhotometer;
    private SMagnetometer mSMagnetometer;
    private SGyroscope mSGyroscope;
    private SRotation mSRotation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

       /* mLocationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
// Pour indiquer la précision voulue
// On peut mettre ACCURACY_FINE pour une haute précision ou ACCURACY_COARSE pour une moins bonne précision
        critere.setAccuracy(Criteria.ACCURACY_FINE);

// Est-ce que le fournisseur doit être capable de donner une altitude ?
        critere.setAltitudeRequired(true);

// Est-ce que le fournisseur doit être capable de donner une direction ?
        critere.setBearingRequired(true);

// Est-ce que le fournisseur peut être payant ?
        critere.setCostAllowed(false);

// Pour indiquer la consommation d'énergie demandée
// Criteria.POWER_HIGH pour une haute consommation, Criteria.POWER_MEDIUM pour une consommation moyenne et Criteria.POWER_LOW pour une basse consommation
        critere.setPowerRequirement(Criteria.POWER_HIGH);

// Est-ce que le fournisseur doit être capable de donner une vitesse ?
        critere.setSpeedRequired(true);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);

        LocationProvider locationProvider=mLocationManager.getProvider(mLocationManager.GPS_PROVIDER);
        mLocationManager.requestLocationUpdates(locationProvider.getName(),);
        // System.out.println("provider="+providerName);
        //if(mLocationManager.getProvider(providerName)==null)
        // System.out.println("jkgfjghrfyugfkihu");
        //LocationProvider locationProvider=mLocationManager.getProvider(providerName);
        System.out.println("jkgfuihih   "+locationProvider.getName()+"   "+ locationProvider.getPowerRequirement());*/

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMainLayoutDesign = MainLayoutDesign.getInstance();
        mSensorFactory = new SensorFactory();
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);


        mTextAreaAccelerometer = new TextArea();
        mTextAreaProximity = new TextArea();
        mTextAreaPhotometer = new TextArea();
        mTextAreaMagnetometer = new TextArea();
        mTextAreaGyroscope = new TextArea();
        mTextAreaRotation = new TextArea();


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

        mSAccelerometer = (SAccelerometer) mSensorFactory.creatSensor(SensorType.ACCELEROMETER_SENSOR, mTextAreaAccelerometer);
        mSProximity = (SProximity) mSensorFactory.creatSensor(SensorType.PROXIMITY_SENSOR, mTextAreaProximity);
        mSPhotometer = (SPhotometer) mSensorFactory.creatSensor(SensorType.PHOTOMETER_SENSOR, mTextAreaPhotometer);
        mSMagnetometer = (SMagnetometer) mSensorFactory.creatSensor(SensorType.MAGNETOMETER_SENSOR, mTextAreaMagnetometer);
        mSGyroscope = (SGyroscope) mSensorFactory.creatSensor(SensorType.GYROSCOPE_SENSOR, mTextAreaGyroscope);
        //mSRotation=(SRotation) mSensorFactory.creatSensor(SensorType.ROTATION_SENSOR,mTextAreaRotation);
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

   /* public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }
            // other 'case' lines to check for other
            // permissions this app might request
        }
    }*/
}


