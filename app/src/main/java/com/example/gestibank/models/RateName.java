package com.example.gestibank.models;

public class RateName {
    private String name;
    private double rate;

    public RateName(String name, double rate){
        this.name=name;
        this.rate=rate;
    }

    @Override
    public String toString() {
        return "RateName{" +
                "name='" + name + '\'' +
                ", rate=" + rate +
                '}';
    }

    public String getName() {
        return name;
    }

    public double getRate() {
        return rate;
    }
}
