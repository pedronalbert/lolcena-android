package com.pedronalbert.lolcena.presenters;

import android.util.Log;

import com.pedronalbert.lolcena.activities.HomeActivity;
import com.pedronalbert.lolcena.api.models.SummonerData;
import com.pedronalbert.lolcena.interceptors.HomeInteractor;
import com.pedronalbert.lolcena.views.HomeView;

/**
 * Created by pedronalbert on 16/11/16.
 */

public class HomePresenter {
    private HomeView mainView;
    private HomeInteractor interactor;

    public HomePresenter(HomeActivity homeView) {
        this.mainView = homeView;
        this.interactor = new HomeInteractor(homeView, this);
    }

    public void searchSummoner (String summonerName, String region) {
        mainView.showLoadingDialog();
        interactor.searchSummonerByName(summonerName, region);
    }

    public void onSearchFail (String message) {
        mainView.hideLoadingDialog();
        mainView.showError(message);
    }

    public void onSearchSummonerSuccess (SummonerData summonerData) {
        mainView.hideLoadingDialog();
        mainView.goToSummonerProfile(summonerData);
    }
}
