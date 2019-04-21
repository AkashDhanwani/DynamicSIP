package com.akash.dynamicsip;

import android.app.Application;
import android.util.Log;

import com.akash.dynamicsip.data.AppDataManager;
import com.akash.dynamicsip.data.DataManager;
import com.akash.dynamicsip.data.network.APIHelper;
import com.akash.dynamicsip.data.network.AppApiHelper;
import com.akash.dynamicsip.utils.CommonUtils;

public class MvpApp extends Application {

    DataManager dataManager;

    @Override
    public void onCreate() {
        super.onCreate();

        APIHelper apiHelper = new AppApiHelper();
        dataManager = new AppDataManager(apiHelper);

        Log.d(CommonUtils.TAG_FLOW, "Inside Mvp oncreate");

//        AndroidNetworking.initialize(getApplicationContext());
//        if (BuildConfig.DEBUG) {
//            AndroidNetworking.enableLogging(HttpLoggingInterceptor.Level.BODY);
//        }
    }

    public DataManager getDataManager() {
        return dataManager;
    }
}
