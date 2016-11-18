package com.pedronalbert.lolcena.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by pedronalbert on 17/11/16.
 */

public class CenaApiClient {
    public static Retrofit client;
    public static final String BASE_URL = "http://127.0.0.1:1337";

    public static Retrofit getClient () {
        if (client != null) {
            return client;
        } else {
            client = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            return client;
        }
    }
}
