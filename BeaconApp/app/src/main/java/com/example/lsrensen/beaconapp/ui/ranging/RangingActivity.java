package com.example.lsrensen.beaconapp.ui.ranging;

import java.util.ArrayList;
import java.util.Collection;

import android.app.Activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.widget.EditText;
import android.widget.ListView;

import com.example.lsrensen.beaconapp.R;
import com.google.gson.Gson;

import org.altbeacon.beacon.Beacon;
import org.altbeacon.beacon.BeaconConsumer;
import org.altbeacon.beacon.BeaconManager;
import org.altbeacon.beacon.RangeNotifier;
import org.altbeacon.beacon.Region;
import org.json.JSONObject;

public class RangingActivity extends Activity implements BeaconConsumer {
    protected static final String TAG = "RangingActivity";
    private BeaconManager beaconManager = BeaconManager.getInstanceForApplication(this);
    private ListView listView;
    private BeaconAdapter adapter;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranging);

        beaconManager.bind(this);

        adapter = new BeaconAdapter(this);
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
                Collection<com.example.lsrensen.beaconapp.ui.ranging.Beacon> mappedBeacons = Map(beacons);
                Gson gson = new Gson();
                String json = gson.toJson(mappedBeacons);
                adapter.setDataFromAnyThread(new ArrayList<Beacon>(beacons));
            }
        });

        try {
            beaconManager.startRangingBeaconsInRegion(new Region("myRangingUniqueId", null, null, null));
        } catch (RemoteException e) {
        }
    }

    private Collection<com.example.lsrensen.beaconapp.ui.ranging.Beacon> Map(Collection<Beacon> beacons){
        Collection<com.example.lsrensen.beaconapp.ui.ranging.Beacon> mapped = new ArrayList<com.example.lsrensen.beaconapp.ui.ranging.Beacon>();
        for(final Beacon beacon : beacons){
            mapped.add(new com.example.lsrensen.beaconapp.ui.ranging.Beacon(){{
                id1 = beacon.getId1().toString();
                id2 = beacon.getId2().toString();
                id3 = beacon.getId3().toString();
                range = beacon.getDistance();
            }
            });
        }

        return mapped;
    }
}
