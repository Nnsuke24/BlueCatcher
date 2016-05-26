package com.nnsuke.bluecatcher.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.ToggleButton;

import com.nnsuke.bluecatcher.R;
import com.nnsuke.bluecatcher.domain.ListListener;
import com.nnsuke.bluecatcher.domain.ScanManager;
import com.nnsuke.bluecatcher.domain.Sensor;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();

    private ScanManager mScanManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ListView sensorListView = (ListView)findViewById(R.id.sensor_list_view);

        final ArrayList<Sensor> mSensorList = new ArrayList<Sensor>();
        final ScanListAdapter adapter = new ScanListAdapter(MainActivity.this);
        adapter.setSensorList(mSensorList);
        sensorListView.setAdapter(adapter);

        onChangeScanToggle();

        if (mScanManager == null) {
            mScanManager = new ScanManager(MainActivity.this, new ListListener() {
                @Override
                public void onAddSensor(Sensor sensor) {
                    mSensorList.add(sensor);
                    adapter.notifyDataSetChanged();
                }
            });
        }

    }

    public void onChangeScanToggle(){
        ToggleButton scan_toggle = (ToggleButton)findViewById(R.id.scan_toggle);
        scan_toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // OFF→ON

                    mScanManager.startScan();
                    Log.d(TAG, "スタート");


                } else {
                    // ON→OFF

                    mScanManager.stopScan();
                    Log.d(TAG, "ストップ");

                }
            }
        });

    }
}
