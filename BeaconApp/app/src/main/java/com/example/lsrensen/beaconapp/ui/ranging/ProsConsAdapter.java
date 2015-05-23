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
import com.example.lsrensen.beaconapp.rest.models.CarDto;
import com.example.lsrensen.beaconapp.rest.models.ProsConsDto;
import com.example.lsrensen.beaconapp.ui.helpers.DownloadImageTask;

import java.util.ArrayList;

public class ProsConsAdapter extends BaseAdapter
{
    final Handler mHandler = new Handler();
    ArrayList<ProsConsDto> items = new ArrayList<ProsConsDto>();
    private Context context;

    public ProsConsAdapter(Context context) {
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
        View rowView = inflater.inflate(R.layout.listitem_proscons, parent, false);
        TextView description = (TextView) rowView.findViewById(R.id.description);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.statusImage);

        ProsConsDto prosCons = (ProsConsDto)getItem(position);
        description.setText(prosCons.getDescription());

        if(prosCons.isPros())
            imageView.setImageResource(R.drawable.ok);
        else
            imageView.setImageResource(R.drawable.notok);

        return rowView;
    }

    public void setDataFromAnyThread(final ArrayList<String> pros, final ArrayList<String> cons) {
        final ArrayList<ProsConsDto> newItems = new ArrayList<>();

        for(String pro : pros){
            ProsConsDto prosDto = new ProsConsDto(pro, true);
            newItems.add(prosDto);
        }

        for(String con : cons){
            ProsConsDto consDto = new ProsConsDto(con, false);
            newItems.add(consDto);
        }

        mHandler.post(new Runnable() {
            @Override
            public void run() {
                items = newItems;
                notifyDataSetChanged();
            }
        });
    }
}
