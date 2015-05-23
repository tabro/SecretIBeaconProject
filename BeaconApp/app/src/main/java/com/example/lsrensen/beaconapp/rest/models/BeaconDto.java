package com.example.lsrensen.beaconapp.rest.models;

/**
 * Created by mlorenzen on 22-05-2015.
 */
public class BeaconDto {
    private String id1;

    private int id2;
    private int id3;

    public BeaconDto() {

    }

    public BeaconDto(String id1, int id2, int id3) {
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

    @Override
    public boolean equals(Object o) {
        if(o == null) return false;
        if(!(o instanceof BeaconDto)) return false;

        BeaconDto other = (BeaconDto)o;
        return id1 != null && id1.equals(other.id1) && id2 == other.id2 && id3 == other.id3;
    }
}
