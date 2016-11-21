package com.pedronalbert.lolcena.interceptors;

import android.content.Context;
import android.util.Log;

import com.pedronalbert.lolcena.R;
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
    Context ctx;

    public HomeInteractor(Context ctx, HomePresenter presenter) {
        this.presenter = presenter;
        this.ctx = ctx;
    }

    public void searchSummonerByName (String summonerName, final String region) {
        CenaApiService.getService().getSummonerByName(summonerName, region)
            .enqueue(new Callback<SummonerData>() {
                @Override
                public void onResponse(Call<SummonerData> call, Response<SummonerData> response) {
                    if (response.code() == 200) {
                        presenter.onSearchSummonerSuccess(response.body());
                    } else if (response.code() == 404 || response.code() == 500) {
                        //Parse error body
                        try {
                            JSONObject jsonObject = new JSONObject(response.errorBody().string());

                            presenter.onSearchFail(jsonObject.getString("message"));
                        } catch (Exception e) {
                            String errorMessage = ctx.getString(R.string.error_server_connection);

                            presenter.onSearchFail(errorMessage);
                        }
                    }
                }

                @Override
                public void onFailure(Call<SummonerData> call, Throwable t) {
                    Log.e("RETROFIT", t.toString());

                    String errorMessage = ctx.getString(R.string.error_server_connection);

                    presenter.onSearchFail(errorMessage);
                }
            });
    }
}
