package com.akash.dynamicsip.ui.base;

import android.util.Log;

import com.akash.dynamicsip.data.DataManager;
import com.akash.dynamicsip.utils.CommonUtils;

//import io.reactivex.disposables.CompositeDisposable;

public class BasePresenter<V extends MvpView> implements MvpPresenter<V> {

    DataManager dataManager;
    private V mMvpView;

    public BasePresenter(DataManager dataManager){
        this.dataManager = dataManager;
//        this.mSchedulerProvider = schedulerProvider;
//        this.mCompositeDisposable = compositeDisposable;
    }


//    public SchedulerProvider getSchedulerProvider() {
//        return mSchedulerProvider;
//    }
//
//    public CompositeDisposable getCompositeDisposable() {
//        return mCompositeDisposable;
//    }

    @Override
    public void onAttach(V mvpView) {
        mMvpView=mvpView;
    }

    public boolean isViewAttached() {
        //Log.d(CommonUtils.TAG_FLOW, "in BasePresenter isViewAttached");
        return mMvpView != null;
    }

    public DataManager getDataManager() {
        return dataManager;
    }

    public V getmMvpView() {
        return mMvpView;
    }
}
