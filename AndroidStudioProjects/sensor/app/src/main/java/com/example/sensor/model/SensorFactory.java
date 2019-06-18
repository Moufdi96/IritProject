package com.example.sensor.model;


import com.example.sensor.model.material_sensor.SAccelerometer;
import com.example.sensor.model.material_sensor.SMagnetometer;
import com.example.sensor.model.material_sensor.SPhotometer;
import com.example.sensor.model.material_sensor.SProximity;

public class SensorFactory {

    public GSensor creatSensor(SensorType sensorType,TextArea textArea) {
        GSensor sensor=null,sensor2 = null;

        switch (sensorType) {
            case ACCELEROMETER_SENSOR:
                sensor = SAccelerometer.getInstance(textArea);
                sensor2=SAccelerometer.getInstance(textArea);
                break;
            case MAGNETOMETER_SENSOR:
                sensor = SMagnetometer.getInstance(textArea);
                break;
            case ROTATION_SENSOR:
                //sensor = SRotation.getInstance(textArea);
                break;
            case PROXIMITY_SENSOR:
                sensor = SProximity.getInstance(textArea);
                break;
            case PHOTOMETER_SENSOR:
                sensor = SPhotometer.getInstance(textArea);
                break;
            case GYROSCOPE_SENSOR:
                sensor=SGyroscope.getInstance(textArea);
                break;
        }
        return sensor;
    }
}


    /*public static Optional<SProximity> getProximitySensor(SensorManager sensorManager, final TextView value1, final TextView value2) {
        Optional<Sensor> theSensor = Optional.ofNullable(sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY));

        /*if (theSensor.isPresent()) {
            return Optional.of(new SProximity(theSensor.get(), value1, value2));
        }

        return Optional.empty();
    }

    public static Optional<GSensor> getTemperatureSensor(SensorManager sensorManager, final TextView value1, final TextView value2) {

        //je demande au portable s'il y a un capteur de temperature

        //on a un capteur? bon
        // -> je renvoie une boite avec ce capteur
        //sinon
        // -> je cree un capteur virtuel


        return Optional.empty();
    }
}*/