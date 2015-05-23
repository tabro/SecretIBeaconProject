package com.example.lsrensen.beaconapp.ui.ranging;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;

import android.app.Activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.widget.ListView;

import com.example.lsrensen.beaconapp.R;
import com.example.lsrensen.beaconapp.rest.HttpHelper;
import com.example.lsrensen.beaconapp.rest.models.BeaconDto;
import com.example.lsrensen.beaconapp.rest.models.CarDto;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.altbeacon.beacon.Beacon;
import org.altbeacon.beacon.BeaconConsumer;
import org.altbeacon.beacon.BeaconManager;
import org.altbeacon.beacon.RangeNotifier;
import org.altbeacon.beacon.Region;

public class RangingActivity extends Activity implements BeaconConsumer {
    protected static final String TAG = "RangingActivity";
    private BeaconManager beaconManager = BeaconManager.getInstanceForApplication(this);
    private ListView listView;
    private CarDtoAdapter adapter;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranging);

        beaconManager.setForegroundBetweenScanPeriod(5000);
        beaconManager.bind(this);

        adapter = new CarDtoAdapter(this);
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
        handler = new Handler();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        beaconManager.unbind(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (beaconManager.isBound(this)) beaconManager.setBackgroundMode(true);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (beaconManager.isBound(this)) beaconManager.setBackgroundMode(false);
    }

    @Override
    public void onBeaconServiceConnect() {
        beaconManager.setRangeNotifier(new RangeNotifier() {
            @Override
            public void didRangeBeaconsInRegion(Collection<Beacon> beacons, Region region) {
                try {
                    Collection<BeaconDto> mappedBeacons = Map(beacons);
                    Gson gson = new Gson();
                    String json = gson.toJson(mappedBeacons);
                    String carsJson = HttpHelper.post("http://ibeaconisdabomb.azurewebsites.net/Beacon", json);

                    Type listType = new TypeToken<ArrayList<CarDto>>(){}.getType();

                    ArrayList<CarDto> cars = gson.fromJson(carsJson, listType);

                    adapter.setDataFromAnyThread(cars);
                } catch (
                        IOException e
                        ) {
                    e.printStackTrace();
                }
            }
        });

        try {
            beaconManager.startRangingBeaconsInRegion(new Region("myRangingUniqueId", null, null, null));
        } catch (RemoteException e) {
        }
    }

    private Collection<BeaconDto> Map(Collection<Beacon> beacons) {
        Collection<BeaconDto> mapped = new ArrayList<BeaconDto>();
        for (final Beacon beacon : beacons) {
            BeaconDto mappedBeacon = new BeaconDto();
            mappedBeacon.setId1(beacon.getId1().toString());
            mappedBeacon.setId2(beacon.getId2().toInt());
            mappedBeacon.setId3(beacon.getId3().toInt());

            mapped.add(mappedBeacon);
        }

        return mapped;
    }
}
