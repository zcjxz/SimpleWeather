package com.guowei.draw.simpleweather.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.guowei.draw.simpleweather.R;
import com.guowei.draw.simpleweather.adapter.DailyAdapter;
import com.guowei.draw.simpleweather.adapter.HourlyAdapter;
import com.guowei.draw.simpleweather.base.BaseFragment;
import com.guowei.draw.simpleweather.bean.CaiForecastBean;
import com.guowei.draw.simpleweather.bean.CaiRealTimeBean;
import com.guowei.draw.simpleweather.utils.DebugUtil;
import com.guowei.draw.simpleweather.utils.HttpUtils;
import com.guowei.draw.simpleweather.utils.ImageLoadUtil;
import com.guowei.draw.simpleweather.utils.TransformUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Subscriber;


public class WeatherFragment extends BaseFragment{

    //卡片里的天气概况
    @BindView(R.id.temp_max)
    TextView tempMax;
    @BindView(R.id.temp_min)
    TextView tempMin;
    @BindView(R.id.template)
    TextView template;
    @BindView(R.id.skyconIcon)
    ImageView skyconIcon;
    @BindView(R.id.pm25)
    TextView tv_pm25;
    @BindView(R.id.aqi)
    TextView tv_aqi;
    @BindView(R.id.rc_hourly)
    RecyclerView rcHourly;
    @BindView(R.id.rc_daily)
    RecyclerView rcDaily;
    private View view;
    private Bundle arguments;
    public String longitude;
    public String latitude;

    public WeatherFragment(){
        super();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        arguments = getArguments();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        isPrepared=true;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.layout_weather, container, false);
        ButterKnife.bind(this,view);
        return view;
    }
    /**
     * 显示cardview数据
     * @param forecastBean
     */
    private void showCardData(CaiForecastBean forecastBean){
        DebugUtil.debug("开始加载数据");
        //第一个卡片
        CaiForecastBean.ResultBean result = forecastBean.getResult();
        CaiForecastBean.ResultBean.DailyBean daily = result.getDaily();
        CaiForecastBean.ResultBean.DailyBean.TemperatureBeanX todayTemp = daily.getTemperature().get(0);
        String todaySkycon = daily.getSkycon().get(0).getValue();
        double pm25 = daily.getPm25().get(0).getAvg();
        double aqi = daily.getAqi().get(0).getAvg();
        double todayTempAvg = todayTemp.getAvg();
        double todayTempMax = todayTemp.getMax();
        double todayTempMin = todayTemp.getMin();
        template.setText(String.format("%s℃",Math.round(todayTempAvg)));
        tempMax.setText(String.format("↑ %s ℃",Math.round(todayTempMax)));
        tempMin.setText(String.format("↓ %s ℃",Math.round(todayTempMin)));
        ImageLoadUtil.displayPicFromLocation(TransformUtils.transformIcon(todaySkycon),skyconIcon);
        tv_pm25.setText("PM 2.5: "+pm25+"μg/m³");
        tv_aqi.setText("空气质量: "+TransformUtils.transformAQI(aqi));
        //第二个卡片---未来4小时的预报
        HourlyAdapter hourlyAdapter = new HourlyAdapter(forecastBean.getResult().getHourly());
        rcHourly.setAdapter(hourlyAdapter);
        rcHourly.setLayoutManager(new LinearLayoutManager(getContext()));
        //第三个卡片---未来5天的预报
        DailyAdapter dailyAdapter=new DailyAdapter(forecastBean.getResult().getDaily());
        rcDaily.setAdapter(dailyAdapter);
        rcDaily.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    public void setLocation(String longitude,String latitude){
        DebugUtil.debug("设置local");
        this.longitude=longitude;
        this.latitude=latitude;
        refresh();
    }

    @Override
    protected void lazyLoad() {
        DebugUtil.debug("lazyload");
        if (arguments.getBoolean("isLocal")){
            //请求当地天气
            if (longitude!=null&latitude!=null){
                requestForecast(longitude,latitude);
            }
        }else{
            //请求城市经纬度
        }
    }
    //请求天气预报
    public void requestForecast(String longitude,String latitude){
        DebugUtil.debug("正在发送天气预报请求");
        HttpUtils.getInstance().getCaiForecast(longitude, latitude, new Subscriber<CaiForecastBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                DebugUtil.debug("onError: "+e.toString());
            }

            @Override
            public void onNext(CaiForecastBean forecastBean) {
                showCardData(forecastBean);
                DebugUtil.debug("onNext: 获取到数据了\n"+forecastBean.toString());
            }
        });
    }

    public void refresh(){
        lazyLoad();
    }
}
