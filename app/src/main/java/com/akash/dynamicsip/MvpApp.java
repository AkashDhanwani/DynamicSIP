package com.akash.dynamicsip;

import android.app.Application;

import com.akash.dynamicsip.data.AppDataManager;
import com.akash.dynamicsip.data.DataManager;
import com.akash.dynamicsip.data.network.APIHelper;
import com.akash.dynamicsip.data.network.AppApiHelper;

public class MvpApp extends Application {

    DataManager dataManager;

    @Override
    public void onCreate() {
        super.onCreate();

        APIHelper apiHelper = new AppApiHelper();
        dataManager = new AppDataManager(apiHelper);
    }

    public DataManager getDataManager() {
        return dataManager;
    }
}
