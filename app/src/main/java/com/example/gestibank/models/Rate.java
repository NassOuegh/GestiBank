package com.example.gestibank.models;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Rate {

    @SerializedName("base")
    @Expose
    private String base;

    @SerializedName("date")
    @Expose
    private String date;

    @SerializedName("rates")
    @Expose
    private RatesBean rates;

    public List<RateName> getCurrencyList(){
        List<RateName> currencyList=new ArrayList<>();
        currencyList.add(new RateName("CAD",rates.getCAD()));
        currencyList.add(new RateName("AUD", rates.getAUD()));
        currencyList.add(new RateName("BGN", rates.getBGN()));
        currencyList.add(new RateName("BRL", rates.getBRL()));
        currencyList.add(new RateName("CAD", rates.getCAD()));
        currencyList.add(new RateName("CHF", rates.getCHF()));

        currencyList.add(new RateName("CNY", rates.getCNY()));
        currencyList.add(new RateName("CZK", rates.getCZK()));
        currencyList.add(new RateName("DKK", rates.getDKK()));
        currencyList.add(new RateName("GBP", rates.getGBP()));
        currencyList.add(new RateName("HKD", rates.getHKD()));

        currencyList.add(new RateName("HRK", rates.getHRK()));
        currencyList.add(new RateName("HUF", rates.getHUF()));
        currencyList.add(new RateName("IDR", rates.getIDR()));
        currencyList.add(new RateName("ILS", rates.getILS()));
        currencyList.add(new RateName("INR", rates.getINR()));

        currencyList.add(new RateName("JPY", rates.getJPY()));
        currencyList.add(new RateName("KRW", rates.getKRW()));
        currencyList.add(new RateName("MXN", rates.getMXN()));
        currencyList.add(new RateName("MYR", rates.getMYR()));
        currencyList.add(new RateName("NOK", rates.getNOK()));

        currencyList.add(new RateName("NZD", rates.getNZD()));
        currencyList.add(new RateName("PHP", rates.getPHP()));
        currencyList.add(new RateName("PLN", rates.getPLN()));
        currencyList.add(new RateName("RON", rates.getRON()));
        currencyList.add(new RateName("RUB", rates.getRUB()));

        currencyList.add(new RateName("SEK", rates.getSEK()));
        currencyList.add(new RateName("SGD", rates.getSGD()));
        currencyList.add(new RateName("THB", rates.getTHB()));
        currencyList.add(new RateName("TRY", rates.getTRY()));
        currencyList.add(new RateName("USD", rates.getUSD()));

        currencyList.add(new RateName("ZAR", rates.getZAR()));


        return currencyList;
    }

    public static class RatesBean {
        private double CAD;
        private double HKD;
        private double ISK;
        private double PHP;
        private double DKK;
        private double HUF;
        private double CZK;
        private double AUD;
        private double RON;
        private double SEK;
        private double IDR;
        private double INR;
        private double BRL;
        private double RUB;
        private double HRK;
        private double JPY;
        private double THB;
        private double CHF;
        private double SGD;
        private double PLN;
        private double BGN;
        private double TRY;
        private double CNY;
        private double NOK;
        private double NZD;
        private double ZAR;
        private double USD;
        private double MXN;
        private double ILS;
        private double GBP;
        private double KRW;
        private double MYR;

        public double getCAD() {
            return CAD;
        }

        public void setCAD(double CAD) {
            this.CAD = CAD;
        }

        public double getHKD() {
            return HKD;
        }

        public void setHKD(double HKD) {
            this.HKD = HKD;
        }

        public double getISK() {
            return ISK;
        }

        public void setISK(double ISK) {
            this.ISK = ISK;
        }

        public double getPHP() {
            return PHP;
        }

        public void setPHP(double PHP) {
            this.PHP = PHP;
        }

        public double getDKK() {
            return DKK;
        }

        public void setDKK(double DKK) {
            this.DKK = DKK;
        }

        public double getHUF() {
            return HUF;
        }

        public void setHUF(double HUF) {
            this.HUF = HUF;
        }

        public double getCZK() {
            return CZK;
        }

        public void setCZK(double CZK) {
            this.CZK = CZK;
        }

        public double getAUD() {
            return AUD;
        }

        public void setAUD(double AUD) {
            this.AUD = AUD;
        }

        public double getRON() {
            return RON;
        }

        public void setRON(double RON) {
            this.RON = RON;
        }

        public double getSEK() {
            return SEK;
        }

        public void setSEK(double SEK) {
            this.SEK = SEK;
        }

        public double getIDR() {
            return IDR;
        }

        public void setIDR(double IDR) {
            this.IDR = IDR;
        }

        public double getINR() {
            return INR;
        }

        public void setINR(double INR) {
            this.INR = INR;
        }

        public double getBRL() {
            return BRL;
        }

        public void setBRL(double BRL) {
            this.BRL = BRL;
        }

        public double getRUB() {
            return RUB;
        }

        public void setRUB(double RUB) {
            this.RUB = RUB;
        }

        public double getHRK() {
            return HRK;
        }

        public void setHRK(double HRK) {
            this.HRK = HRK;
        }

        public double getJPY() {
            return JPY;
        }

        public void setJPY(double JPY) {
            this.JPY = JPY;
        }

        public double getTHB() {
            return THB;
        }

        public void setTHB(double THB) {
            this.THB = THB;
        }

        public double getCHF() {
            return CHF;
        }

        public void setCHF(double CHF) {
            this.CHF = CHF;
        }

        public double getSGD() {
            return SGD;
        }

        public void setSGD(double SGD) {
            this.SGD = SGD;
        }

        public double getPLN() {
            return PLN;
        }

        public void setPLN(double PLN) {
            this.PLN = PLN;
        }

        public double getBGN() {
            return BGN;
        }

        public void setBGN(double BGN) {
            this.BGN = BGN;
        }

        public double getTRY() {
            return TRY;
        }

        public void setTRY(double TRY) {
            this.TRY = TRY;
        }

        public double getCNY() {
            return CNY;
        }

        public void setCNY(double CNY) {
            this.CNY = CNY;
        }

        public double getNOK() {
            return NOK;
        }

        public void setNOK(double NOK) {
            this.NOK = NOK;
        }

        public double getNZD() {
            return NZD;
        }

        public void setNZD(double NZD) {
            this.NZD = NZD;
        }

        public double getZAR() {
            return ZAR;
        }

        public void setZAR(double ZAR) {
            this.ZAR = ZAR;
        }

        public double getUSD() {
            return USD;
        }

        public void setUSD(double USD) {
            this.USD = USD;
        }

        public double getMXN() {
            return MXN;
        }

        public void setMXN(double MXN) {
            this.MXN = MXN;
        }

        public double getILS() {
            return ILS;
        }

        public void setILS(double ILS) {
            this.ILS = ILS;
        }

        public double getGBP() {
            return GBP;
        }

        public void setGBP(double GBP) {
            this.GBP = GBP;
        }

        public double getKRW() {
            return KRW;
        }

        public void setKRW(double KRW) {
            this.KRW = KRW;
        }

        public double getMYR() {
            return MYR;
        }

        public void setMYR(double MYR) {
            this.MYR = MYR;
        }
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public RatesBean getRates() {
        return rates;
    }

    public void setRates(RatesBean rates) {
        this.rates = rates;
    }
}