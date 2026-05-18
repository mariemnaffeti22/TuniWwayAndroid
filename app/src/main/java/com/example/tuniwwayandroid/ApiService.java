package com.example.tuniwwayandroid;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {

    @GET("v6/{apiKey}/latest/TND")
    Call<ExchangeResponse> getConversionRates(
            @Path("apiKey") String apiKey
    );
}
