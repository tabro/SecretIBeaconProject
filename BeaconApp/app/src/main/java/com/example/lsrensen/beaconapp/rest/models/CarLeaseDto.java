package com.example.lsrensen.beaconapp.rest.models;

/**
 * Created by mathi on 24-05-2015.
 */
public class CarLeaseDto {
    private int monthlyPayment;
    private int downPayment;
    private int period;

    public int getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(int monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public int getDownPayment() {
        return downPayment;
    }

    public void setDownPayment(int downPayment) {
        this.downPayment = downPayment;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }
}
