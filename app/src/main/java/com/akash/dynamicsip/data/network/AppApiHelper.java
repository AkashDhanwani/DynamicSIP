package com.akash.dynamicsip.data.network;

import android.os.AsyncTask;
import android.util.Log;

import com.akash.dynamicsip.data.network.model.ApiResponse;
import com.akash.dynamicsip.ui.main.MainActivity;
import com.akash.dynamicsip.utils.CommonUtils;
import com.rx2androidnetworking.Rx2AndroidNetworking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;

public class AppApiHelper implements APIHelper{

    List<ApiResponse> apiResponseList = new ArrayList<>();

    String tester;

    public AppApiHelper(){
        String API = "http://demo0312305.mockable.io/testCashRich";

        Log.d(CommonUtils.TAG_CHECK, "in apiconst ");

//        Task task = new Task();
//        task.execute(API);
    }

    @Override
    public Single<ApiResponse> doApiCall() {

        Log.d(CommonUtils.TAG_CHECK, "in doapi "+tester);
        //Log.d(CommonUtils.TAG_CHECK, "in doapi "+getTester());
        return Rx2AndroidNetworking.get("http://demo0312305.mockable.io/testCashRich")
                .build()
                .getObjectSingle(ApiResponse.class);
    }

//    class Task extends AsyncTask<String, Void, String>{
//
//        String jsonstr="";
//        String line= "";
//        String resultSet=null;
//
//        @Override
//        protected String doInBackground(String... strings) {
//            try {
//                URL url = new URL(strings[0]);
//                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//                //connection.setRequestMethod("GET");
//                connection.connect();
//                InputStream is = connection.getInputStream();
//                BufferedReader br = new BufferedReader(new InputStreamReader(is));
//
//
////                List<Products> data=new ArrayList<>();
//
//
//                while ((line = br.readLine()) != null)
//                {
//                    jsonstr+=line +"\n";
//                }
//            } catch (MalformedURLException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            return jsonstr;
//        }
//
//        @Override
//        protected void onPostExecute(String s) {
//            super.onPostExecute(s);
//
//            tester = s;
//            Log.d(CommonUtils.TAG_CHECK, "in postexe "+tester);
//
//
//        }
//    }
//
//    public String getTester() {
//        return tester;
//    }
//
//    public void setTester(String tester) {
//        Log.d(CommonUtils.TAG_CHECK, "in settester "+tester);
//        this.tester = tester;
//    }
}
