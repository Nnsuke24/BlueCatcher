package com.nnsuke.bluecatcher.ui;

import android.os.Handler;

import com.nnsuke.bluecatcher.domain.Sensor;

import java.util.List;

/**
 * Created by dlv4119 on 2016/05/26.
 */
public class Lister {

    private Handler mHandler = new Handler();

    public void addList(final List<Sensor> sensorList, final ScanListAdapter adapter, final Sensor sensor){
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                sensorList.add(sensor);
                adapter.notifyDataSetChanged();
            }
        });
    }
}
