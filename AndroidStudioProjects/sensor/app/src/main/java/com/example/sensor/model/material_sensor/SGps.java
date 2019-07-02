package com.example.sensor.model.material_sensor;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.widget.TextView;

import com.example.sensor.controlleur.HomeActivity;
import com.example.sensor.model.TextArea;

public class SGps implements LocationListener {
    private LocationProvider mLocationProvider;
    private LocationManager mLocationManager;
    private TextArea mAcuisitionDisplayArea;

    public SGps(LocationManager locationManager, TextArea textArea) {
        mLocationManager = locationManager;
        mAcuisitionDisplayArea = textArea;
        mLocationProvider = mLocationManager.getProvider(locationManager.NETWORK_PROVIDER);
        /*if (ActivityCompat.checkSelfPermission(HomeActivity.getContext(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            System.out.println("Provider name   " + mLocationProvider.getName() + "required power   " + mLocationProvider.getPowerRequirement() + "\n" + mLocationManager.getLastKnownLocation("network").getLatitude());
            return;
        }*/
    }


    @Override
    public void onLocationChanged(Location location) {
        if (ActivityCompat.checkSelfPermission(HomeActivity.getContext(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            mAcuisitionDisplayArea.getTextValue1().setText("" + (double) Math.round(location.getAltitude()* 100000000) / 100000000 + "°");
            mAcuisitionDisplayArea.getTextValue2().setText(""+(double)Math.round(location.getLongitude()* 100000000) / 100000000+"°");
            mAcuisitionDisplayArea.getTextValue3().setText(""+(double)Math.round(location.getAltitude()* 100) / 100+" (m)");

        }

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        System.out.println("status"+status);

    }

    @Override
    public void onProviderEnabled(String provider) {
        System.out.println("provider"+provider);

    }

    @Override
    public void onProviderDisabled(String provider) {
        System.out.println("provider"+provider);
    }
}
