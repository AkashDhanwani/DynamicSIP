package com.akash.dynamicsip.ui.main;

import android.content.pm.ActivityInfo;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.akash.dynamicsip.MvpApp;
import com.akash.dynamicsip.R;
import com.akash.dynamicsip.data.DataManager;
import com.akash.dynamicsip.data.network.model.ApiResponse;
import com.akash.dynamicsip.ui.base.BaseActivity;
import com.akash.dynamicsip.utils.CommonUtils;

import java.util.List;

public class MainActivity extends BaseActivity implements MainMvpView {

    MainMvpPresenter<MainMvpView> mainMvpPresenter;

    String data="Hi hello";

    private ConstraintLayout constraintLayout;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private TextView pointTV, fixedValueMain, shareValueMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int orientaton = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
        setRequestedOrientation(orientaton);

        Log.d(CommonUtils.TAG_FLOW, "Inside mainact oncreate first");


        DataManager dataManager = ((MvpApp)getApplication()).getDataManager();
        //SchedulerProvider schedulerProvider;
        //CompositeDisposable compositeDisposable;

        mainMvpPresenter = new MainPresenter<>(dataManager);
        mainMvpPresenter.onAttach(MainActivity.this);

        pointTV = findViewById(R.id.pointTVMain);
        fixedValueMain = findViewById(R.id.fixedValueMain);
        shareValueMain = findViewById(R.id.shareValueMain);
        constraintLayout = findViewById(R.id.constraintLayoutMain);
        recyclerView = findViewById(R.id.dateRVMain);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false));

        mainMvpPresenter.onViewPrepared();

        //pointTV.setText(data);
    }

    @Override
    public void onSetRV(List<ApiResponse> apiResponseList) {
        adapter = new MainActAdapter(MainActivity.this, apiResponseList, fixedValueMain, shareValueMain, pointTV, constraintLayout);
        recyclerView.setAdapter(adapter);
    }
}
