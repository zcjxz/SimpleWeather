package com.guowei.draw.simpleweather.widget;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.RemoteViews;

import com.guowei.draw.simpleweather.C;
import com.guowei.draw.simpleweather.R;
import com.guowei.draw.simpleweather.WeatherApplication;
import com.guowei.draw.simpleweather.activity.MainActivity;
import com.guowei.draw.simpleweather.utils.DebugUtil;

import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;


public class ClockService extends Service {

    private Timer clockTimer;
    private Timer weatherTimer;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (clockTimer != null) {
            clockTimer.cancel();
            clockTimer = null;
        }
        if (weatherTimer != null) {
            weatherTimer.cancel();
            weatherTimer = null;
        }
        clockTimer = new Timer();
        clockTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                updateClock();
            }
        }, 0, 1000);
        weatherTimer = new Timer();
        weatherTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                updateWeather();
            }
        }, 0, 1000 * 60 * 30);
        DebugUtil.debug("启动 ClockService。。");
        RemoteViews remoteViews = new RemoteViews(this.getPackageName(), R.layout.layout_notification);
        //开启常驻通知
        NotificationCompat.Builder builder = new NotificationCompat.Builder(WeatherApplication.getApplication());
        builder.setSmallIcon(R.mipmap.ic_launcher);
        Intent mainActivityIntent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,
                0, mainActivityIntent, 0);
        builder.setContentIntent(pendingIntent);
        builder.setCustomContentView(remoteViews);
//        builder.setCustomBigContentView(remoteViews);
        Notification notification = builder.build();
        startForeground(C.NOTIFICATION_ID, notification);
//        if (Build.VERSION.SDK_INT<18){
//            startForeground(SERVICE_ID,notification);
//        }else{
//            startForeground(SERVICE_ID,notification);
//            Intent innerIntent =new Intent(this,GrayInnerService.class);
//            startService(innerIntent);
//        }
        return Service.START_STICKY;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    private void updateWeather() {
        DebugUtil.debug("发送更新天气广播");
        sendBroadcast(new Intent(C.UPDATE_WEATHER));
    }

    /**
     * 给 API >= 18 的平台上用灰色保活手段
     */
    public static class GrayInnerService extends Service {

        @Nullable
        @Override
        public IBinder onBind(Intent intent) {
            return null;
        }

        @Override
        public int onStartCommand(Intent intent, int flags, int startId) {
            startForeground(C.NOTIFICATION_ID, new Notification());
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
        if (clockTimer != null) {
            clockTimer.cancel();
            clockTimer = null;
        }
        if (weatherTimer != null) {
            weatherTimer.cancel();
            weatherTimer = null;
        }
        DebugUtil.debug("stop ClockService");
    }
}
