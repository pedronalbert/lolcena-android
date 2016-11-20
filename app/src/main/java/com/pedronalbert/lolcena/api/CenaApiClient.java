package com.pedronalbert.lolcena.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by pedronalbert on 17/11/16.
 */

public class CenaApiClient {
    public static Retrofit client;
    public static final String BASE_URL = "http://192.168.0.2:1337";

    public static Retrofit getClient () {
        if (client != null) {
            return client;
        } else {
            client = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(JacksonConverterFactory.create())
                    .build();

            return client;
        }
    }
}
