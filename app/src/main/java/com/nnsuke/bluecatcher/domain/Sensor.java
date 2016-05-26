package com.nnsuke.bluecatcher.domain;

import android.bluetooth.BluetoothDevice;

/**
 * Created by fukudakosuke on 16/05/26.
 */
public class Sensor {

    int id;
    BluetoothDevice bleDevice;
    String name;
    String address;
    int rssi;

    public Sensor(BluetoothDevice bluetoothDevice, String name, String address, int rssi) {
        this.bleDevice = bluetoothDevice;
        this.name = name;
        this.address = address;
        this.rssi = rssi;
    }

    public int getId() {
        return id;
    }

    public BluetoothDevice getBleDevice() {
        return bleDevice;
    }

    public int getRssi() {
        return rssi;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

}
