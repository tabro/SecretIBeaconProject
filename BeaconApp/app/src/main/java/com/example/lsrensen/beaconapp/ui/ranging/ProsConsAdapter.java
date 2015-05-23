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
import com.example.lsrensen.beaconapp.ui.helpers.DownloadImageTask;

import java.util.ArrayList;

public class ProsConsAdapter extends BaseAdapter
{
    final Handler mHandler = new Handler();
    ArrayList<String> items = new ArrayList<String>();
    private Context context;
    private boolean isPros;

    public ProsConsAdapter(Context context, boolean isPros) {
        this.context = context;
        this.isPros = isPros;
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

        String desciption = (String)getItem(position);
        description.setText(desciption);

        if(isPros)
            imageView.setImageResource(R.drawable.ok);
        else
            imageView.setImageResource(R.drawable.notok);

        return rowView;
    }

    public void setDataFromAnyThread(final ArrayList<String> prosOrCons) {
        // Enqueue work on mHandler to change the data on
        // the main thread.
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                if(prosOrCons != null)
                    items = prosOrCons;
                notifyDataSetChanged();
            }
        });
    }
}
