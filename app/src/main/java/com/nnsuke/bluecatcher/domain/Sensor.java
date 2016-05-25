package com.nnsuke.bluecatcher.domain;

/**
 * Created by fukudakosuke on 16/05/26.
 */
public class Sensor {

    private String name;
    private String address;

    public int getRssi() {
        return rssi;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    private int rssi;


}
