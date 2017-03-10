package com.guowei.draw.simpleweather;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.guowei.draw.simpleweather.adapter.WeatherPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private CollapsingToolbarLayoutState state;

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        collapsingToolbarLayout.setTitle("");
        setSupportActionBar(toolbar);
        //不显示标题
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        viewPager.setAdapter(new WeatherPagerAdapter(this));
        setAppBarListener();
        Glide.with(this).load(R.drawable.bg).into(ivBg);
        titleMenu.setOnClickListener(this);
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
}
