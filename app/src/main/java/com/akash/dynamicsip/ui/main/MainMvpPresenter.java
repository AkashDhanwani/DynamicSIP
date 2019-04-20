package com.akash.dynamicsip.ui.main;

import com.akash.dynamicsip.ui.base.MvpPresenter;

public interface MainMvpPresenter<V extends MainMvpView> extends MvpPresenter<V> {

    void onViewPrepared();

}
