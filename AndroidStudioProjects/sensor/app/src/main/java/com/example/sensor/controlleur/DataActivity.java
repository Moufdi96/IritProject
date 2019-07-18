package com.example.sensor.controlleur;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.hardware.Sensor;
import android.location.Location;
import android.location.LocationManager;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.hardware.SensorManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import com.example.sensor.model.GSensorListener;
import com.example.sensor.R;
import com.example.sensor.model.MainLayoutDesign;
import com.example.sensor.model.material_sensor.SAccelerometer;
import com.example.sensor.model.material_sensor.SGps;
import com.example.sensor.model.material_sensor.SGyroscope;
import com.example.sensor.model.material_sensor.SMagnetometer;
import com.example.sensor.model.material_sensor.SPhotometer;
import com.example.sensor.model.material_sensor.SProximity;
import com.example.sensor.model.virtual_sensor.SRotation;
import com.example.sensor.model.SensorFactory;
import com.example.sensor.model.SensorType;
import com.example.sensor.model.TextArea;

public class DataActivity extends AppCompatActivity {
    public  final int settingsActivityRequestCode=6;
    private MainLayoutDesign mMainLayoutDesign;
    private SensorFactory mSensorFactory;
    private SensorManager mSensorManager;
    private PackageManager mPackageManager;
    private LocationManager mLocationManager;
    private TextArea mAcuisitionDisplayArea;
    private SAccelerometer mSAccelerometer;
    private SProximity mSProximity;
    private SPhotometer mSPhotometer;
    private SMagnetometer mSMagnetometer;
    private SGyroscope mSGyroscope;
    private SRotation mSRotation;
    private SGps mSGps;
    private ImageButton mSensorInfoButton;
    private String[] mEnabedSensorInfo; //this array contain the technical information of the current enabled sensor
    private ImageButton mSensorSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        Log.d("dataActivity","onCreat invoked");
        mMainLayoutDesign = MainLayoutDesign.getInstance();
        mSensorFactory = new SensorFactory();
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mPackageManager = this.getPackageManager();
        mMainLayoutDesign.setTextTitle((TextView) findViewById(R.id.activity_main_text_titre));
        mMainLayoutDesign.setButton((ImageButton)findViewById(R.id.activity_main_QuitApp));
        mLocationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        mSensorInfoButton=(ImageButton)findViewById(R.id.activity_main_Button_info);
        mEnabedSensorInfo=new String[8];
        mSensorSettings=(ImageButton)findViewById(R.id.activity_main_Button_settings);
       // System.out.println("hhh"+mLocationManager.getProvider("gps").getPowerRequirement()+""+mLocationManager.getProvider("gps").requiresNetwork()+""+mLocationManager.getProvider("gps").requiresSatellite());


