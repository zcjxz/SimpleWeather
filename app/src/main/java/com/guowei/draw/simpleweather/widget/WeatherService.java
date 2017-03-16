package com.guowei.draw.simpleweather.widget;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.guowei.draw.simpleweather.C;

import java.util.Timer;
import java.util.TimerTask;

public class WeatherService extends Service{

    private Timer timer;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                sendBroadcast(new Intent(C.UPDATE_WEATHER));
            }
        },0,1000*60*30);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (timer!=null){
            timer.cancel();
            timer=null;
        }
    }
}
