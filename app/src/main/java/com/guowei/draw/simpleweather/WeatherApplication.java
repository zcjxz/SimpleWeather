package com.guowei.draw.simpleweather;

import android.app.Application;


public class WeatherApplication extends Application{
    public static WeatherApplication application;

    @Override
    public void onCreate() {
        super.onCreate();
        application=this;
    }

    public static WeatherApplication getApplication(){
        return application;
    }
}