        final Intent intent = getIntent();
        String sensorToEnable = intent.getStringExtra("sensor to enable");
        switch (sensorToEnable) {
            case "accelerometer":
                mAcuisitionDisplayArea = new TextArea();
                mAcuisitionDisplayArea.setTextNameSensor((TextView) findViewById(R.id.activity_main_text_sensortype));
                mAcuisitionDisplayArea.setTextValue1((TextView) findViewById(R.id.activity_main_text_value1));
                mAcuisitionDisplayArea.setTextValue2((TextView) findViewById(R.id.activity_main_text_value2));
                mAcuisitionDisplayArea.setTextValue3((TextView) findViewById(R.id.activity_main_text_value3));
                mSAccelerometer = (SAccelerometer) mSensorFactory.creatSensor(mPackageManager, SensorType.ACCELEROMETER_SENSOR,mSensorManager);
                mAcuisitionDisplayArea.getTextNameSensor().setText("Acceleration (   m/s²)");
                break;
            case "magnetometer":
                mAcuisitionDisplayArea = new TextArea();
                mAcuisitionDisplayArea.setTextNameSensor((TextView) findViewById(R.id.activity_main_text_sensortype));
                mAcuisitionDisplayArea.setTextValue1((TextView) findViewById(R.id.activity_main_text_value1));
                mAcuisitionDisplayArea.setTextValue2((TextView) findViewById(R.id.activity_main_text_value2));
                mAcuisitionDisplayArea.setTextValue3((TextView) findViewById(R.id.activity_main_text_value3));
                mSMagnetometer = (SMagnetometer) mSensorFactory.creatSensor(mPackageManager, SensorType.MAGNETOMETER_SENSOR,mSensorManager);
                mAcuisitionDisplayArea.getTextNameSensor().setText("Magnetic field (nTesla)");
                break;
            case "gyroscope":
                mAcuisitionDisplayArea = new TextArea();
                mAcuisitionDisplayArea.setTextNameSensor((TextView) findViewById(R.id.activity_main_text_sensortype));
                mAcuisitionDisplayArea.setTextValue1((TextView) findViewById(R.id.activity_main_text_value1));
                mAcuisitionDisplayArea.setTextValue2((TextView) findViewById(R.id.activity_main_text_value2));
                mAcuisitionDisplayArea.setTextValue3((TextView) findViewById(R.id.activity_main_text_value3));
                mSGyroscope = (SGyroscope) mSensorFactory.creatSensor(mPackageManager, SensorType.GYROSCOPE_SENSOR,mSensorManager);
                mAcuisitionDisplayArea.getTextNameSensor().setText("Angular Velocity (rad/s)");
                break;
            case "proximeter":
                mAcuisitionDisplayArea = new TextArea();
                mAcuisitionDisplayArea.setTextNameSensor((TextView) findViewById(R.id.activity_main_text_sensortype));
                mAcuisitionDisplayArea.setTextValue1((TextView) findViewById(R.id.activity_main_text_value1));
                mSProximity = (SProximity) mSensorFactory.creatSensor(mPackageManager, SensorType.PROXIMITY_SENSOR,mSensorManager);
                mAcuisitionDisplayArea.getTextNameSensor().setText("Proximity sensor");
                (findViewById(R.id.activity_main_text_value2)).setVisibility(View.INVISIBLE);
                (findViewById(R.id.activity_main_text_value3)).setVisibility(View.INVISIBLE);
                break;
            case "photometer":
                mAcuisitionDisplayArea = new TextArea();
                mAcuisitionDisplayArea.setTextNameSensor((TextView) findViewById(R.id.activity_main_text_sensortype));
                mAcuisitionDisplayArea.setTextValue1((TextView) findViewById(R.id.activity_main_text_value1));
                mSPhotometer = (SPhotometer) mSensorFactory.creatSensor(mPackageManager, SensorType.PHOTOMETER_SENSOR,mSensorManager);
                mAcuisitionDisplayArea.getTextNameSensor().setText("Luminosity (lux)");
                (findViewById(R.id.activity_main_text_value2)).setVisibility(View.INVISIBLE);
                (findViewById(R.id.activity_main_text_value3)).setVisibility(View.INVISIBLE);
                break;
            case "inclinometer":
                mAcuisitionDisplayArea = new TextArea();
                mAcuisitionDisplayArea.setTextNameSensor((TextView) findViewById(R.id.activity_main_text_sensortype));
                mAcuisitionDisplayArea.setTextValue1((TextView) findViewById(R.id.activity_main_text_value1));
                mAcuisitionDisplayArea.setTextValue2((TextView) findViewById(R.id.activity_main_text_value2));
                mAcuisitionDisplayArea.setTextValue3((TextView) findViewById(R.id.activity_main_text_value3));
                mSRotation = SRotation.getInstance(mPackageManager, mAcuisitionDisplayArea, mSensorManager);
                mAcuisitionDisplayArea.getTextNameSensor().setText("Inclinometer");
                break;
            case "gps":
                mAcuisitionDisplayArea = new TextArea();
                mAcuisitionDisplayArea.setTextNameSensor((TextView) findViewById(R.id.activity_main_text_sensortype));
                mAcuisitionDisplayArea.setTextValue1((TextView) findViewById(R.id.activity_main_text_value1));
                mAcuisitionDisplayArea.setTextValue2((TextView) findViewById(R.id.activity_main_text_value2));
                mAcuisitionDisplayArea.setTextValue3((TextView) findViewById(R.id.activity_main_text_value3));
                mSGps = new SGps(mLocationManager, mAcuisitionDisplayArea);
                mAcuisitionDisplayArea.getTextNameSensor().setText("GPS");
                break;
        }

