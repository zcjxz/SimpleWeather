package com.guowei.draw.simpleweather.widget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;


import com.guowei.draw.simpleweather.C;
import com.guowei.draw.simpleweather.utils.DebugUtil;
import com.guowei.draw.simpleweather.utils.DrawUtils;
import com.guowei.draw.simpleweather.utils.WeatherUtil;


public class MyWidgetProvider extends AppWidgetProvider{
    String TAG="zcj";
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);
        Log.i(TAG, "onUpdate: ");
    }

    @Override
    public void onAppWidgetOptionsChanged(Context context, AppWidgetManager appWidgetManager, int appWidgetId, Bundle newOptions) {
        super.onAppWidgetOptionsChanged(context, appWidgetManager, appWidgetId, newOptions);
        Log.i(TAG, "onAppWidgetOptionsChanged: ");
    }

    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {
        super.onDeleted(context, appWidgetIds);
        Log.i(TAG, "onDeleted: ");
    }

    @Override
    public void onEnabled(Context context) {
        super.onEnabled(context);
        DebugUtil.debug("onEnabled----");
        Log.i(TAG, "onEnabled: ");
        context.startService(new Intent(context,ClockService.class));
        context.startService(new Intent(context,WeatherService.class));
    }

    @Override
    public void onDisabled(Context context) {
        super.onDisabled(context);
        Log.i(TAG, "onDisabled: ");
        context.stopService(new Intent(context,ClockService.class));
        context.stopService(new Intent(context,WeatherService.class));
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action.equals(C.UPDATE_CLOCK)){
//            DebugUtil.debug("收到广播");
//            sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            String time = sdf.format(new Date());
//            RemoteViews remoteViews=new RemoteViews(context.getPackageName(),R.layout.layout_widget);
//            remoteViews.setTextViewText(R.id.widget_text,time);
//            ComponentName componentName = new ComponentName(context, MyWidgetProvider.class);
//            AppWidgetManager.getInstance(context).updateAppWidget(componentName,remoteViews);
            DrawUtils drawUtils = new DrawUtils();
            drawUtils.updateClock();
            drawUtils=null;
        }else if (action.equals(C.UPDATE_WEATHER)){
            DebugUtil.debug("收到更新天气广播");
            WeatherUtil weatherUtil = new WeatherUtil();
            weatherUtil.updateWeather();
            weatherUtil=null;
        }
        super.onReceive(context, intent);
    }
}
