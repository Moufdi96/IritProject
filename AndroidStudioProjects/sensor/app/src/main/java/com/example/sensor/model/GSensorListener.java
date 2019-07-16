package com.example.sensor.model;

import android.hardware.Sensor;

public interface GSensorListener {
    void perceived(Sensor sensor,double val, double val2, double val3);
}
