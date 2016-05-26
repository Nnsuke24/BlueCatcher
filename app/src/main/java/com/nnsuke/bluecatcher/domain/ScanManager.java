package com.nnsuke.bluecatcher.domain;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.content.Context;

import com.nnsuke.bluecatcher.ui.Lister;
import com.nnsuke.bluecatcher.ui.ScanListAdapter;

import java.util.ArrayList;

/**
 * Created by fukudakosuke on 16/05/26.
 */
public class ScanManager {

    private BluetoothLeScanner bleScanner;

    private ArrayList<Sensor> mSensorList;
    private ScanListAdapter mAdapter;

    private Lister mLister = new Lister();

    private ScanCallback blueScanCallback  = new ScanCallback() {
        @Override
        public void onScanResult(int callbackType, ScanResult result) {
            super.onScanResult(callbackType, result);

            BluetoothDevice bleDevice = result.getDevice();
            String address = bleDevice.getAddress();
            String name = bleDevice.getName();
            int rssi = result.getRssi();

            Sensor sensor = new Sensor(bleDevice, name, address, rssi);

            mLister.addList(mSensorList, mAdapter, sensor);
        }
    };


    public ScanManager(Context context, ArrayList<Sensor> sensorList, ScanListAdapter scanListAdapter){
        BluetoothManager bleManager = (BluetoothManager)context.getSystemService(context.BLUETOOTH_SERVICE);
        BluetoothAdapter bleAdapter = bleManager.getAdapter();
        bleScanner = bleAdapter.getBluetoothLeScanner();

        this.mSensorList = sensorList;
        this.mAdapter = scanListAdapter;
    }




    public void startScan(){
        bleScanner.startScan(blueScanCallback);
    }

    public void stopScan(){
        bleScanner.stopScan(blueScanCallback);
    }
}
