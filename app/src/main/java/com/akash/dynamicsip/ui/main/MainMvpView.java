package com.akash.dynamicsip.ui.main;

import com.akash.dynamicsip.data.network.model.ApiResponse;
import com.akash.dynamicsip.ui.base.MvpView;

import java.util.List;

public interface MainMvpView extends MvpView {

    void onSetRV(List<ApiResponse> tp);
}
