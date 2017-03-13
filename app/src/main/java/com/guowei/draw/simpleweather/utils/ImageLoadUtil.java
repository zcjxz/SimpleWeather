package com.guowei.draw.simpleweather.utils;


import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.guowei.draw.simpleweather.WeatherApplication;

public class ImageLoadUtil {
    public static void displayPicFromLocation(int id, ImageView imageView){
        Glide.with(WeatherApplication.getApplication())
                .load(id)
                .into(imageView);
    }
    public static void displayPicFromUrl(String url,ImageView imageView){
        Glide.with(WeatherApplication.getApplication())
                .load(url)
                .into(imageView);
    }
}
