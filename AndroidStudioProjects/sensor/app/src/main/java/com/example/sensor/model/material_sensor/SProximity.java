package com.example.sensor.model.material_sensor;



import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorManager;

import com.example.sensor.model.GSensor;
import com.example.sensor.model.SensorCategory;
import com.example.sensor.model.SensorType;
import com.example.sensor.model.TextArea;

import java.util.Optional;


public class SProximity extends GSensor {
    private static final SensorType mSENSOR_TYPE=SensorType.PROXIMITY_SENSOR;
    private static SensorCategory sSensorCategory = SensorCategory.MATERIAL;
    private Optional<Sensor> mProximitySensor=Optional.empty();
    private static Optional<SProximity> instance =Optional.empty();

    public SProximity(TextArea textArea) {
        super(textArea);
    }

    public static SProximity getInstance(PackageManager packageManager,TextArea textArea){
        if (!instance.isPresent()) {
            if (packageManager.hasSystemFeature(PackageManager.FEATURE_SENSOR_PROXIMITY)){          //check whether the device is equipped with an Proximity
                instance=Optional.ofNullable(new SProximity(textArea));
            }
        }
        return instance.get();
    }

    public Optional<Sensor> getProximitySensor() {
        return mProximitySensor;
    }

    public void setADefaultProximitySensor(SensorManager sensorManager) {
        if(instance.isPresent()){
            mProximitySensor=Optional.ofNullable(sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY));
        }
    }
}