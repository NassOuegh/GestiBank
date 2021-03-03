package com.example.gestibank.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.json.JSONObject;

import java.util.List;

public class Rate {

    @SerializedName("USD")
    @Expose
    private Double USD;

    @SerializedName("CAD")
    @Expose
    private Double CAD;

    @SerializedName("HKD")
    @Expose
    private Double HKD;

    public Rate() {
    }

    public Rate(Double USD, Double CAD, Double HKD) {
        this.USD=USD;
        this.CAD=CAD;
        this.HKD=HKD;
    }

    public Double getUSD() {
        return USD;
    }

    public void setUSD(Double USD) {
        this.USD = USD;
    }

    public Double getCAD() {
        return CAD;
    }

    public void setCAD(Double CAD) {
        this.CAD = CAD;
    }

    public Double getHKD() {
        return HKD;
    }

    public void setHKD(Double HKD) {
        this.HKD = HKD;
    }
}