package com.example.sensor.model;


import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.example.sensor.GSensorListener;
import java.util.Optional;

/**
 * GSensor for "generic sensor" is the mother class of all material sensors classes
 * it gathers the main and common attributes and methods that have to be included in each material (physical) sensor class,
 * therefor each of these classes (with the SensorCategory enum = MATERIAL) must extend it.
 * it implements the SensorEventListener interface,thus it allows receiving new notification from SensorManager when there's new sensor data
 *
 * @author
 */
public class GSensor implements SensorEventListener {
    private Sensor  sensor;
    private static float sensorPoweronsumption;
    private static float maxRange;
    private Optional<GSensorListener> listener;

    public void setListener(GSensorListener listener) {
        this.listener = Optional.of(listener);
    }


    /* this method is called when a new sensor event is detected by the sensor event listener
     it reads the sensor type that has transmitted the measured data and perform the suitable action to that type
     for example if the sensor type was an accelerometer it displays the results in a 3D form (s,y,z)
     if sensor was a photometer or a proximity sensor it displays only one value  */

    @Override
    public void onSensorChanged(SensorEvent event) {
        sensor=event.sensor;
        if(listener.isPresent()){
            listener.get().perceived(event.values[0],event.values[1],event.values[2]);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    public static float getSensorPoweronsumption() {
        return sensorPoweronsumption;
    }

    public static void setSensorPoweronsumption(float sensorPoweronsumption) {
        GSensor.sensorPoweronsumption = sensorPoweronsumption;
    }

    public static float getMaxRange() {
        return maxRange;
    }

    public static void setMaxRange(float maxRange) {
        GSensor.maxRange = maxRange;
    }
}
