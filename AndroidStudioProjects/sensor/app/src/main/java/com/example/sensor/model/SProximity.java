package com.example.sensor.model;



import android.hardware.Sensor;
import android.hardware.SensorManager;
import java.util.Optional;


public class SProximity extends GSensor {
    private static final SensorType mSENSOR_TYPE=SensorType.PROXIMITY_SENSOR;
    private Optional<Sensor> mProximitySensor=Optional.empty();
    private static Optional<SProximity> instance =Optional.empty();

    public SProximity(TextArea textArea) {
        super(textArea);
    }

    public static SProximity getInstance(TextArea textArea){
        if (!instance.isPresent())
        {   instance=Optional.ofNullable(new SProximity(textArea));
        }
        return instance.get();
    }

    public Optional<Sensor> getProximitySensor() {
        return mProximitySensor;
    }

    public void setADefaultProximitySensor(SensorManager sensorManager) {
        mProximitySensor=Optional.ofNullable(sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY));
    }
}