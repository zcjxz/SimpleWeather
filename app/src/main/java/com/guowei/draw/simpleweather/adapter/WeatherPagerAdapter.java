package com.guowei.draw.simpleweather.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.guowei.draw.simpleweather.fragment.WeatherFragment;

import java.util.ArrayList;


public class WeatherPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<WeatherFragment> forecastList;

    public WeatherPagerAdapter(FragmentManager fm,ArrayList<WeatherFragment> forecastList) {
        super(fm);
        this.forecastList=forecastList;
    }

    @Override
    public int getCount() {
        return forecastList.size();
    }

    @Override
    public Fragment getItem(int position) {
        return forecastList.get(position);
    }

}
