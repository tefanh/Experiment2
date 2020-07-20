package com.example.experiment2.config;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RequestBuilder {
    private static Retrofit retrofit = null;
    public static Retrofit getRetrofit() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(URL.BASE_URL + "api/").addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
