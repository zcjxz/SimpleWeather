package com.guowei.draw.simpleweather.utils;

import com.guowei.draw.simpleweather.WeatherApplication;

public class ResourcesUtil {
    public static String getString(int resourcesId){
        String resourceString = WeatherApplication.getApplication().getResources().getString(resourcesId);
        return resourceString;
    }
    public static int getColor(int resourcesId){
        int color = WeatherApplication.getApplication().getResources().getColor(resourcesId);
        return color;
    }
}
