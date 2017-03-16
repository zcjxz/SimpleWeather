package com.guowei.draw.simpleweather;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.guowei.draw.simpleweather.adapter.WeatherPagerAdapter;
import com.guowei.draw.simpleweather.bean.CaiRealTimeBean;
import com.guowei.draw.simpleweather.fragment.WeatherFragment;
import com.guowei.draw.simpleweather.utils.DebugUtil;
import com.guowei.draw.simpleweather.utils.HttpUtils;
import com.guowei.draw.simpleweather.utils.ImageLoadUtil;
import com.guowei.draw.simpleweather.utils.TransformUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import rx.Subscriber;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CollapsingToolbarLayoutState state;
    public LocationClient mLocationClient = null;
    public BDLocationListener mlistener = new MyLocationListener();
    private ArrayList<WeatherFragment> forecastList = new ArrayList<>();

    @BindView(R.id.viewpager)
    ViewPager viewPager;
    @BindView(R.id.collapsingToolbarLayout)
    CollapsingToolbarLayout collapsingToolbarLayout;
    @BindView(R.id.appbar)
    AppBarLayout appBarLayout;
    @BindView(R.id.rl_template)
    RelativeLayout rlTemplate;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.iv_bg)
    ImageView ivBg;
    @BindView(R.id.title_menu)
    ImageView titleMenu;
    @BindView(R.id.activity_main)
    DrawerLayout drawerLayout;
    @BindView(R.id.navigationView)
    NavigationView navigationView;
    @BindView(R.id.tv_template)
    TextView tvTemplate;
    @BindView(R.id.skycon)
    TextView tvSkycon;
    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.tv_location)
    TextView tvLocation;
    @BindView(R.id.iv_skycon)
    ImageView ivSkycon;
    @BindView(R.id.tv_wind)
    TextView tvWind;
    private WeatherPagerAdapter viewPagerAdapter;
    private WeatherFragment locationFragment;
    private SwipeRefreshLayout.OnRefreshListener swipeRefreshListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setTranslucentForDrawerLayout(this,drawerLayout);
        setSupportActionBar(toolbar);
        //toolbar不显示标题
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayShowTitleEnabled(false);
        }
        //设置监听appbar滑动
        setAppBarListener();
        //百度地图初始化
        mLocationClient = new LocationClient(getApplicationContext());
        mLocationClient.registerLocationListener(mlistener);
        locationFragment = new WeatherFragment();
        Bundle localBundle = new Bundle();
        localBundle.putBoolean("isLocal", true);
        locationFragment.setArguments(localBundle);
        forecastList.add(locationFragment);
