package com.guowei.draw.simpleweather.utils;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.guowei.draw.simpleweather.WeatherApplication;

public class NetworkUtil {
    public static boolean isUseable(){
        ConnectivityManager connectivityManager = (ConnectivityManager) WeatherApplication.getApplication().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo!=null&&networkInfo.isConnected()){
            if (networkInfo.getState()==NetworkInfo.State.CONNECTED){
                return true;
            }
        }
        return false;
    }
}
