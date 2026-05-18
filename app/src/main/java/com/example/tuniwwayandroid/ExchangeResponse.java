package com.example.tuniwwayandroid;


import com.google.gson.annotations.SerializedName;

public class ExchangeResponse {

    @SerializedName("result")
    private String result;

    @SerializedName("conversion_rates")
    private ConversionRates conversionRates;

    public String getResult() { return result; }
    public ConversionRates getConversionRates() { return conversionRates; }
}