//        Bundle cityBundle = new Bundle();
//        cityBundle.putBoolean("isLocal",false);
//        cityBundle.putString("city","汕头");
//        WeatherFragment cityFragment = new WeatherFragment();
//        cityFragment.setArguments(cityBundle);
//        forecastList.add(cityFragment);
        viewPagerAdapter = new WeatherPagerAdapter(getSupportFragmentManager(), forecastList);
        viewPager.setAdapter(viewPagerAdapter);
        titleMenu.setOnClickListener(this);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder()
                            .url("http://guolin.tech/api/bing_pic")
                            .build();
                    Response response = client.newCall(request).execute();
                    final String url = response.body().string();

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            ImageLoadUtil.displayPicFromUrl(url, ivBg);
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();


        //动态权限
        List<String> permissionList = new ArrayList<>();
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(Manifest.permission.ACCESS_FINE_LOCATION);
        }
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(Manifest.permission.READ_PHONE_STATE);
        }
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }
        if (!permissionList.isEmpty()) {
            String[] permissions = permissionList.toArray(new String[permissionList.size()]);
            ActivityCompat.requestPermissions(MainActivity.this, permissions, 1);
        } else {
            startLocation();
        }
        swipeRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refresh();
            }
        };
        swipeRefreshLayout.setOnRefreshListener(swipeRefreshListener);
        swipeRefreshListener.onRefresh();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_about:
                        startActivity(new Intent(MainActivity.this,AboutActivity.class));
                        break;
                }
                return true;
            }
        });
    }

    /**
     * 为 DrawerLayout 布局设置状态栏透明
     *
     * @param activity     需要设置的activity
     * @param drawerLayout DrawerLayout
     */
    public static void setTranslucentForDrawerLayout(Activity activity, DrawerLayout drawerLayout) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            // 设置状态栏透明
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            // 设置内容布局属性
            ViewGroup contentLayout = (ViewGroup) drawerLayout.getChildAt(0);
            contentLayout.setFitsSystemWindows(true);
            contentLayout.setClipToPadding(true);
            // 设置抽屉布局属性
            ViewGroup vg = (ViewGroup) drawerLayout.getChildAt(1);
            vg.setFitsSystemWindows(false);
            // 设置 DrawerLayout 属性
            drawerLayout.setFitsSystemWindows(false);
        }
    }

    public void refresh() {
        requestLocation();
    }

    private void startLocation() {
        //开始获取位置
        LocationClientOption option = new LocationClientOption();
        option.setIsNeedAddress(true);
        mLocationClient.setLocOption(option);
        mLocationClient.start();
    }

    public void requestLocation() {
        DebugUtil.debug("requsetLocation");
        if (mLocationClient != null) {
            mLocationClient.requestLocation();
        }
    }

    /**
     * 监听appbar滑动
     */
    private void setAppBarListener() {
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (verticalOffset == 0) {
                    if (state != CollapsingToolbarLayoutState.EXPANDED) {
                        state = CollapsingToolbarLayoutState.EXPANDED;//修改状态标记为展开
//                        collapsingToolbarLayout.setTitle("");//设置title为EXPANDED
                    }
                } else if (Math.abs(verticalOffset) >= appBarLayout.getTotalScrollRange()) {
                    if (state != CollapsingToolbarLayoutState.COLLAPSED) {
//                        collapsingToolbarLayout.setTitle("深圳");
                        state = CollapsingToolbarLayoutState.COLLAPSED;//修改状态标记为折叠
                        rlTemplate.setAlpha(0.0f);
                    }
                } else {
                    if (state != CollapsingToolbarLayoutState.INTERNEDIATE) {
                        if (state == CollapsingToolbarLayoutState.COLLAPSED) {
//                            collapsingToolbarLayout.setTitle("");
                        }
                        state = CollapsingToolbarLayoutState.INTERNEDIATE;//修改状态标记为中间
                    } else {
                        float vOffset = Math.abs(verticalOffset) + 0.01f;
                        float tRange = appBarLayout.getTotalScrollRange() + 0.01f;
                        float offset = (tRange - vOffset) / tRange;
                        rlTemplate.setAlpha(offset);
                    }
                }
                //动态修改swipeRefresh是否可用，解决与CoordinatorLayout的冲突
                if (verticalOffset == 0) {
                    swipeRefreshLayout.setEnabled(true);
                } else {
                    if (!swipeRefreshLayout.isRefreshing()) {
                        swipeRefreshLayout.setEnabled(false);
                    }
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.title_menu:
                drawerLayout.openDrawer(GravityCompat.START);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawers();
        } else {
            super.onBackPressed();
        }
    }

    private enum CollapsingToolbarLayoutState {
        EXPANDED,//展开
        COLLAPSED,//折叠
        INTERNEDIATE//折叠中
    }

    public class MyLocationListener implements BDLocationListener {

        @Override
        public void onReceiveLocation(final BDLocation bdLocation) {
            StringBuilder currentPosition = new StringBuilder();
            double latitude = bdLocation.getLatitude();
            currentPosition.append("纬度：").append(latitude).append("\n");
            double longitude = bdLocation.getLongitude();
            currentPosition.append("经度：").append(longitude).append("\n");
            currentPosition.append("定位方式：");
            if (bdLocation.getLocType() == BDLocation.TypeGpsLocation) {
                currentPosition.append("GPS");
            } else if (bdLocation.getLocType() == BDLocation.TypeNetWorkLocation) {
                currentPosition.append("网络");
            }
            currentPosition.append("\n");
            currentPosition.append("省：").append(bdLocation.getProvince()).append("\n");
            currentPosition.append("市：").append(bdLocation.getCity()).append("\n");
            currentPosition.append("区：").append(bdLocation.getDistrict()).append("\n");
            currentPosition.append("街道：").append(bdLocation.getStreet()).append("\n");
            currentPosition.append("城市代码： ").append(bdLocation.getCityCode()).append("\n");
            DebugUtil.debug("onReceiveLocation: \n" + currentPosition);

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (bdLocation.getStreet() != null) {
                        tvLocation.setText(bdLocation.getStreet());
                    }
                    swipeRefreshLayout.setRefreshing(false);
                }
            });
            requestRealtimeWeather(longitude + "", latitude + "");
            SharedPreferences sp = getSharedPreferences("local", MODE_PRIVATE);
            sp.edit().putString("longitude", longitude + "").putString("latitude", latitude + "").commit();
            locationFragment.setLocation(bdLocation);
        }

        @Override
        public void onConnectHotSpotMessage(String s, int i) {

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        DebugUtil.debug("正在动态获取权限");
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0) {
                    for (int result : grantResults) {
                        if (result != PackageManager.PERMISSION_GRANTED) {
                            Toast.makeText(this, "同意定位权限才能获取当地的天气哦", Toast.LENGTH_SHORT).show();
                        }
                    }
                    DebugUtil.debug("成功获取权限");
                    startLocation();
                } else {
                    Toast.makeText(this, "发生未知错误", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    /**
     * 获取实时天气
     *
     * @param longitude
     * @param latitude
     */
    private void requestRealtimeWeather(String longitude, String latitude) {
        HttpUtils.getInstance().getCaiRealTimeWeather(longitude + "", latitude + "", new Subscriber<CaiRealTimeBean>() {

            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                DebugUtil.debug("获取实时天气错误： " + e.toString());
            }

            @Override
            public void onNext(CaiRealTimeBean caiRealTimeBean) {
                DebugUtil.debug("获取实时天气\n" + caiRealTimeBean.toString());
                showToolbarData(caiRealTimeBean);
            }

        });
    }


    /**
     * 显示toolbar数据
     */
    private void showToolbarData(CaiRealTimeBean realTimeBean) {
        DebugUtil.debug("显示toolbar数据");
        CaiRealTimeBean.ResultBean result = realTimeBean.getResult();
        //Toolbar上的天气概况
        tvTemplate.setText((int) result.getTemperature() + "℃");
        String skycon = TransformUtils.transformSkycon(result.getSkycon());
        tvSkycon.setText(skycon);
        String windDirection = TransformUtils.transformDirection(
                result.getWind().getDirection());
        String windSpeed = TransformUtils.transformSpeed(result.getWind().getSpeed());
        tvWind.setText(windDirection + "  " + windSpeed);
        int skyconIcon = TransformUtils.transformIcon(result.getSkycon());
        ImageLoadUtil.displayPicFromLocation(skyconIcon, ivSkycon);
        DebugUtil.debug("关闭刷新");
        swipeRefreshLayout.setRefreshing(false);
    }
}