        mMainLayoutDesign.getButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mSensorInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sensorInfoActivity=new Intent(DataActivity.this, SensorInfoActivity.class);
                sensorInfoActivity.putExtra("enabled sensor info",mEnabedSensorInfo);
                mMainLayoutDesign.getButton().setVisibility(View.INVISIBLE);
                startActivity(sensorInfoActivity);
                mMainLayoutDesign.getButton().setVisibility(View.INVISIBLE);
            }
        });

        mSensorSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sensorSettingsActivity=new Intent(DataActivity.this, SettingsActivity.class);
                sensorSettingsActivity.putExtra("rate",mSAccelerometer.getAccelerometerSettings().getAcquisitionRate());
                startActivityForResult(sensorSettingsActivity,settingsActivityRequestCode);
            }
        });


    }

    protected void onResume() {
        super.onResume();
        mMainLayoutDesign.getButton().setVisibility(View.VISIBLE);
        Log.d("dataActivity","onResume invoked");
        if (mSAccelerometer != null) {
            if (mSAccelerometer.getAccelerometerSensor().isPresent()) {
                mSensorManager.registerListener(mSAccelerometer, mSAccelerometer.getAccelerometerSensor().get(),mSAccelerometer.getAccelerometerSettings().getAcquisitionRate());
                mSAccelerometer.setListener(new GSensorListener() {
                    @Override
                    public void perceived(Sensor sensor, double val1, double val2, double val3) {
                        mAcuisitionDisplayArea.getTextValue1().setText(val1+"    m/s²");
                        mAcuisitionDisplayArea.getTextValue2().setText(val2+"    m/s²");
                        mAcuisitionDisplayArea.getTextValue3().setText(val3+"    m/s²");
                        //mEnabedSensorInfo[0]="Accelerometer";
                        mEnabedSensorInfo[1]=""+sensor.getName();
                        mEnabedSensorInfo[2]=""+sensor.getVersion();
                             mEnabedSensorInfo[3]=""+sensor.getPower()+ " mA";
                        mEnabedSensorInfo[4]=""+sensor.getMaximumRange()+ " mA";
                         mEnabedSensorInfo[5]=""+sensor.getMinDelay()+ " ms";
                         mEnabedSensorInfo[6]=""+sensor.getMaxDelay()+ " ms";
                        mEnabedSensorInfo[7]=""+sensor.getResolution()+"   m/s²";
                    }
                });
            }
        }

        if (mSProximity != null) {
            if (mSProximity.getProximitySensor().isPresent()) {
                mSensorManager.registerListener(mSProximity, mSProximity.getProximitySensor().get(), SensorManager.SENSOR_DELAY_UI);
                mSProximity.setListener(new GSensorListener() {
                    @Override
                    public void perceived(Sensor sensor,double val1,double val2,double val3) {
                        if (val1==0){
                            mAcuisitionDisplayArea.getTextValue1().setText("Object detected");
                            mAcuisitionDisplayArea.getTextValue1().setBackgroundColor(Color.GREEN);
                        } else {
                            mAcuisitionDisplayArea.getTextValue1().setText("no object detected");
                            mAcuisitionDisplayArea.getTextValue1().setBackgroundColor(0xffffffff);
                        }
                        //mEnabedSensorInfo[0]="Accelerometer";
                        mEnabedSensorInfo[1]=""+sensor.getName();
                        mEnabedSensorInfo[2]=""+sensor.getVersion();
                             mEnabedSensorInfo[3]=""+sensor.getPower()+ " mA";
                        mEnabedSensorInfo[4]=""+sensor.getMaximumRange()+ " mm";
                         mEnabedSensorInfo[5]=""+sensor.getMinDelay()+ " ms";
                         mEnabedSensorInfo[6]=""+sensor.getMaxDelay()+ " ms";
                        mEnabedSensorInfo[7]=""+sensor.getResolution()+"   mm";
                    }
                });
            }
        }

        if (mSPhotometer != null) {
            if (mSPhotometer.getPhotometerSensor().isPresent()) {
                mSensorManager.registerListener(mSPhotometer, mSPhotometer.getPhotometerSensor().get(), SensorManager.SENSOR_DELAY_UI);
                mSPhotometer.setListener(new GSensorListener() {
                    @Override
                    public void perceived(Sensor sensor,double val1,double val2,double val3) {
                        mAcuisitionDisplayArea.getTextValue1().setText(val1+" lux");
                        //mEnabedSensorInfo[0]="Accelerometer";
                        mEnabedSensorInfo[1]=""+sensor.getName();
                        mEnabedSensorInfo[2]=""+sensor.getVersion();
                             mEnabedSensorInfo[3]=""+sensor.getPower()+ " mA";
                        mEnabedSensorInfo[4]=""+sensor.getMaximumRange()+ " lux";
                         mEnabedSensorInfo[5]=""+sensor.getMinDelay()+ " ms";
                         mEnabedSensorInfo[6]=""+sensor.getMaxDelay()+ " ms";
                        mEnabedSensorInfo[7]=""+sensor.getResolution()+" lux";
                    }
                });
            }
        }

        if (mSMagnetometer != null) {
            if (mSMagnetometer.getMagnetometerSensor().isPresent()) {
                mSensorManager.registerListener(mSMagnetometer, mSMagnetometer.getMagnetometerSensor().get(), SensorManager.SENSOR_DELAY_UI);
                mSMagnetometer.setListener(new GSensorListener() {
                    @Override
                    public void perceived(Sensor sensor,double val1,double val2,double val3) {
                        mAcuisitionDisplayArea.getTextValue1().setText(val1+" nT");
                        mAcuisitionDisplayArea.getTextValue2().setText(val2+" nT");
                        mAcuisitionDisplayArea.getTextValue3().setText(val3+" nT");
                        //mEnabedSensorInfo[0]="Accelerometer";
                        mEnabedSensorInfo[1]=""+sensor.getName();
                        mEnabedSensorInfo[2]=""+sensor.getVersion();
                             mEnabedSensorInfo[3]=""+sensor.getPower()+ " mA";
                        mEnabedSensorInfo[4]=""+sensor.getMaximumRange()+ " nT";
                         mEnabedSensorInfo[5]=""+sensor.getMinDelay()+ " ms";
                         mEnabedSensorInfo[6]=""+sensor.getMaxDelay()+ " ms";
                        mEnabedSensorInfo[7]=""+sensor.getResolution()+" nT";
                    }
                });
            }
        }

        if (mSRotation != null) {
            if (mSRotation.getMagnetometerSensor() != null && mSRotation.getAccelerometerSensor() != null) {
                mSensorManager.registerListener(mSRotation, mSRotation.getAccelerometerSensor(), SensorManager.SENSOR_DELAY_UI);
                mSensorManager.registerListener(mSRotation, mSRotation.getMagnetometerSensor(), SensorManager.SENSOR_DELAY_UI);
                mSRotation.setListener(new GSensorListener() {
                    @Override
                    public void perceived(Sensor sensor,double val1,double val2,double val3) {
                        mAcuisitionDisplayArea.getTextValue1().setText(val1*180/3.14+"°");//Yaw
                        mAcuisitionDisplayArea.getTextValue2().setText(val2*180/3.14+"°");//Pitch
                        mAcuisitionDisplayArea.getTextValue3().setText(val3*180/3.14+"°");//Roll
                    }
                });
            }
        }

        if (mSGyroscope != null) {
            if (mSGyroscope.getGyroscopeSensor().isPresent()) {
                mSensorManager.registerListener(mSGyroscope, mSGyroscope.getGyroscopeSensor().get(), SensorManager.SENSOR_DELAY_UI);
                mSGyroscope.setListener(new GSensorListener() {
                    @Override
                    public void perceived(Sensor sensor,double val1,double val2,double val3) {
                        mAcuisitionDisplayArea.getTextValue1().setText(val1+" rad/s");
                        mAcuisitionDisplayArea.getTextValue2().setText(val2+" rad/s");
                        mAcuisitionDisplayArea.getTextValue3().setText(val3+" rad/s");
                        //mEnabedSensorInfo[0]="Accelerometer";
                        mEnabedSensorInfo[1]=""+sensor.getName();
                        mEnabedSensorInfo[2]=""+sensor.getVersion();
                             mEnabedSensorInfo[3]=""+sensor.getPower()+ " mA";
                        mEnabedSensorInfo[4]=""+sensor.getMaximumRange()+ " rad/s";
                         mEnabedSensorInfo[5]=""+sensor.getMinDelay()+ " ms";
                         mEnabedSensorInfo[6]=""+sensor.getMaxDelay()+ " ms";
                        mEnabedSensorInfo[7]=""+sensor.getResolution()+" rad/s";

                    }
                });
            }
        }

        if (mSGps != null) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            Location location = mLocationManager.getLastKnownLocation("network");

            String s1 = "" + (double) Math.round(location.getLatitude() * 100000000) / 100000000 + "°";
            String s2 = ""+(double)Math.round(location.getLongitude()* 100000000) / 100000000+"°";
            String s3 = ""+(double)Math.round(location.getAltitude()* 100) / 100+" (m)";

            mAcuisitionDisplayArea.getTextValue1().setText(s1);
            mAcuisitionDisplayArea.getTextValue2().setText(s2);
            mAcuisitionDisplayArea.getTextValue3().setText(s3);

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==settingsActivityRequestCode && resultCode==RESULT_OK){
            int rate=data.getIntExtra("acquisitionRate",3);
            mSAccelerometer.getAccelerometerSettings().setAcquisitionRate(rate);
        }
    }

    protected void onPause() {
        super.onPause();
        Log.d("dataActivity","onPause invoked");
        if(mSAccelerometer!=null) {
            mSensorManager.unregisterListener(mSAccelerometer, mSAccelerometer.getAccelerometerSensor().get());
        }

        if(mSMagnetometer!=null) {
            mSensorManager.unregisterListener(mSMagnetometer, mSMagnetometer.getMagnetometerSensor().get());
        }

        if(mSProximity!=null) {
            mSensorManager.unregisterListener(mSProximity, mSProximity.getProximitySensor().get());
        }

        if(mSPhotometer!=null) {
            mSensorManager.unregisterListener(mSPhotometer, mSPhotometer.getPhotometerSensor().get());
        }

        if(mSRotation!=null){
            mSensorManager.unregisterListener(mSRotation, mSRotation.getAccelerometerSensor());
            mSensorManager.unregisterListener(mSRotation, mSRotation.getMagnetometerSensor());
        }

        if(mSGyroscope!=null){
            mSensorManager.unregisterListener(mSGyroscope,mSGyroscope.getGyroscopeSensor().get());
        }

        if(mSGps!=null){
        }
    }
}