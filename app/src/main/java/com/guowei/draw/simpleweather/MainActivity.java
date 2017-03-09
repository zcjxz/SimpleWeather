package com.guowei.draw.simpleweather;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.guowei.draw.simpleweather.adapter.WeatherAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    String TAG="MainActivity";
    @BindView(R.id.viewpager)
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        viewPager.setAdapter(new WeatherAdapter(getSupportFragmentManager()));
        Log.i(TAG, "onCreate: .....");
    }
}
