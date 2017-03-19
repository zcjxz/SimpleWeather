package com.guowei.draw.simpleweather.widget;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.guowei.draw.simpleweather.WeatherApplication;
import com.guowei.draw.simpleweather.utils.DebugUtil;
import com.guowei.draw.simpleweather.utils.LiveUtil;

public class LiveReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        DebugUtil.debug("收到激活广播==========");
        boolean isRunning = LiveUtil.isServiceRunning(LiveUtil.clockservice);
        if (!isRunning){
            WeatherApplication application = WeatherApplication.getApplication();
            Intent clockIntent=new Intent(application,ClockService.class);
            application.startService(clockIntent);
        }
    }
}
