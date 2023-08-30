package com.example.javafinal.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.converter.gson.GsonConverterFactory;

public class EventRetrofit {

    public static String baseUrl = "https://api.publicapis.org/";

    static Gson gson = new GsonBuilder()
            .setLenient()
            .create();

    private static retrofit2.Retrofit retrofit;
    public static retrofit2.Retrofit getRetrofit()
    {
        if (retrofit == null){
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit;
    }
}
