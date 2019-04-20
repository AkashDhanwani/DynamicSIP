package com.akash.dynamicsip.ui.base;

import android.support.v7.app.AppCompatActivity;

import com.akash.dynamicsip.utils.CommonUtils;

public class BaseActivity extends AppCompatActivity implements MvpView {


    @Override
    public boolean isNetworkConnected() {
        return CommonUtils.isNetworkConnected(getApplicationContext());
    }
}
