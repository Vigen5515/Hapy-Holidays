package com.example.holideys.network;

import com.example.holideys.network.holidey.HolyBaseResponce;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface API {





                              @GET("holidays")
    Call<HolyBaseResponce> getHolidey(@Query("key") String key, @Query("country") String country,
                                      @Query("year") String year,
                                      @Query("month") String mpunth,
                                      @Query("day") String day);


}
