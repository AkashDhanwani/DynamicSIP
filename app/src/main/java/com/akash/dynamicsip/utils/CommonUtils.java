package com.akash.dynamicsip.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class CommonUtils {

    public static String TAG_CHECK = "check";

    public static boolean isNetworkConnected(Context context) {
        ConnectivityManager cm =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
    }
}
