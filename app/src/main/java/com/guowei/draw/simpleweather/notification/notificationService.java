package com.guowei.draw.simpleweather.notification;


import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.widget.RemoteViews;

import com.guowei.draw.simpleweather.C;
import com.guowei.draw.simpleweather.R;
import com.guowei.draw.simpleweather.WeatherApplication;
import com.guowei.draw.simpleweather.activity.MainActivity;
import com.guowei.draw.simpleweather.bean.CaiRealTimeBean;
import com.guowei.draw.simpleweather.utils.DebugUtil;
import com.guowei.draw.simpleweather.utils.HttpUtils;
import com.guowei.draw.simpleweather.utils.ResourcesUtil;
import com.guowei.draw.simpleweather.utils.SpUtil;
import com.guowei.draw.simpleweather.utils.TransformUtils;

import java.util.Timer;
import java.util.TimerTask;

import rx.Subscriber;

public class NotificationService extends Service{

    private WeatherApplication application;
    private Timer weatherTimer;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (weatherTimer!=null){
            weatherTimer.cancel();
            weatherTimer=null;
        }
        weatherTimer = new Timer();
        weatherTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                update();
            }
        }, 0, 1000 * 60 * 30);
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
        return Service.START_STICKY;
    }
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
                updateNotification(realTimeBean);
            }
        });

    }
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
        remoteViews.setTextViewText(R.id.notification_aqi, ResourcesUtil.getString(R.string.air_quality)+" : "+aqi);
        remoteViews.setTextViewText(R.id.notification_wind,direction+"   "+speed);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(WeatherApplication.getApplication());
        builder.setSmallIcon(R.mipmap.ic_launcher);
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
