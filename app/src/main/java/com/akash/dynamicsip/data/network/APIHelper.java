package com.akash.dynamicsip.data.network;

import com.akash.dynamicsip.data.network.model.ApiResponse;

import java.util.List;

public interface APIHelper {

    List<ApiResponse> doApiCall();
}
