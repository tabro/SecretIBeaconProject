package com.example.lsrensen.beaconapp.rest.models;

/**
 * Created by mlorenzen on 22-05-2015.
 */
public class BeaconRecord {
    private String id1;

    private int id2;
    private int id3;

    public BeaconRecord() {

    }

    public BeaconRecord(String id1, int id2, int id3) {
        this.id1 = id1;
        this.id2 = id2;
        this.id3 = id3;
    }

    public int getId2() {
        return id2;
    }

    public void setId2(int id2) {
        this.id2 = id2;
    }

    public int getId3() {
        return id3;
    }

    public void setId3(int id3) {
        this.id3 = id3;
    }

    public String getId1() {
        return id1;
    }

    public void setId1(String id1) {
        this.id1 = id1;
    }
}
