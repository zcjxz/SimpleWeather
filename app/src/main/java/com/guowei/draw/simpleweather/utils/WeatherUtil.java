package com.guowei.draw.simpleweather.utils;


import android.app.Notification;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.widget.RemoteViews;

import com.guowei.draw.simpleweather.C;
import com.guowei.draw.simpleweather.R;
import com.guowei.draw.simpleweather.WeatherApplication;
import com.guowei.draw.simpleweather.activity.MainActivity;
import com.guowei.draw.simpleweather.bean.CaiForecastBean;
import com.guowei.draw.simpleweather.bean.CaiRealTimeBean;
import com.guowei.draw.simpleweather.widget.MyWidgetProvider;

import rx.Subscriber;

public class WeatherUtil {
    WeatherApplication application;

    public void update(){
        DebugUtil.debug("update------------");
        application = WeatherApplication.getApplication();
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
                updateWidget(realTimeBean);
                updateNotification(realTimeBean);
            }
        });

    }
    public void updateWidget(CaiRealTimeBean realTimeBean) {
         RemoteViews remoteViews;
         AppWidgetManager widgetManager;
         ComponentName componentName;
        widgetManager = AppWidgetManager.getInstance(application);
        remoteViews = new RemoteViews(application.getPackageName(), R.layout.layout_widget);
        componentName = new ComponentName(application, MyWidgetProvider.class);
        CaiRealTimeBean.ResultBean result = realTimeBean.getResult();
        remoteViews.setTextViewText(R.id.widget_temp,Math.round(result.getTemperature())+"℃");
        SpUtil.postInt(C.SP_NAME,C.KEY_TEMP, (int) result.getTemperature());
        remoteViews.setTextViewText(R.id.widget_wind,TransformUtils.transformSpeed(result.getWind().getSpeed()));
        remoteViews.setImageViewResource(R.id.widget_skycon,TransformUtils.transformIcon(result.getSkycon()));
        widgetManager.updateAppWidget(componentName,remoteViews);
    }

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

    public void updateNotification(CaiRealTimeBean realTime){
        NotificationManagerCompat manager=NotificationManagerCompat.from(application);
        CaiRealTimeBean.ResultBean result = realTime.getResult();
        int temp = Math.round(result.getTemperature());
        String skycon = TransformUtils.transformSkycon(result.getSkycon());
        int icon = TransformUtils.transformIcon(result.getSkycon());
        String aqi = TransformUtils.transformAQI(result.getAqi());
        String speed = TransformUtils.transformSpeed(result.getWind().getSpeed());
        String direction = TransformUtils.transformDirection(result.getWind().getDirection());
        RemoteViews remoteViews = new RemoteViews(application.getPackageName(), R.layout.layout_notification);
        remoteViews.setTextViewText(R.id.notification_temp,temp+C.DU);
        remoteViews.setImageViewResource(R.id.notification_icon,icon);
        remoteViews.setTextViewText(R.id.notification_skycon,skycon);
        remoteViews.setTextViewText(R.id.notification_aqi,"空气质量："+aqi);
        remoteViews.setTextViewText(R.id.notification_wind,direction+"   "+speed);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(WeatherApplication.getApplication());
        builder.setSmallIcon(R.drawable.clear_day);
        Intent mainActivityIntent = new Intent(application, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(application,
                0, mainActivityIntent, 0);
        builder.setContentIntent(pendingIntent);
        builder.setCustomContentView(remoteViews);
//        builder.setCustomBigContentView(remoteViews);
        Notification notification = builder.build();
        manager.notify(C.NOTIFICATION_ID,notification);
    }
}
