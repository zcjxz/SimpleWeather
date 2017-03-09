package com.guowei.draw.simpleweather.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.guowei.draw.simpleweather.fragment.WeatherFragment;


public class WeatherAdapter extends FragmentPagerAdapter{
    public WeatherAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return new WeatherFragment();
    }

    @Override
    public int getCount() {
        return 3;
    }

}
