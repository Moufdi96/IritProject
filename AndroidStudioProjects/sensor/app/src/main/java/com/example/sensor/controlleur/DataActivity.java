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
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sensor.model.EnabledSensorInfo;
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
    private int mSettingsActivityRequestCode;
    private int mAcquisitionRate;
    private int mAcquisitionAccuracy;
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
    private EnabledSensorInfo mEnabledSensorInfo;
    private boolean mStartSensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setBackgroundColor(0xffffffff);
        setContentView(R.layout.activity_data);
        Log.d("dataActivity","onCreat invoked");
        mMainLayoutDesign = MainLayoutDesign.getInstance();
        mSensorFactory = new SensorFactory();
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mPackageManager = this.getPackageManager();
        mMainLayoutDesign.setTextTitle((TextView) findViewById(R.id.activity_main_text_titre));
        mMainLayoutDesign.setReturnHome((ImageButton)findViewById(R.id.activity_data_back_button));
        mLocationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        mMainLayoutDesign.setSensorInfoButton((ImageButton)findViewById(R.id.activity_main_Button_info));
        mMainLayoutDesign.setSensorSettings((ImageButton)findViewById(R.id.activity_main_Button_settings));
        mMainLayoutDesign.setSensorPause((ImageButton)findViewById(R.id.activity_data_stop_button));
        mMainLayoutDesign.setSensorStart((ImageButton)findViewById(R.id.activity_data_start_button));
        mStartSensor=false;

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
                mSettingsActivityRequestCode = mSAccelerometer.getAccelerometerSettings().getSettingsActivityRequestCode();
                mAcquisitionRate=mSAccelerometer.getAccelerometerSettings().getAcquisitionRate();
                mAcquisitionAccuracy = mSAccelerometer.getAccelerometerSettings().getAccuracy();
                mAcuisitionDisplayArea.getTextNameSensor().setText("Acceleration (m/s²)");
                mAcuisitionDisplayArea.getTextValue1().setText("Ax");
                mAcuisitionDisplayArea.getTextValue2().setText("Ay");
                mAcuisitionDisplayArea.getTextValue3().setText("Az");
                break;
            case "magnetometer":
                mAcuisitionDisplayArea = new TextArea();
                mAcuisitionDisplayArea.setTextNameSensor((TextView) findViewById(R.id.activity_main_text_sensortype));
                mAcuisitionDisplayArea.setTextValue1((TextView) findViewById(R.id.activity_main_text_value1));
                mAcuisitionDisplayArea.setTextValue2((TextView) findViewById(R.id.activity_main_text_value2));
                mAcuisitionDisplayArea.setTextValue3((TextView) findViewById(R.id.activity_main_text_value3));
                mSMagnetometer = (SMagnetometer) mSensorFactory.creatSensor(mPackageManager, SensorType.MAGNETOMETER_SENSOR,mSensorManager);
                mSettingsActivityRequestCode = mSMagnetometer.getMagnetometerSettings().getSettingsActivityRequestCode();
                mAcquisitionRate=mSMagnetometer.getMagnetometerSettings().getAcquisitionRate();
                mAcquisitionAccuracy = mSMagnetometer.getMagnetometerSettings().getAccuracy();
                mAcuisitionDisplayArea.getTextNameSensor().setText("Magnetic field (nTesla)");
                mAcuisitionDisplayArea.getTextValue1().setText("Mx");
                mAcuisitionDisplayArea.getTextValue2().setText("My");
                mAcuisitionDisplayArea.getTextValue3().setText("Mz");
                break;
            case "gyroscope":
                mAcuisitionDisplayArea = new TextArea();
                mAcuisitionDisplayArea.setTextNameSensor((TextView) findViewById(R.id.activity_main_text_sensortype));
                mAcuisitionDisplayArea.setTextValue1((TextView) findViewById(R.id.activity_main_text_value1));
                mAcuisitionDisplayArea.setTextValue2((TextView) findViewById(R.id.activity_main_text_value2));
                mAcuisitionDisplayArea.setTextValue3((TextView) findViewById(R.id.activity_main_text_value3));
                mSGyroscope = (SGyroscope) mSensorFactory.creatSensor(mPackageManager, SensorType.GYROSCOPE_SENSOR,mSensorManager);
                mSettingsActivityRequestCode = mSGyroscope.getGyroscopeSettings().getSettingsActivityRequestCode();
                mAcquisitionAccuracy = mSGyroscope.getGyroscopeSettings().getAccuracy();
                mSensorManager.registerListener(mSGyroscope, mSGyroscope.getGyroscopeSensor().get(),mAcquisitionRate);
                mAcuisitionDisplayArea.getTextNameSensor().setText("Angular Velocity (rad/s)");
                mAcuisitionDisplayArea.getTextValue1().setText("Gx");
                mAcuisitionDisplayArea.getTextValue2().setText("Gy");
                mAcuisitionDisplayArea.getTextValue3().setText("Gz");
                break;
            case "proximeter":
                mAcuisitionDisplayArea = new TextArea();
                mAcuisitionDisplayArea.setTextNameSensor((TextView) findViewById(R.id.activity_main_text_sensortype));
                mAcuisitionDisplayArea.setTextValue1((TextView) findViewById(R.id.activity_main_text_value1));
                mSProximity = (SProximity) mSensorFactory.creatSensor(mPackageManager, SensorType.PROXIMITY_SENSOR,mSensorManager);
                mSettingsActivityRequestCode = mSProximity.getProximitySettings().getSettingsActivityRequestCode();
                mAcquisitionRate=mSProximity.getProximitySettings().getAcquisitionRate();
                mAcquisitionAccuracy = mSProximity.getProximitySettings().getAccuracy();
                mAcquisitionRate=mSProximity.getProximitySettings().getAcquisitionRate();
                (findViewById(R.id.activity_main_text_value2)).setVisibility(View.INVISIBLE);
                (findViewById(R.id.activity_main_text_value3)).setVisibility(View.INVISIBLE);
                break;
            case "photometer":
                mAcuisitionDisplayArea = new TextArea();
                mAcuisitionDisplayArea.setTextNameSensor((TextView) findViewById(R.id.activity_main_text_sensortype));
                mAcuisitionDisplayArea.setTextValue1((TextView) findViewById(R.id.activity_main_text_value1));
                mSPhotometer = (SPhotometer) mSensorFactory.creatSensor(mPackageManager, SensorType.PHOTOMETER_SENSOR,mSensorManager);
                mSettingsActivityRequestCode = mSPhotometer.getPhotometerSettings().getSettingsActivityRequestCode();
                mAcquisitionRate=mSPhotometer.getPhotometerSettings().getAcquisitionRate();
                mAcquisitionAccuracy = mSPhotometer.getPhotometerSettings().getAccuracy();
                mAcuisitionDisplayArea.getTextNameSensor().setText("Luminosity (lux)");
                (findViewById(R.id.activity_main_text_value2)).setVisibility(View.INVISIBLE);
                (findViewById(R.id.activity_main_text_value3)).setVisibility(View.INVISIBLE);
                mAcuisitionDisplayArea.getTextValue1().setText("Luminosity");
                break;
            case "inclinometer":
                mAcuisitionDisplayArea = new TextArea();
                mAcuisitionDisplayArea.setTextNameSensor((TextView) findViewById(R.id.activity_main_text_sensortype));
                mAcuisitionDisplayArea.setTextValue1((TextView) findViewById(R.id.activity_main_text_value1));
                mAcuisitionDisplayArea.setTextValue2((TextView) findViewById(R.id.activity_main_text_value2));
                mAcuisitionDisplayArea.setTextValue3((TextView) findViewById(R.id.activity_main_text_value3));
                mSRotation = SRotation.getInstance(mPackageManager, mAcuisitionDisplayArea, mSensorManager);
                mSettingsActivityRequestCode = mSRotation.getmRotationSettings().getSettingsActivityRequestCode();
                mAcquisitionRate = mSRotation.getmRotationSettings().getAcquisitionRate();
                mAcquisitionAccuracy = mSRotation.getmRotationSettings().getAccuracy();
                mAcuisitionDisplayArea.getTextNameSensor().setText("Inclinometer");
                mAcuisitionDisplayArea.getTextValue1().setText("Ix");
                mAcuisitionDisplayArea.getTextValue2().setText("Iy");
                mAcuisitionDisplayArea.getTextValue3().setText("Iz");
                break;
            case "gps":
                mAcuisitionDisplayArea = new TextArea();
                mAcuisitionDisplayArea.setTextNameSensor((TextView) findViewById(R.id.activity_main_text_sensortype));
                mAcuisitionDisplayArea.setTextValue1((TextView) findViewById(R.id.activity_main_text_value1));
                mAcuisitionDisplayArea.setTextValue2((TextView) findViewById(R.id.activity_main_text_value2));
                mAcuisitionDisplayArea.setTextValue3((TextView) findViewById(R.id.activity_main_text_value3));
                mSGps = new SGps(mLocationManager, mAcuisitionDisplayArea);
                mAcuisitionDisplayArea.getTextNameSensor().setText("GPS");
                mSettingsActivityRequestCode = mSGps.getGpsSettings().getSettingsActivityRequestCode();
                mAcquisitionRate=mSGps.getGpsSettings().getAcquisitionRate();
                mAcquisitionAccuracy = mSGps.getGpsSettings().getAccuracy();
                break;
        }

        mMainLayoutDesign.getReturnHome().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mMainLayoutDesign.getSensorInfoButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent sensorInfoActivity=new Intent(DataActivity.this, SensorInfoActivity.class);
                    sensorInfoActivity.putExtra("enabled sensor info",new String[]{mEnabledSensorInfo.getSensorName(),mEnabledSensorInfo.getSnsorVersion(),
                            mEnabledSensorInfo.getSensorAcquisitionRate(),mEnabledSensorInfo.getSensorPower(),mEnabledSensorInfo.getSensorMaxRange(),
                            mEnabledSensorInfo.getSensorMinDelay(),mEnabledSensorInfo.getSensorMaxDelay(),mEnabledSensorInfo.getSensorResolution(),
                            mEnabledSensorInfo.getSensorAcquisitionRate()});
                    mMainLayoutDesign.getReturnHome().setVisibility(View.INVISIBLE);
                    mMainLayoutDesign.getSensorStart().setVisibility(View.INVISIBLE);
                    mMainLayoutDesign.getSensorPause().setVisibility(View.INVISIBLE);
                    startActivity(sensorInfoActivity);
                }catch (Exception e){
                    Toast.makeText(DataActivity.this,"click start button to collect sensor info",Toast.LENGTH_LONG).show();
                }

            }
        });

       mMainLayoutDesign.getSensorSettings().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sensorSettingsActivity=new Intent(DataActivity.this, SettingsActivity.class);
                sensorSettingsActivity.putExtra("settings",new int[]{mAcquisitionRate,mAcquisitionAccuracy});
                stoptSensor();
                startActivityForResult(sensorSettingsActivity,mSettingsActivityRequestCode);

            }
        });

       mMainLayoutDesign.getSensorStart().setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startSensor();
           }
       });

       mMainLayoutDesign.getSensorPause().setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               stoptSensor();
           }
       });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==mSettingsActivityRequestCode && resultCode==RESULT_OK){
            int rate=data.getIntExtra("acquisitionRate",3);
            int [] settings=data.getIntArrayExtra("setting");

            switch(settings[0]){
                case 0:
                    switch (mSettingsActivityRequestCode) {

                        case 0:
                            mSAccelerometer.getAccelerometerSettings().setAcquisitionRate(settings[1]);
                            break;
                        case 1:
                            mSProximity.getProximitySettings().setAcquisitionRate(settings[1]);
                            break;
                        case 2:
                            mSPhotometer.getPhotometerSettings().setAcquisitionRate(settings[1]);
                            break;
                        case 3:
                            mSRotation.getmRotationSettings().setAcquisitionRate(settings[1]);
                            break;
                        case 4:
                            mSMagnetometer.getMagnetometerSettings().setAcquisitionRate(settings[1]);
                            break;
                        case 5:
                            mSGyroscope.getGyroscopeSettings().setAcquisitionRate(settings[1]);
                        case 6:
                            mSGps.getGpsSettings().setAcquisitionRate(settings[1]);
                            break;
                    }
                    break;

                case 1:
                    switch (mSettingsActivityRequestCode) {

                        case 0:
                            mSAccelerometer.getAccelerometerSettings().setAccuracy(settings[1]);
                            break;
                        case 1:
                            mSProximity.getProximitySettings().setAccuracy(settings[1]);
                            break;
                        case 2:
                            mSPhotometer.getPhotometerSettings().setAccuracy(settings[1]);
                        case 3:
                            mSRotation.getmRotationSettings().setAccuracy(settings[1]);
                            break;
                        case 4:
                            mSMagnetometer.getMagnetometerSettings().setAccuracy(settings[1]);
                            break;
                        case 5:
                            mSGyroscope.getGyroscopeSettings().setAccuracy(settings[1]);
                        case 6:
                            mSGps.getGpsSettings().setAccuracy(settings[1]);
                            break;
                    }
                    break;
            }
        }
    }

    protected void onResume() {
        super.onResume();
        mMainLayoutDesign.getReturnHome().setVisibility(View.VISIBLE);
        mMainLayoutDesign.getSensorStart().setVisibility(View.VISIBLE);
        mMainLayoutDesign.getSensorPause().setVisibility(View.VISIBLE);
        Log.d("dataActivity","onResume invoked");
        if (mSAccelerometer != null && mStartSensor) {
            if (mSAccelerometer.getAccelerometerSensor().isPresent()) {
                mAcquisitionRate=mSAccelerometer.getAccelerometerSettings().getAcquisitionRate();
                mAcquisitionAccuracy = mSAccelerometer.getAccelerometerSettings().getAccuracy();
                mSensorManager.registerListener(mSAccelerometer, mSAccelerometer.getAccelerometerSensor().get(),mAcquisitionRate);
                mSettingsActivityRequestCode = mSAccelerometer.getAccelerometerSettings().getSettingsActivityRequestCode();
                mSAccelerometer.setListener(new GSensorListener() {
                    @Override
                    public void perceived(Sensor sensor, double val1, double val2, double val3) {
                        int accuracy=mSAccelerometer.getAccelerometerSettings().getAccuracy();
                        double v1=Math.round(val1*Math.pow(10,(accuracy+1)))/Math.pow(10,accuracy+1);
                        double v2=Math.round(val2*Math.pow(10,(accuracy+1)))/Math.pow(10,accuracy+1);
                        double v3=Math.round(val3*Math.pow(10,(accuracy+1)))/Math.pow(10,accuracy+1);

                        mAcuisitionDisplayArea.getTextValue1().setText("Ax:                "+v1 +"   m/s²");
                        mAcuisitionDisplayArea.getTextValue2().setText("Ay:                "+v2+"   m/s²");
                        mAcuisitionDisplayArea.getTextValue3().setText("Az:                "+v3+"   m/s²");
                        mEnabledSensorInfo=new EnabledSensorInfo(""+sensor.getName(),""+sensor.getVersion(),""+sensor.getPower()+ " mA",
                                ""+sensor.getMaximumRange()+ " mA",""+sensor.getMinDelay()+ " ms",""+sensor.getMaxDelay()+ " ms",
                                ""+sensor.getResolution()+"   m/s²", ""+mAcquisitionRate);
                    }
                });
            }
        }

        if (mSProximity != null && mStartSensor) {
            if (mSProximity.getProximitySensor().isPresent()) {
                mAcquisitionRate=mSProximity.getProximitySettings().getAcquisitionRate();
                mAcquisitionAccuracy = mSProximity.getProximitySettings().getAccuracy();
                mAcuisitionDisplayArea.getTextNameSensor().setText("Proximity sensor");
                mSensorManager.registerListener(mSProximity, mSProximity.getProximitySensor().get(),mAcquisitionRate);
                mSettingsActivityRequestCode = mSProximity.getProximitySettings().getSettingsActivityRequestCode();
                mSProximity.setListener(new GSensorListener() {
                    @Override
                    public void perceived(Sensor sensor,double val1,double val2,double val3) {
                        int accuracy=mSProximity.getProximitySettings().getAccuracy();
                        double v1=Math.round(val1*Math.pow(10,(accuracy+1)))/Math.pow(10,accuracy+1);
                        if (v1==0){
                            mAcuisitionDisplayArea.getTextValue1().setText("Object detected");
                            getWindow().getDecorView().setBackgroundColor(Color.GREEN);
                            mAcuisitionDisplayArea.getTextValue1().setBackgroundColor(Color.GREEN);
                            mMainLayoutDesign.getReturnHome().setBackgroundColor(Color.GREEN);
                            mMainLayoutDesign.getSensorPause().setBackgroundColor(Color.GREEN);
                            mMainLayoutDesign.getSensorStart().setBackgroundColor(Color.GREEN);

                        } else {
                            mAcuisitionDisplayArea.getTextValue1().setText("no object detected");
                            mAcuisitionDisplayArea.getTextValue1().setTextSize(25 );
                            mAcuisitionDisplayArea.getTextValue1().setBackgroundColor(0xffffffff);
                            getWindow().getDecorView().setBackgroundColor(0xffffffff);
                            mMainLayoutDesign.getReturnHome().setBackgroundColor(0xffffffff);
                            mMainLayoutDesign.getSensorPause().setBackgroundColor(0xffffffff);
                            mMainLayoutDesign.getSensorStart().setBackgroundColor(0xffffffff);

                        }

                        mEnabledSensorInfo=new EnabledSensorInfo(""+sensor.getName(),""+sensor.getVersion(),""+sensor.getPower()+ " mA",
                                ""+sensor.getMaximumRange()+ " mA",""+sensor.getMinDelay()+ " ms",""+sensor.getMaxDelay()+ " ms",
                                ""+sensor.getResolution()+"   m/s²", ""+mAcquisitionRate);

                    }
                });
            }
        }

        if (mSPhotometer != null && mStartSensor) {
            if (mSPhotometer.getPhotometerSensor().isPresent()) {
                mAcquisitionRate=mSPhotometer.getPhotometerSettings().getAcquisitionRate();
                mAcquisitionAccuracy = mSPhotometer.getPhotometerSettings().getAccuracy();
                mSensorManager.registerListener(mSPhotometer, mSPhotometer.getPhotometerSensor().get(),mAcquisitionRate);
                mSettingsActivityRequestCode = mSPhotometer.getPhotometerSettings().getSettingsActivityRequestCode();
                mSPhotometer.setListener(new GSensorListener() {
                    @Override
                    public void perceived(Sensor sensor,double val1,double val2,double val3) {
                        int accuracy=mSPhotometer.getPhotometerSettings().getAccuracy();
                        double v1=Math.round(val1*Math.pow(10,(accuracy+1)))/Math.pow(10,accuracy+1);
                        mAcuisitionDisplayArea.getTextValue1().setText("Luminosity                "+v1+" lux");
                        mEnabledSensorInfo=new EnabledSensorInfo(""+sensor.getName(),""+sensor.getVersion(),""+sensor.getPower()+ " mA",
                                ""+sensor.getMaximumRange()+ " mA",""+sensor.getMinDelay()+ " ms",""+sensor.getMaxDelay()+ " ms",
                                ""+sensor.getResolution()+"   m/s²", ""+mAcquisitionRate);
                    }
                });
            }
        }

        if (mSMagnetometer != null && mStartSensor) {
            if (mSMagnetometer.getMagnetometerSensor().isPresent()) {
                mAcquisitionRate=mSMagnetometer.getMagnetometerSettings().getAcquisitionRate();
                mAcquisitionAccuracy = mSMagnetometer.getMagnetometerSettings().getAccuracy();
                mSensorManager.registerListener(mSMagnetometer, mSMagnetometer.getMagnetometerSensor().get(),mAcquisitionRate);
                mSettingsActivityRequestCode = mSMagnetometer.getMagnetometerSettings().getSettingsActivityRequestCode();
                mSMagnetometer.setListener(new GSensorListener() {
                    @Override
                    public void perceived(Sensor sensor,double val1,double val2,double val3) {
                        int accuracy=mSMagnetometer.getMagnetometerSettings().getAccuracy();
                        double v1=Math.round(val1*Math.pow(10,(accuracy+1)))/Math.pow(10,accuracy+1);
                        double v2=Math.round(val2*Math.pow(10,(accuracy+1)))/Math.pow(10,accuracy+1);
                        double v3=Math.round(val3*Math.pow(10,(accuracy+1)))/Math.pow(10,accuracy+1);
                        mAcuisitionDisplayArea.getTextValue1().setText("Mx                "+v1+" nT");
                        mAcuisitionDisplayArea.getTextValue2().setText("My                "+v2+" nT");
                        mAcuisitionDisplayArea.getTextValue3().setText("Mz                "+v3+" nT");
                        mEnabledSensorInfo=new EnabledSensorInfo(""+sensor.getName(),""+sensor.getVersion(),""+sensor.getPower()+ " mA",
                                ""+sensor.getMaximumRange()+ " mA",""+sensor.getMinDelay()+ " ms",""+sensor.getMaxDelay()+ " ms",
                                ""+sensor.getResolution()+"   m/s²", ""+mAcquisitionRate);
                    }
                });
            }
        }

        if (mSRotation != null && mStartSensor) {
            if (mSRotation.getMagnetometerSensor() != null && mSRotation.getAccelerometerSensor() != null) {
                mSettingsActivityRequestCode = mSRotation.getmRotationSettings().getSettingsActivityRequestCode();
                mAcquisitionRate = mSRotation.getmRotationSettings().getAcquisitionRate();
                mAcquisitionAccuracy = mSRotation.getmRotationSettings().getAccuracy();
                mSensorManager.registerListener(mSRotation, mSRotation.getAccelerometerSensor(),mAcquisitionRate);
                mSensorManager.registerListener(mSRotation, mSRotation.getMagnetometerSensor(), mAcquisitionRate);
                mSRotation.setListener(new GSensorListener() {
                    @Override
                    public void perceived(Sensor sensor,double val1,double val2,double val3) {
                        int accuracy=mSRotation.getmRotationSettings().getAccuracy();
                        double v1=Math.round(val1*180/3.14*Math.pow(10,(accuracy+1)))/Math.pow(10,accuracy+1);
                        double v2=Math.round(val2*180/3.14*Math.pow(10,(accuracy+1)))/Math.pow(10,accuracy+1);
                        double v3=Math.round(val3*180/3.14*Math.pow(10,(accuracy+1)))/Math.pow(10,accuracy+1);
                        mAcuisitionDisplayArea.getTextValue1().setText("Yaw                  "+v1+"°");//Yaw
                        mAcuisitionDisplayArea.getTextValue2().setText("Pitch                "+v2+"°");//Pitch
                        mAcuisitionDisplayArea.getTextValue3().setText("Roll                 "+v3+"°");//Roll
                        mEnabledSensorInfo=new EnabledSensorInfo("Inclinometer","Todo",""+0.7+" mA",
                                "Todo","Todo","Todo",
                                "Todo", ""+mAcquisitionRate);
                    }



                });
            }
        }

        if (mSGyroscope != null && mStartSensor) {
            if (mSGyroscope.getGyroscopeSensor().isPresent()) {
                mAcquisitionRate=mSGyroscope.getGyroscopeSettings().getAcquisitionRate();
                mSettingsActivityRequestCode = mSGyroscope.getGyroscopeSettings().getSettingsActivityRequestCode();
                mAcquisitionAccuracy = mSGyroscope.getGyroscopeSettings().getAccuracy();
                mSensorManager.registerListener(mSGyroscope, mSGyroscope.getGyroscopeSensor().get(),mAcquisitionRate);
                mSettingsActivityRequestCode = mSGyroscope.getGyroscopeSettings().getSettingsActivityRequestCode();
                mSGyroscope.setListener(new GSensorListener() {
                    @Override
                    public void perceived(Sensor sensor,double val1,double val2,double val3) {
                        int accuracy=mSGyroscope.getGyroscopeSettings().getAccuracy();
                        double v1=Math.round(val1*Math.pow(10,(accuracy+1)))/Math.pow(10,accuracy+1);
                        double v2=Math.round(val2*Math.pow(10,(accuracy+1)))/Math.pow(10,accuracy+1);
                        double v3=Math.round(val3*Math.pow(10,(accuracy+1)))/Math.pow(10,accuracy+1);
                        mAcuisitionDisplayArea.getTextValue1().setText("Gx                "+v1+" rad/s");
                        mAcuisitionDisplayArea.getTextValue2().setText("Gy                "+v2+" rad/s");
                        mAcuisitionDisplayArea.getTextValue3().setText("Gz                "+v3+" rad/s");
                        mEnabledSensorInfo=new EnabledSensorInfo(""+sensor.getName(),""+sensor.getVersion(),""+sensor.getPower()+ " mA",
                                ""+sensor.getMaximumRange()+ "\n",""+sensor.getMinDelay()+ " ms",""+sensor.getMaxDelay()+ " ms",
                                ""+sensor.getResolution()+"   m/s²", ""+mAcquisitionRate);

                    }
                });
            }
        }

        if (mSGps != null && mStartSensor) {
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

            mAcquisitionRate=mSGps.getGpsSettings().getAcquisitionRate();
            mSettingsActivityRequestCode = mSGps.getGpsSettings().getSettingsActivityRequestCode();
            mAcquisitionAccuracy = mSGps.getGpsSettings().getAccuracy();

            Location location = mLocationManager.getLastKnownLocation("network");
            int accuracy=mSGps.getGpsSettings().getAccuracy();
            double latitude=+Math.round(location.getLatitude()*Math.pow(10,(accuracy)))/Math.pow(10,accuracy);
            double longitude=Math.round(location.getLongitude()*Math.pow(10,(accuracy)))/Math.pow(10,accuracy);
            double altitude=Math.round(location.getAltitude()*Math.pow(10,(accuracy)))/Math.pow(10,accuracy);

            mAcuisitionDisplayArea.getTextValue1().setText(latitude+"°");
            mAcuisitionDisplayArea.getTextValue2().setText(longitude+"°");
            mAcuisitionDisplayArea.getTextValue3().setText(altitude+"°");

        }
    }



    protected void onPause() {
        super.onPause();
        Log.d("dataActivity","onPause invoked");
        if(mSAccelerometer!=null && !mStartSensor) {
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

    protected  void startSensor(){
        mStartSensor=true;
        onResume();
    }

    protected  void stoptSensor(){
        mStartSensor=false;
        onPause();
    }
}