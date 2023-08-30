package com.example.javafinal.apiinterface;

import com.example.javafinal.Pojo.EventDemo;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EventInterface {

    @GET("entries")
    Call<EventDemo> getData();
}
