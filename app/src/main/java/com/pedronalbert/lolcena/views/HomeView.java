package com.pedronalbert.lolcena.views;

import com.pedronalbert.lolcena.api.models.summoner.SummonerData;

/**
 * Created by pedronalbert on 16/11/16.
 */

public interface HomeView {
    void showLoadingDialog ();

    void hideLoadingDialog ();

    void showError (String message);

    void goToSummonerProfile (SummonerData summonerData);
}
