package com.akash.dynamicsip.data;

import android.content.Context;
import android.util.Log;

import com.akash.dynamicsip.data.network.APIHelper;
import com.akash.dynamicsip.data.network.model.ApiResponse;
import com.akash.dynamicsip.utils.CommonUtils;

import java.util.List;

//import io.reactivex.Single;

public class AppDataManager implements DataManager {

    //private Context context;
    private APIHelper apiHelper;

    public AppDataManager(APIHelper apiHelper) {
       // this.context = context;
        this.apiHelper = apiHelper;

        Log.d(CommonUtils.TAG_FLOW, "Inside Appdatamana const");

    }

    @Override
    public List<ApiResponse> doApiCall() {
        return apiHelper.doApiCall();
    }
}
