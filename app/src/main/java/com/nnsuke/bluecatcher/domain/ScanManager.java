package com.nnsuke.bluecatcher.domain;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.content.Context;

/**
 * Created by fukudakosuke on 16/05/26.
 */
public class ScanManager {

    private BluetoothLeScanner bleScanner;

    private ListListener ml;

    private ScanCallback blueScanCallback  = new ScanCallback() {
        @Override
        public void onScanResult(int callbackType, ScanResult result) {
            super.onScanResult(callbackType, result);

            BluetoothDevice bleDevice = result.getDevice();
            String address = bleDevice.getAddress();
            String name = bleDevice.getName();
            int rssi = result.getRssi();

            Sensor sensor = new Sensor(bleDevice, name, address, rssi);

            ml.onAddSensor(sensor);
        }
    };


    public ScanManager(Context context, ListListener ml){
        BluetoothManager bleManager = (BluetoothManager)context.getSystemService(context.BLUETOOTH_SERVICE);
        BluetoothAdapter bleAdapter = bleManager.getAdapter();
        bleScanner = bleAdapter.getBluetoothLeScanner();
        this.ml = ml;
    }


    /**
     * スキャンを開始する
     */
    public void startScan(){
        bleScanner.startScan(blueScanCallback);
    }

    /**
     * スキャンを停止する
     */
    public void stopScan(){
        bleScanner.stopScan(blueScanCallback);
    }
}
