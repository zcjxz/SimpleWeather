package com.guowei.draw.simpleweather;

import android.Manifest;
import android.content.pm.PackageManager;
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

import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.bumptech.glide.Glide;
import com.guowei.draw.simpleweather.adapter.WeatherPagerAdapter;
import com.guowei.draw.simpleweather.bean.CaiRealTimeBean;
import com.guowei.draw.simpleweather.utils.DebugUtil;
import com.guowei.draw.simpleweather.utils.HttpUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Subscriber;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private CollapsingToolbarLayoutState state;
    public LocationClient mLocationClient =null;
    public BDLocationListener mlistener=new MyLocationListener();

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
    @BindView(R.id.template)
    TextView tv_template;
    @BindView(R.id.skycon)
    TextView tv_skycon;
    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.tv_location)
    TextView tvLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        //toolbar不显示标题
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar!=null){
            supportActionBar.setDisplayShowTitleEnabled(false);
        }
        viewPager.setAdapter(new WeatherPagerAdapter(this));
        //设置监听appbar滑动
        setAppBarListener();
        Glide.with(this).load(R.drawable.bg).into(ivBg);
        titleMenu.setOnClickListener(this);
        //百度地图初始化
        mLocationClient =new LocationClient(getApplicationContext());
        mLocationClient.registerLocationListener(mlistener);
        //动态权限
        List<String> permissionList =new ArrayList<>();
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED){
            permissionList.add(Manifest.permission.ACCESS_FINE_LOCATION);
        }
        if (ContextCompat.checkSelfPermission(MainActivity.this,Manifest.permission.READ_PHONE_STATE)!=PackageManager.PERMISSION_GRANTED){
            permissionList.add(Manifest.permission.READ_PHONE_STATE);
        }
        if (ContextCompat.checkSelfPermission(MainActivity.this,Manifest.permission.WRITE_EXTERNAL_STORAGE)!=PackageManager.PERMISSION_GRANTED){
            permissionList.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }
        if (!permissionList.isEmpty()){
            String[] permissions=permissionList.toArray(new String[permissionList.size()]);
            ActivityCompat.requestPermissions(MainActivity.this,permissions,1);
        }else{
            Log.i("zcj", "已经获取到了权限");
            requestLocation();
        }
    }

    private void requestLocation(){
        //开始获取位置
        LocationClientOption option=new LocationClientOption();
        option.setIsNeedAddress(true);
        mLocationClient.setLocOption(option);
        mLocationClient.start();
    }

    /**
     * 监听appbar滑动
     */
    private void setAppBarListener(){
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
                        if(state == CollapsingToolbarLayoutState.COLLAPSED){
//                            collapsingToolbarLayout.setTitle("");
                        }
                        state = CollapsingToolbarLayoutState.INTERNEDIATE;//修改状态标记为中间
                    }else{
                        float vOffset = Math.abs(verticalOffset) + 0.01f;
                        float tRange = appBarLayout.getTotalScrollRange() + 0.01f;
                        float offset =(tRange-vOffset)/tRange;
                        rlTemplate.setAlpha(offset);
                    }
                }
                //动态修改swipeRefresh是否可用，解决与CoordinatorLayout的冲突
                if (verticalOffset == 0){
                        swipeRefreshLayout.setEnabled(true);
                }else{
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
        switch (id){
            case R.id.title_menu:
                drawerLayout.openDrawer(GravityCompat.START);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawers();
        }else {
            super.onBackPressed();
        }
    }

    private enum CollapsingToolbarLayoutState{
        EXPANDED,//展开
        COLLAPSED,//折叠
        INTERNEDIATE//折叠中
    }

    public class MyLocationListener implements BDLocationListener{

        @Override
        public void onReceiveLocation(final BDLocation bdLocation) {
            StringBuilder currentPosition=new StringBuilder();
            double latitude = bdLocation.getLatitude();
            currentPosition.append("纬度：").append(latitude).append("\n");
            double longitude = bdLocation.getLongitude();
            currentPosition.append("经度：").append(longitude).append("\n");
            currentPosition.append("定位方式：");
            if (bdLocation.getLocType()==BDLocation.TypeGpsLocation){
                currentPosition.append("GPS");
            }else if (bdLocation.getLocType()==BDLocation.TypeNetWorkLocation){
                currentPosition.append("网络");
            }
            currentPosition.append("\n");
            currentPosition.append("省：").append(bdLocation.getProvince()).append("\n");
            currentPosition.append("市：").append(bdLocation.getCity()).append("\n");
            currentPosition.append("区：").append(bdLocation.getDistrict()).append("\n");
            currentPosition.append("街道：").append(bdLocation.getStreet()).append("\n");
            DebugUtil.debug("onReceiveLocation: \n"+currentPosition);
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    tvLocation.setText(bdLocation.getStreet());
                }
            });
            requestWeather(longitude+"",latitude+"");
        }

        @Override
        public void onConnectHotSpotMessage(String s, int i) {

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 1:
                if (grantResults.length>0){
                    for (int result: grantResults){
                        if (result!=PackageManager.PERMISSION_GRANTED){
                            Toast.makeText(this, "同意定位权限才能获取当地的天气哦", Toast.LENGTH_SHORT).show();
                        }
                    }
                    DebugUtil.debug("成功获取权限");
                    requestLocation();
                }else{
                    Toast.makeText(this, "发生未知错误", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    private void requestWeather(String longitude,String latitude){
        HttpUtils.getInstance().getCaiRealTimeWeather(longitude + "", latitude + "", new Subscriber<CaiRealTimeBean>() {

            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(CaiRealTimeBean caiRealTimeBean) {
                CaiRealTimeBean.ResultBean result =caiRealTimeBean.getResult();
                DebugUtil.debug("onNext: 获取到数据了\n"+caiRealTimeBean.toString());
                tv_template.setText((int)result.getTemperature()+"");
                tv_skycon.setText(result.getSkycon());
            }

        });
    }
}
