package com.guowei.draw.simpleweather.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baidu.location.BDLocation;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.guowei.draw.simpleweather.R;
import com.guowei.draw.simpleweather.adapter.DailyAdapter;
import com.guowei.draw.simpleweather.adapter.HourlyAdapter;
import com.guowei.draw.simpleweather.base.BaseFragment;
import com.guowei.draw.simpleweather.bean.CaiForecastBean;
import com.guowei.draw.simpleweather.bean.HefengSearchBean;
import com.guowei.draw.simpleweather.bean.HefengSuggestionBean;
import com.guowei.draw.simpleweather.bean.YoudaoBean;
import com.guowei.draw.simpleweather.utils.AdsDialogUtil;
import com.guowei.draw.simpleweather.utils.DebugUtil;
import com.guowei.draw.simpleweather.utils.HttpUtils;
import com.guowei.draw.simpleweather.utils.ImageLoadUtil;
import com.guowei.draw.simpleweather.utils.LanguageUtil;
import com.guowei.draw.simpleweather.utils.ResourcesUtil;
import com.guowei.draw.simpleweather.utils.TransformUtils;
import com.guowei.draw.simpleweather.utils.YoudaoUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Subscriber;
import rx.functions.Action1;


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
    //生活建议
    @BindView(R.id.suggestion_contain)
    LinearLayout suggestionContain;
    @BindView(R.id.comfort)
    TextView comfort;
    @BindView(R.id.comfort_text)
    TextView comfortText;
    @BindView(R.id.clothing)
    TextView clothing;
    @BindView(R.id.clothing_text)
    TextView clothingText;
    @BindView(R.id.ultraviolet)
    TextView ultraviolet;
    @BindView(R.id.ultraviolet_text)
    TextView ultravioletText;
    @BindView(R.id.sports)
    TextView sports;
    @BindView(R.id.sports_text)
    TextView sportsText;
    @BindView(R.id.cold)
    TextView cold;
    @BindView(R.id.cold_text)
    TextView coldText;
    @BindView(R.id.travel)
    TextView travel;
    @BindView(R.id.travel_text)
    TextView travelText;
    @BindView(R.id.car_wash)
    TextView carwash;
    @BindView(R.id.car_wash_text)
    TextView carwashText;
    @BindView(R.id.suggestion_card)
    CardView suggestionCard;
    @BindView(R.id.skycon_card)
    CardView skyconCard;
    @BindView(R.id.adView1)
    AdView adView1;
    @BindView(R.id.adView2)
    AdView adView2;
    @BindView(R.id.adView3)
    AdView adView3;

    private View view;
    private Bundle arguments;
    public BDLocation location;

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
        //加载广告
        AdsDialogUtil.setBannerAds(adView1);
        AdsDialogUtil.setBannerAds(adView2);
        AdsDialogUtil.setBannerAds(adView3);
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
        skyconCard.setVisibility(View.VISIBLE);
        suggestionCard.setVisibility(View.VISIBLE);
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
        template.setText(String.format(TransformUtils.transformTemp((int) Math.round(todayTempAvg))));
        tempMax.setText(String.format("↑ "+TransformUtils.transformTemp((int) Math.round(todayTempMax))));
        tempMin.setText(String.format("↓ "+TransformUtils.transformTemp((int) Math.round(todayTempMin))));
        ImageLoadUtil.displayPicFromLocation(TransformUtils.transformIcon(todaySkycon),skyconIcon);
        tv_pm25.setText("PM 2.5: "+pm25+"μg/m³");
        tv_aqi.setText(ResourcesUtil.getString(R.string.air_quality)+" : "+TransformUtils.transformAQI(aqi));
        //第二个卡片---未来4小时的预报
        HourlyAdapter hourlyAdapter = new HourlyAdapter(forecastBean.getResult().getHourly());
        rcHourly.setAdapter(hourlyAdapter);
        rcHourly.setLayoutManager(new LinearLayoutManager(getContext()));
        //第三个卡片---未来5天的预报
        DailyAdapter dailyAdapter=new DailyAdapter(forecastBean.getResult().getDaily());
        rcDaily.setAdapter(dailyAdapter);
        rcDaily.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    protected void lazyLoad() {
        if (arguments.getBoolean("isLocal")){
            DebugUtil.debug("请求当地天气");
            //请求当地天气
            if (location!=null&&location.getCity()!=null){
                DebugUtil.debug("请求天气预报");
                requestForecast(location.getLongitude()+"",location.getLatitude()+"");
                DebugUtil.debug("请求生活建议");
                requestSuggestion();
            }
        }else{
            //请求城市经纬度
            DebugUtil.debug("当前不是当地天气");
        }
    }

    /**
     * 设置位置信息
     * @param local
     */
    public void setLocation(BDLocation local){
        this.location=local;
        refresh();
    }

    /**
     * 请求生活建议
     */
    public void requestSuggestion(){
        requestCity();
    }

    /**
     * 通过城市id请求生活建议
     * @param hefengCityId
     */
    private void requestSuggestionWithCity(String hefengCityId) {
        HttpUtils.getInstance().getHefengSuggestion(hefengCityId, new Subscriber<HefengSuggestionBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                DebugUtil.debug("获取生活建议错误："+e.toString());
            }

            @Override
            public void onNext(HefengSuggestionBean hefengSuggestionBean) {
                showSuggestion(hefengSuggestionBean);
            }
        });
    }

    private void showSuggestion(HefengSuggestionBean hefengSuggestionBean) {
        HefengSuggestionBean.HeWeather5Bean.SuggestionBean suggestions = hefengSuggestionBean.getHeWeather5().get(0).getSuggestion();
        if (LanguageUtil.isZh()) {
            comfort.setText(ResourcesUtil.getString(R.string.comfortable) + "   " + suggestions.getComf().getBrf());
            comfortText.setText(suggestions.getComf().getTxt());
            clothing.setText(ResourcesUtil.getString(R.string.clothing) + "   " + suggestions.getDrsg().getBrf());
            clothingText.setText(suggestions.getComf().getTxt());
            ultraviolet.setText(ResourcesUtil.getString(R.string.ultraviolet_rays) + "   " + suggestions.getUv().getBrf());
            ultravioletText.setText(suggestions.getUv().getTxt());
            sports.setText(ResourcesUtil.getString(R.string.sports) + "   " + suggestions.getSport().getBrf());
            sportsText.setText(suggestions.getSport().getTxt());
            cold.setText(ResourcesUtil.getString(R.string.cold) + "   " + suggestions.getFlu().getBrf());
            coldText.setText(suggestions.getFlu().getTxt());
            travel.setText(ResourcesUtil.getString(R.string.travel) + "   " + suggestions.getTrav().getBrf());
            travelText.setText(suggestions.getTrav().getTxt());
            carwash.setText(ResourcesUtil.getString(R.string.car_washing) + "   " + suggestions.getCw().getBrf());
            carwashText.setText(suggestions.getCw().getTxt());
        }else{
            YoudaoUtil.getFangyi(suggestions.getComf().getBrf(),comfort,ResourcesUtil.getString(R.string.comfortable) + "   ");
            YoudaoUtil.getFangyi(suggestions.getComf().getTxt(),comfortText,"");
            YoudaoUtil.getFangyi(suggestions.getDrsg().getBrf(),clothing,ResourcesUtil.getString(R.string.clothing) + "   ");
            YoudaoUtil.getFangyi(suggestions.getDrsg().getTxt(),clothingText,"");
            YoudaoUtil.getFangyi(suggestions.getUv().getBrf(),ultraviolet,ResourcesUtil.getString(R.string.ultraviolet_rays) + "   ");
            YoudaoUtil.getFangyi(suggestions.getUv().getTxt(),ultravioletText,"");
            YoudaoUtil.getFangyi(suggestions.getSport().getBrf(),sports,ResourcesUtil.getString(R.string.sports) + "   ");
            YoudaoUtil.getFangyi(suggestions.getSport().getTxt(),sportsText,"");
            YoudaoUtil.getFangyi(suggestions.getFlu().getBrf(),cold,ResourcesUtil.getString(R.string.cold) + "   ");
            YoudaoUtil.getFangyi(suggestions.getFlu().getTxt(),coldText,"");
            YoudaoUtil.getFangyi(suggestions.getTrav().getBrf(),travel,ResourcesUtil.getString(R.string.travel) + "   ");
            YoudaoUtil.getFangyi(suggestions.getTrav().getTxt(),travelText,"");
            YoudaoUtil.getFangyi(suggestions.getCw().getBrf(),carwash,ResourcesUtil.getString(R.string.car_washing) + "   ");
            YoudaoUtil.getFangyi(suggestions.getCw().getTxt(),carwashText,"");

        }
    }

    /**
     * 请求城市信息
     */
    public void requestCity(){
        String city = TransformUtils.transformCityName(location.getCity());
        HttpUtils.getInstance().getHefengCity(city, new Subscriber<HefengSearchBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                DebugUtil.debug("获取城市信息错误: "+e.toString());
            }

            @Override
            public void onNext(HefengSearchBean hefengSearchBean) {
                getCityId(hefengSearchBean);
            }
        });
    }

    /**
     * 获取城市id
     * @param hefengSearchBean
     */
    public void getCityId(HefengSearchBean hefengSearchBean){
        String hefengCityId=null;
        final String province = TransformUtils.transformCityName(location.getProvince());
        final String city = TransformUtils.transformCityName(location.getCity());
        final String country = location.getCountry();
        List<HefengSearchBean.HeWeather5Bean> citys = hefengSearchBean.getHeWeather5();
        if (citys.get(0).getStatus().equals("ok")){
            for (HefengSearchBean.HeWeather5Bean weatherCity:citys){
                HefengSearchBean.HeWeather5Bean.BasicBean cityInfo = weatherCity.getBasic();
                if (cityInfo.getProv().equals(province)&&cityInfo.getCnty().equals(country)){
                    hefengCityId=cityInfo.getId();
                }
            }
        }
        if (hefengCityId==null){
            suggestionContain.setVisibility(View.GONE);
        }else{
            requestSuggestionWithCity(hefengCityId);
            suggestionContain.setVisibility(View.VISIBLE);
        }
    }

    /**
     * 请求天气预报
     */
    public void requestForecast(String longitude,String latitude){
        DebugUtil.debug("zcj_http","requestForecast");
        HttpUtils.getInstance().getCaiForecast(longitude, latitude, new Subscriber<CaiForecastBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                DebugUtil.debug("获取天气预报错误: "+e.toString());
            }

            @Override
            public void onNext(CaiForecastBean forecastBean) {
                showCardData(forecastBean);
            }
        });
    }

    /**
     * 刷新
     */
    public void refresh(){
        lazyLoad();
    }
}
