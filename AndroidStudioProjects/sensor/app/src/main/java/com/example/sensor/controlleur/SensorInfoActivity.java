package com.example.sensor.controlleur;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.sensor.R;
import com.example.sensor.view.TechInfoPage;

public class SensorInfoActivity extends AppCompatActivity {
    private WindowManager.LayoutParams mLayoutParams;
    private TechInfoPage mTechInfoPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLayoutParams = getWindow().getAttributes();
        mLayoutParams.x = 0;
        mLayoutParams.y = 50;
        mLayoutParams.height = 650;
        mLayoutParams.width = 1000;
        this.getWindow().setAttributes(mLayoutParams);
        setContentView(R.layout.activity_sensor_info);
        mTechInfoPage = new TechInfoPage();

        //mTechInfoPage.setSensorType((TextView)findViewById(R.id.info_sensor_activity_sensortype_text));
        mTechInfoPage.setSensorName((TextView) findViewById(R.id.info_sensor_activity_name_text));
        mTechInfoPage.setSensorPowerConsumption((TextView) findViewById(R.id.info_sensor_activity_power_text));
        mTechInfoPage.setSensorRange((TextView) findViewById(R.id.info_sensor_activity_maxRange_text));
        mTechInfoPage.setSensorVersion((TextView) findViewById(R.id.info_sensor_activity_version_text));
        mTechInfoPage.setSensorMinDelay((TextView) findViewById(R.id.info_sensor_activity_mindelay_text));
        mTechInfoPage.setSensorMaxDelay((TextView) findViewById(R.id.info_sensor_activity_maxdelay_text));
        mTechInfoPage.setSensorResolution((TextView) findViewById(R.id.info_sensor_activity_resolution_text));
        mTechInfoPage.setCloseButton((ImageView) findViewById(R.id.info_sensor_activity_close_button));

        Intent intent = getIntent();
        String[] mEnabedSensorInfo = intent.getStringArrayExtra("enabled sensor info");
        //mTechInfoPage.getSensorType().setText(mEnabedSensorInfo[0]);
        mTechInfoPage.getSensorName().setText(mEnabedSensorInfo[1]);
        mTechInfoPage.getSensorVersion().setText(mEnabedSensorInfo[2]);
        mTechInfoPage.getSensorPowerConsumption().setText(mEnabedSensorInfo[3]);
        mTechInfoPage.getSensorRange().setText(mEnabedSensorInfo[4]);
        mTechInfoPage.getSensorMinDelay().setText(mEnabedSensorInfo[5]);
        mTechInfoPage.getSensorMaxDelay().setText(mEnabedSensorInfo[6]);
        mTechInfoPage.getSensorResolution().setText(mEnabedSensorInfo[7]);
        mTechInfoPage.getCloseButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}