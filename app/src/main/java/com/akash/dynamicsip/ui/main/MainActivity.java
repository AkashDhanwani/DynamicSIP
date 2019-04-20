package com.akash.dynamicsip.ui.main;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.akash.dynamicsip.MvpApp;
import com.akash.dynamicsip.R;
import com.akash.dynamicsip.data.DataManager;
import com.akash.dynamicsip.ui.base.BaseActivity;
import com.akash.dynamicsip.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class MainActivity extends BaseActivity implements MainMvpView {

    MainMvpPresenter<MainMvpView> mainMvpPresenter;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private TextView pointTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int orientaton = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
        setRequestedOrientation(orientaton);

        //DataManager dataManager = ((MvpApp)getApplication()).getDataManager();
        //SchedulerProvider schedulerProvider;
        //CompositeDisposable compositeDisposable;

        //mainMvpPresenter = new MainPresenter<>(dataManager, schedulerProvider, compositeDisposable);
        mainMvpPresenter.onAttach(MainActivity.this);

        pointTV = findViewById(R.id.pointTVMain);

        recyclerView = findViewById(R.id.dateRVMain);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false));

        mainMvpPresenter.onViewPrepared();
    }

    @Override
    public void onSetRV(String tp) {
        pointTV.setText(tp);
    }
}
