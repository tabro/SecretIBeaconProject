package com.example.lsrensen.beaconapp.rest.models;

/**
 * Created by mlorenzen on 23-05-2015.
 */
public class Car {
    private String fuelType;
    private String kml;
    private String financeOffer;

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getKml() {
        return kml;
    }

    public void setKml(String kml) {
        this.kml = kml;
    }

    public String getFinanceOffer() {
        return financeOffer;
    }

    public void setFinanceOffer(String financeOffer) {
        this.financeOffer = financeOffer;
    }
}
