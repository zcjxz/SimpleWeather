package com.guowei.draw.simpleweather.utils;


import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.widget.RemoteViews;

import com.guowei.draw.simpleweather.C;
import com.guowei.draw.simpleweather.R;
import com.guowei.draw.simpleweather.WeatherApplication;
import com.guowei.draw.simpleweather.bean.CaiForecastBean;
import com.guowei.draw.simpleweather.bean.CaiRealTimeBean;
import com.guowei.draw.simpleweather.widget.MyWidgetProvider;

import rx.Subscriber;

public class WeatherUtil {
    private RemoteViews remoteViews;
    private AppWidgetManager widgetManager;
    private ComponentName componentName;
    private WeatherApplication application;

    public void updateWeather(){
        DebugUtil.debug("updateWeather------------");
        application = WeatherApplication.getApplication();
        widgetManager = AppWidgetManager.getInstance(application);
        remoteViews = new RemoteViews(application.getPackageName(), R.layout.layout_widget);
        componentName = new ComponentName(application, MyWidgetProvider.class);
        String longitude = SpUtil.getString(C.SP_NAME,C.KEY_LONGITUDE, "");
        String latitude = SpUtil.getString(C.SP_NAME,C.KEY_LATITUDE,"");
        DebugUtil.debug("获取sp\n longitude = "+longitude+"\n"+ "latitude = "+latitude);
        HttpUtils.getInstance().getCaiRealTimeWeather(longitude, latitude, new Subscriber<CaiRealTimeBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(CaiRealTimeBean realTimeBean) {
                CaiRealTimeBean.ResultBean result = realTimeBean.getResult();
                remoteViews.setTextViewText(R.id.widget_temp,Math.round(result.getTemperature())+"℃");
                SpUtil.postInt(C.SP_NAME,C.KEY_TEMP, (int) result.getTemperature());
                remoteViews.setTextViewText(R.id.widget_wind,TransformUtils.transformSpeed(result.getWind().getSpeed()));
                remoteViews.setImageViewResource(R.id.widget_skycon,TransformUtils.transformIcon(result.getSkycon()));
                widgetManager.updateAppWidget(componentName,remoteViews);
            }
        });
//        HttpUtils.getInstance().getCaiForecast(longitude, latitude, new Subscriber<CaiForecastBean>() {
//            @Override
//            public void onCompleted() {
//
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onNext(CaiForecastBean caiForecastBean) {
//                CaiForecastBean.ResultBean result = caiForecastBean.getResult();
//                CaiForecastBean.ResultBean.DailyBean daily = result.getDaily();
//                remoteViews.setImageViewResource(R.id.widget_one_skycon,TransformUtils.transformIcon(daily.getSkycon().get(1).getValue()));
//                remoteViews.setImageViewResource(R.id.widget_two_skycon,TransformUtils.transformIcon(daily.getSkycon().get(2).getValue()));
//                remoteViews.setImageViewResource(R.id.widget_three_skycon,TransformUtils.transformIcon(daily.getSkycon().get(3).getValue()));
//                widgetManager.updateAppWidget(componentName,remoteViews);
//            }
//        });

    }
}
