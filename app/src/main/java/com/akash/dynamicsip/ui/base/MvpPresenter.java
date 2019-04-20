package com.akash.dynamicsip.ui.base;

public interface MvpPresenter<V extends MvpView> {

    void onAttach(V mvpView);
}
