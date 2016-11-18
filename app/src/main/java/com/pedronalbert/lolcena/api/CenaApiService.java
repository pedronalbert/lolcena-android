package com.pedronalbert.lolcena.api;

/**
 * Created by pedronalbert on 17/11/16.
 */

public class CenaApiService {
    public static CenaApiEndpoint getService () {
        return CenaApiClient
                    .getClient()
                    .create(CenaApiEndpoint.class);
    }
}
