package com.nnsuke.bluecatcher.domain;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.BluetoothLeAdvertiser;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.content.Context;

/**
 * Created by fukudakosuke on 16/05/26.
 */
public class ScanManager {

    private BluetoothManager bleManager;
    private BluetoothAdapter bleAdapter;
    private BluetoothLeScanner bleScanner;

    private ScanCallback blueScanCallback  = new ScanCallback() {
        @Override
        public void onScanResult(int callbackType, ScanResult result) {
            super.onScanResult(callbackType, result);

            BluetoothDevice bleDevice = result.getDevice();
            String address = bleDevice.getAddress();
            String name = bleDevice.getName();
            int rssi = result.getRssi();
        }
    };


    public ScanManager(Context context){
        bleManager = (BluetoothManager)context.getSystemService(context.BLUETOOTH_SERVICE);
        bleAdapter = bleManager.getAdapter();
        bleScanner = bleAdapter.getBluetoothLeScanner();
    }




    public void startScan(){
        bleScanner.startScan(blueScanCallback);
    }

    public void stopScan(){
        bleScanner.stopScan(blueScanCallback);
    }
}
