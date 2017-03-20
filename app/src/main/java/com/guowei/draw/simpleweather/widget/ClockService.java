package com.guowei.draw.simpleweather.widget;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.guowei.draw.simpleweather.C;
import com.guowei.draw.simpleweather.utils.DebugUtil;

import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;

public class ClockService extends Service{

    private Timer clockTimer;
    private Timer weatherTimer;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private final static int SERVICE_ID=135;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        clockTimer = new Timer();
        clockTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                updateClock();
            }
        },0,1000);
        weatherTimer = new Timer();
        weatherTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                updateWeather();
            }
        },0,1000*60*30);
        DebugUtil.debug("启动 ClockService。。");
        if (Build.VERSION.SDK_INT<18){
            startForeground(SERVICE_ID,new Notification());
        }else{
            startForeground(SERVICE_ID,new Notification());
            Intent innerIntent =new Intent(this,GrayInnerService.class);
            startService(innerIntent);
        }
        return Service.START_STICKY;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    private void updateWeather(){
        DebugUtil.debug("发送更新天气广播");
        sendBroadcast(new Intent(C.UPDATE_WEATHER));
    }

    /**
     * 给 API >= 18 的平台上用灰色保活手段
     */
    public static class GrayInnerService extends Service{

        @Nullable
        @Override
        public IBinder onBind(Intent intent) {
            return null;
        }

        @Override
        public int onStartCommand(Intent intent, int flags, int startId) {
            startForeground(SERVICE_ID,new Notification());
            stopForeground(true);
            stopSelf();
            return super.onStartCommand(intent, flags, startId);
        }
    }

    private void updateClock() {
//        String time = sdf.format(new Date());
//        RemoteViews remoteViews=new RemoteViews(getPackageName(),R.layout.layout_widget);
//        remoteViews.setTextViewText(R.id.widget_text,time);
//        AppWidgetManager widgetManager = AppWidgetManager.getInstance(getApplication());
//        widgetManager.updateAppWidget(new ComponentName(getApplication(),MyWidgetProvider.class),remoteViews);
//        DebugUtil.debug("发送广播----");
        this.sendBroadcast(new Intent(C.UPDATE_CLOCK));
//        Log.i("zcj", "updateClock");
//        drawUtils.updateClock();
//        new DrawUtils().updateClock();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (clockTimer !=null){
            clockTimer.cancel();
            clockTimer =null;
        }
        if (weatherTimer !=null){
            weatherTimer.cancel();
            weatherTimer =null;
        }
        DebugUtil.debug("stop ClockService");
    }
}
