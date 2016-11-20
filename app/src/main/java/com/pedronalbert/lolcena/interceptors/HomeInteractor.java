package com.pedronalbert.lolcena.interceptors;

import android.util.Log;

import com.pedronalbert.lolcena.api.CenaApiService;
import com.pedronalbert.lolcena.api.models.SummonerData;
import com.pedronalbert.lolcena.presenters.HomePresenter;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by pedronalbert on 19/11/16.
 */

public class HomeInteractor {
    HomePresenter presenter;

    public HomeInteractor(HomePresenter presenter) {
        this.presenter = presenter;
    }

    public void searchSummonerByName (String summonerName, final String region) {
        CenaApiService.getService().getSummonerByName(summonerName, region)
                .enqueue(new Callback<SummonerData>() {
                    @Override
                    public void onResponse(Call<SummonerData> call, Response<SummonerData> response) {
                        if (response.code() == 200) {
                            Log.d("request", "user found " + response.body().name);
                            presenter.onSearchSummonerSuccess(response.body());
                        } else if (response.code() == 404 || response.code() == 500) {
                            try {
                                JSONObject jsonObject = new JSONObject(response.errorBody().string());
                                presenter.onSearchFail(jsonObject.getString("message"));
                            } catch (Exception e) {
                                presenter.onSearchFail("Error al obtener los datos");
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<SummonerData> call, Throwable t) {
                        Log.e("ERROR", t.toString());
                        presenter.onSearchFail("Error al conectar con el servidor");
                    }
                });
    }
}
