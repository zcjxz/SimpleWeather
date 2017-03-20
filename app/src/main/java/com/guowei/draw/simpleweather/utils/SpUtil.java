package com.guowei.draw.simpleweather.utils;


import android.content.Context;
import android.content.SharedPreferences;

import com.guowei.draw.simpleweather.WeatherApplication;

public class SpUtil {
    public static void postString(String spName,String key,String value){
        SharedPreferences sp = WeatherApplication.getApplication().getSharedPreferences(spName, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.putString(key,value);
        edit.apply();
    }
    public static void postInt(String spName,String key,int value){
        SharedPreferences sp = WeatherApplication.getApplication().getSharedPreferences(spName, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.putInt(key,value);
        edit.apply();
    }
    public static String getString(String spName,String key,String dfValue){
        SharedPreferences sp = WeatherApplication.getApplication().getSharedPreferences(spName, Context.MODE_APPEND);
        String value = sp.getString(key, dfValue);
        return value;
    }
    public static int getInt(String spName,String key,int dfValue){
        SharedPreferences sp = WeatherApplication.getApplication().getSharedPreferences(spName, Context.MODE_APPEND);
        int value = sp.getInt(key, dfValue);
        return value;
    }
}
