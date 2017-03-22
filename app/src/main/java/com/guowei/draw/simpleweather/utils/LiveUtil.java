package com.guowei.draw.simpleweather.utils;

import android.app.ActivityManager;
import android.content.Context;

import com.guowei.draw.simpleweather.WeatherApplication;

import java.util.List;

public class LiveUtil {
    public static final String clockservice ="Clockservice";
    public static final String notification ="NotificationService";
    public static boolean isServiceRunning(String serviceName){
        ActivityManager activityManager = (ActivityManager) WeatherApplication.getApplication().getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningServiceInfo> serviceList = activityManager.getRunningServices(200);
        if (serviceList.size()<=0) {
            return false;
        }
        for (ActivityManager.RunningServiceInfo info:serviceList){
            if (info.service.getClassName().equals(serviceName)){
                return true;
            }
        }
        return false;
    }

}
