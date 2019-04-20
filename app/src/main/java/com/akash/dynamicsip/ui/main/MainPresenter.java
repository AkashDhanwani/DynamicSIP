package com.akash.dynamicsip.ui.main;

import com.akash.dynamicsip.data.DataManager;
import com.akash.dynamicsip.data.network.model.ApiResponse;
import com.akash.dynamicsip.ui.base.BasePresenter;
import com.akash.dynamicsip.utils.rx.SchedulerProvider;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

public class MainPresenter<V extends MainMvpView> extends BasePresenter<V> implements MainMvpPresenter<V> {

    public MainPresenter(DataManager dataManager,
                         SchedulerProvider schedulerProvider,
                         CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onViewPrepared() {
       // String tp = getDataManager().doApiCall();

        getCompositeDisposable().add(getDataManager()
            .doApiCall()
            .subscribeOn(getSchedulerProvider().io())
            .observeOn(getSchedulerProvider().ui())
            .subscribe(new Consumer<ApiResponse>() {
                @Override
                public void accept(ApiResponse apiResponse) throws Exception {
                    if (apiResponse != null && apiResponse.getDate() != null) {
                        getmMvpView().onSetRV(apiResponse.getDate());
                    }
                }
            }, new Consumer<Throwable>(){

                        @Override
                        public void accept(Throwable throwable) throws Exception {
                            if (!isViewAttached()) {
                                return;
                            }
                        }
                    }));
    }

}
