package com.example.lsrensen.beaconapp.rest.models;

public class CarDto {
    private String image;
    private String make;
    private String model;
    private String price;

    public CarDto(){
    }

    public CarDto(String image, String make, String model, String price) {
        this.image = image;
        this.make = make;
        this.model = model;
        this.price = price;
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
}
