package com.guowei.draw.simpleweather.utils;

import android.app.ActivityManager;
import android.content.Context;

import com.guowei.draw.simpleweather.WeatherApplication;

import java.util.List;

public class LiveUtil {
    public static final String clockservice ="com.guowei.draw.simpleweather.widget.ClockService";
    public static final String notification ="com.guowei.draw.simpleweather.notification.NotificationService";
    public static boolean isServiceRunning(String serviceName){
        ActivityManager activityManager = (ActivityManager) WeatherApplication.getApplication().getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningServiceInfo> serviceList = activityManager.getRunningServices(200);
        for (ActivityManager.RunningServiceInfo info:serviceList){
            String currentService = info.service.getClassName().toString();
            DebugUtil.debug("zcj_log_service",currentService);
            if (currentService.equals(serviceName)){
                return true;
            }
        }
        return false;
    }

}
