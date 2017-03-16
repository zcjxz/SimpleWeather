package com.guowei.draw.simpleweather.widget;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.guowei.draw.simpleweather.C;
import com.guowei.draw.simpleweather.utils.DebugUtil;
import com.guowei.draw.simpleweather.utils.DrawUtils;

import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;

public class ClockService extends Service{

    private Timer timer;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("zcj", "Service onCreate");
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                updateClock();
            }
        },0,1000);
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
        if (timer!=null){
            timer.cancel();
            timer=null;
        }
        Log.i("zcj", "onDestroy: --------");
    }
}
