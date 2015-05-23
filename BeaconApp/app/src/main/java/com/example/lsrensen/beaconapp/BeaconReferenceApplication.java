package com.example.lsrensen.beaconapp;

import android.app.Application;
import android.util.Log;

import org.altbeacon.beacon.BeaconManager;
import org.altbeacon.beacon.BeaconParser;
import org.altbeacon.beacon.powersave.BackgroundPowerSaver;
import org.altbeacon.beacon.startup.RegionBootstrap;

public class BeaconReferenceApplication extends Application {
    private static final String TAG = "AndroidProximityReferenceApplication";
    private RegionBootstrap regionBootstrap;
    private BackgroundPowerSaver backgroundPowerSaver;
    private boolean haveDetectedBeaconsSinceBoot = false;


    public void onCreate() {
        super.onCreate();
        BeaconManager beaconManager = BeaconManager.getInstanceForApplication(this);
        beaconManager.getBeaconParsers().add(new BeaconParser().setBeaconLayout("m:2-3=0215,i:4-19,i:20-21,i:22-23,p:24-24,d:25-25"));

        Log.d(TAG, "setting up background monitoring for beacons and power saving");
    }
}