package com.akash.dynamicsip.data;

import com.akash.dynamicsip.data.network.APIHelper;
import com.akash.dynamicsip.data.network.model.ApiResponse;

import io.reactivex.Single;

public class AppDataManager implements DataManager {

    private APIHelper apiHelper;

    public AppDataManager(APIHelper apiHelper) {
        this.apiHelper = apiHelper;
    }

    @Override
    public Single<ApiResponse> doApiCall() {
        return apiHelper.doApiCall();
    }
}
