package com.example.holideys.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HolideyClient {


    public static final String BASE_URL = Constance.HOLIDEY_BASE_URL;
    public static Retrofit retrofit = null;

    public static Retrofit getInstance(){
        if (retrofit == null){
            return retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
