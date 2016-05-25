package com.nnsuke.bluecatcher.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.nnsuke.bluecatcher.R;
import com.nnsuke.bluecatcher.domain.Sensor;

import java.util.List;

/**
 * Created by fukudakosuke on 16/05/26.
 */
public class ScanListAdapter extends BaseAdapter {

    LayoutInflater layoutInflater = null;
    List<Sensor> sensorList;

    public ScanListAdapter(Context context) {
        this.layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.row_sensor, parent, false);
        }

        ((TextView)convertView.findViewById(R.id.name)).setText(sensorList.get(position).getName());
        ((TextView)convertView.findViewById(R.id.address)).setText(sensorList.get(position).getAddress());
        ((TextView)convertView.findViewById(R.id.rssi)).setText(sensorList.get(position).getRssi());
        return null;
    }
}
