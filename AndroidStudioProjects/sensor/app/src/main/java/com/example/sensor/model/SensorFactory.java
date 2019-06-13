package com.example.sensor.model;


import java.util.Optional;

public class SensorFactory {

    public GSensor creatSensor(SensorType sensorType,TextArea textArea) {
        GSensor sensor = null;

        switch (sensorType) {
            case ACCELEROMETER_SENSOR:
                sensor = SAccelerometer.getInstance(textArea);
                break;
            case PROXIMITY_SENSOR:
                sensor = SProximity.getInstance(textArea);
                break;
            case PHOTOMETER_SENSOR:
                sensor = SPhotometer.getInstance(textArea);
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