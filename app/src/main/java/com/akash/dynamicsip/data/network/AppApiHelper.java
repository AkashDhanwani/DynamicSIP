package com.akash.dynamicsip.data.network;

import android.os.AsyncTask;
import android.util.Log;

import com.akash.dynamicsip.data.network.model.ApiResponse;
import com.akash.dynamicsip.utils.CommonUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class AppApiHelper implements APIHelper{

    List<ApiResponse> listReturn = new ArrayList<>();

    String tester;

    public AppApiHelper(){


        Log.d(CommonUtils.TAG_FLOW, "in api const ");

    }

    @Override
    public List<ApiResponse> doApiCall() {

        String API = "http://demo0312305.mockable.io/testCashRich";

        //Task task = new Task();
        //task.execute(API);
        try {
            listReturn = new Task().execute(API).get();
            if(!listReturn.isEmpty())
                Log.d(CommonUtils.TAG_CHECK, "return string "+listReturn.get(0).getDate());
            return listReturn;
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    class Task extends AsyncTask<String, Void, List<ApiResponse>>{

        String jsonstr="";
        String line= "";

        List<ApiResponse> apiResponseList = new ArrayList<>();
        @Override
        protected List<ApiResponse> doInBackground(String... strings) {
            try {

                Log.d(CommonUtils.TAG_CHECK, "in async task");

                URL url = new URL(strings[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                //connection.setRequestMethod("GET");
                connection.connect();
                InputStream is = connection.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));

                while ((line = br.readLine()) != null)
                {
                    jsonstr+=line +"\n";
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(jsonstr!=null){
                try {
                    JSONArray jsonArray = new JSONArray(jsonstr);
                    Log.d(CommonUtils.TAG_CHECK, "jsonArray length "+jsonArray.length());
                    for(int i=0; i<jsonArray.length() ; i++){
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        ApiResponse apiResponse = new ApiResponse(jsonObject.getString("date"),
                                                                    jsonObject.getString("sensex"),
                                                                    jsonObject.getString("equity"),
                                                                    jsonObject.getString("point"),
                                                                    false);

                        Log.d(CommonUtils.TAG_CHECK, "check response "+apiResponse.getDate());

                        apiResponseList.add(apiResponse);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return apiResponseList;
        }

//        @Override
//        protected void onPostExecute(String s) {
//            super.onPostExecute(s);
//
//            //tester = s;
//            Log.d(CommonUtils.TAG_CHECK, "in postexe "+tester);
//
//            //MainActivity mainActivity = new MainActivity(s);
//        }
    }

    public String getTester() {
        return tester;
    }

    public void setTester(String tester) {
        Log.d(CommonUtils.TAG_CHECK, "in settester "+tester);
        this.tester = tester;
    }
}
