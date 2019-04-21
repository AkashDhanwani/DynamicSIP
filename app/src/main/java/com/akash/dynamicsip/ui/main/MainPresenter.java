package com.akash.dynamicsip.ui.main;

import com.akash.dynamicsip.data.DataManager;
import com.akash.dynamicsip.data.network.model.ApiResponse;
import com.akash.dynamicsip.ui.base.BasePresenter;

import java.util.List;

public class MainPresenter<V extends MainMvpView> extends BasePresenter<V> implements MainMvpPresenter<V> {

    public MainPresenter(DataManager dataManager) {
        super(dataManager);
    }

    @Override
    public void onViewPrepared() {
         List<ApiResponse> apiResponses = getDataManager().doApiCall();
        getmMvpView().onSetRV(apiResponses);
    }
}
