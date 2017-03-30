package com.guowei.draw.simpleweather.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.RemoteViews;


import com.guowei.draw.simpleweather.C;
import com.guowei.draw.simpleweather.activity.MainActivity;
import com.guowei.draw.simpleweather.R;
import com.guowei.draw.simpleweather.bean.CaiRealTimeBean;
import com.guowei.draw.simpleweather.utils.DebugUtil;
import com.guowei.draw.simpleweather.utils.DrawUtils;
import com.guowei.draw.simpleweather.utils.LiveUtil;
import com.guowei.draw.simpleweather.utils.WeatherUtil;


public class MyWidgetProvider extends AppWidgetProvider {
    String TAG = "zcj";

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);
        Log.i(TAG, "onUpdate: ");
        if (!LiveUtil.isServiceRunning(LiveUtil.clockservice)) {
            context.startService(new Intent(context, ClockService.class));
        }else {
            //发送更新widget天气广播
            Intent updateWeatherIntent = new Intent(C.UPDATE_WEATHER);
            updateWeatherIntent.putExtra(C.UPDATE_WEATHER_FORM, C.UPDATE_WEATHER_FORM_INTERNET);
            context.sendBroadcast(updateWeatherIntent);
        }
        Intent mainActivityIntent = new Intent(context, MainActivity.class);
        PendingIntent pending = PendingIntent.getActivity(context, 0, mainActivityIntent, 0);
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.layout_widget);
        remoteViews.setOnClickPendingIntent(R.id.widget_root, pending);
        AppWidgetManager widgetManager = AppWidgetManager.getInstance(context);
        widgetManager.updateAppWidget(appWidgetIds[0], remoteViews);
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

    }

    @Override
    public void onDisabled(Context context) {
        super.onDisabled(context);
        Log.i(TAG, "onDisabled: ");
        context.stopService(new Intent(context, ClockService.class));
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action.equals(C.UPDATE_CLOCK)) {
//            DebugUtil.debug("收到广播");
//            sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            String time = sdf.format(new Date());
//            RemoteViews remoteViews=new RemoteViews(context.getPackageName(),R.layout.layout_widget);
//            remoteViews.setTextViewText(R.id.widget_text,time);
//            ComponentName componentName = new ComponentName(context, MyWidgetProvider.class);
//            AppWidgetManager.getInstance(context).updateAppWidget(componentName,remoteViews);
            DrawUtils drawUtils = new DrawUtils();
            drawUtils.updateClock();
            drawUtils = null;
        } else if (action.equals(C.UPDATE_WEATHER)) {
            String updateForm = intent.getStringExtra(C.UPDATE_WEATHER_FORM);


                DebugUtil.debug("收到更新天气广播");
                WeatherUtil weatherUtil = new WeatherUtil();
            if (updateForm.equals(C.UPDATE_WEATHER_FORM_INTERNET)) {
                weatherUtil.update();

            }else if (updateForm.equals(C.UPDATE_WEATHER_FORM_ACTIVITY)){
                DebugUtil.debug("更新widget天气formActivity");
                weatherUtil.updateWidget((CaiRealTimeBean) intent.getSerializableExtra(C.REALTIME_DATA));
            }
//            weatherUtil=null;
        }
        super.onReceive(context, intent);
    }

}
