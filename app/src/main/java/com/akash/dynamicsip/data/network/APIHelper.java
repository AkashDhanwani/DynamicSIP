package com.akash.dynamicsip.data.network;

import com.akash.dynamicsip.data.network.model.ApiResponse;

import io.reactivex.Single;

public interface APIHelper {

    Single<ApiResponse> doApiCall();
}
