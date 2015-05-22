package com.example.lsrensen.beaconapp.ui.ranging;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lsrensen.beaconapp.R;

import org.altbeacon.beacon.Beacon;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class BeaconAdapter extends BaseAdapter
{
    final Handler mHandler = new Handler();
    ArrayList<BeaconRowItem> items = new ArrayList<BeaconRowItem>();
    private Context context;

    public BeaconAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.listitem_beacon, parent, false);
        TextView firstLine = (TextView) rowView.findViewById(R.id.firstLine);
        TextView secondLine = (TextView) rowView.findViewById(R.id.secondLine);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);

        BeaconRowItem beacon = (BeaconRowItem)getItem(position);
        firstLine.setText("Id1: " + beacon.id.toString());
        if(beacon.range != null){
            secondLine.setText("Range: " + new DecimalFormat("#.00").format(beacon.range));
        }
        else{
            secondLine.setText("Range: N/A");
        }
        // change the icon for Windows and iPhone
        boolean isReachable = beacon.isReachable;
        if (isReachable) {
            imageView.setImageResource(R.drawable.ok);
        } else {
            imageView.setImageResource(R.drawable.notok);
        }

        return rowView;
    }

    public void setDataFromAnyThread(final ArrayList<Beacon> beacons) {
        // Enqueue work on mHandler to change the data on
        // the main thread.
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                for(BeaconRowItem beacon : items){
                    beacon.isReachable = false;
                    beacon.range = null;
                }

                for(final Beacon beacon : beacons){
                    boolean foundRowItem = false;
                    for (BeaconRowItem beaconRowItem : items){
                        if(beaconRowItem.id.equals(beacon.toString())){
                            beaconRowItem.isReachable = true;
                            beaconRowItem.range = beacon.getDistance();
                            foundRowItem = true;
                        }
                    }

                    if(!foundRowItem){
                        items.add(new BeaconRowItem(){{
                            isReachable = true;
                            id = beacon.toString();
                            range = beacon.getDistance();
                        }});
                    }
                }

                notifyDataSetChanged();
            }
        });
    }
}
