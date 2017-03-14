package com.guowei.draw.simpleweather.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.guowei.draw.simpleweather.R;
import com.guowei.draw.simpleweather.bean.CaiForecastBean;
import com.guowei.draw.simpleweather.fragment.WeatherFragment;
import com.guowei.draw.simpleweather.utils.ImageLoadUtil;
import com.guowei.draw.simpleweather.utils.TransformUtils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


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
