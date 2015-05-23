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
import com.example.lsrensen.beaconapp.rest.models.BeaconDto;
import com.example.lsrensen.beaconapp.rest.models.CarDto;
import com.example.lsrensen.beaconapp.ui.helpers.DownloadImageTask;

import java.util.ArrayList;

public class CarDtoAdapter extends BaseAdapter
{
    final Handler mHandler = new Handler();
    ArrayList<CarDto> items = new ArrayList<CarDto>();
    private Context context;

    public CarDtoAdapter(Context context) {
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
        View rowView = inflater.inflate(R.layout.listitem_cardto, parent, false);
        TextView makeAndModelLine = (TextView) rowView.findViewById(R.id.makeAndModel);
        TextView priceLine = (TextView) rowView.findViewById(R.id.price);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.carImage);

        CarDto car = (CarDto)getItem(position);
        makeAndModelLine.setText("" + car.getMake() + " " + car.getModel());
        priceLine.setText(car.getPrice());

        new DownloadImageTask(imageView).execute(car.getImage());

        return rowView;
    }

    public void setDataFromAnyThread(final ArrayList<CarDto> cars) {
        // Enqueue work on mHandler to change the data on
        // the main thread.
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                items = cars;
                notifyDataSetChanged();
            }
        });
    }
}
