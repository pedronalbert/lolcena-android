package com.pedronalbert.lolcena.api;

import com.pedronalbert.lolcena.api.models.SummonerData;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by pedronalbert on 17/11/16.
 */

public interface CenaApiEndpoint {
    @GET("riot-api/summoner/by-name/{summonerName}")
    Call<SummonerData> getSummonerByName(@Path("summonerName") String summonerName, @Query("region") String region);
}
