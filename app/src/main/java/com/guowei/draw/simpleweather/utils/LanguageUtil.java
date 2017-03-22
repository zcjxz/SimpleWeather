package com.guowei.draw.simpleweather.utils;

import com.guowei.draw.simpleweather.WeatherApplication;

import java.util.Locale;

public class LanguageUtil {
    public static boolean isZh() {
        WeatherApplication context = WeatherApplication.getApplication();
        Locale locale = context.getResources().getConfiguration().locale;
        String language = locale.getLanguage();
        if (language.endsWith("zh"))
            return true;
        else
            return false;
    }
}
