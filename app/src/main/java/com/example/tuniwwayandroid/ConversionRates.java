package com.example.tuniwwayandroid;


import com.google.gson.annotations.SerializedName;

public class ConversionRates {

    @SerializedName("USD")
    private double usd;

    @SerializedName("EUR")
    private double eur;

    @SerializedName("GBP")
    private double gbp;

    public double getUsd() { return usd; }
    public double getEur() { return eur; }
    public double getGbp() { return gbp; }
}
