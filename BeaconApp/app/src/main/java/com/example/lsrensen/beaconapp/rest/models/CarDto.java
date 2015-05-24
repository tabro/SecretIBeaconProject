package com.example.lsrensen.beaconapp.rest.models;

import java.util.ArrayList;

public class CarDto {
    private String image;
    private String make;
    private String model;
    private String price;
    private BeaconDto beacon;
    private ArrayList<String> cons;
    private ArrayList<String> pros;
    private CarFinanceDto carFinance;
    private CarLeaseDto carLease;

    public CarDto(){
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public BeaconDto getBeacon() {
        return beacon;
    }

    public void setBeacon(BeaconDto beaconDto) {
        this.beacon = beaconDto;
    }

    public ArrayList<String> getCons() {
        return cons;
    }

    public void setCons(ArrayList<String> cons) {
        this.cons = cons;
    }

    public ArrayList<String> getPros() {
        return pros;
    }

    public void setPros(ArrayList<String> pros) {
        this.pros = pros;
    }

    public CarFinanceDto getCarFinance() {
        return carFinance;
    }

    public void setCarFinance(CarFinanceDto carFinance) {
        this.carFinance = carFinance;
    }

    public CarLeaseDto getCarLease() {
        return carLease;
    }

    public void setCarLease(CarLeaseDto carLease) {
        this.carLease = carLease;
    }
}
