package com.pedronalbert.lolcena.presenters;

import com.pedronalbert.lolcena.views.HomeView;

/**
 * Created by pedronalbert on 16/11/16.
 */

public class HomePresenter {
    private HomeView mainView;

    public HomePresenter(HomeView homeView) {
        this.mainView = homeView;
    }

    public void searchSummoner (String summonerName, String region) {
        mainView.showLoadingDialog();
    }
}
