package com.guowei.draw.simpleweather.utils;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.widget.RemoteViews;

import com.guowei.draw.simpleweather.R;
import com.guowei.draw.simpleweather.WeatherApplication;
import com.guowei.draw.simpleweather.widget.MyWidgetProvider;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DrawUtils {

    private RemoteViews remoteViews;
    private AppWidgetManager widgetManager;
    private ComponentName componentName;
    private WeatherApplication application;
    private int strokeWidth=5;
    public int weight=25;
    public int weightPx=DensityUtil.dip2px(weight);
    public int mWidth=weight*9;
    public int mHeight=weight*6;
    private Paint paint;
    private SimpleDateFormat sdf;
    private Date date;
    private Paint pointPaint;

    public DrawUtils(){
        paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setAntiAlias(true);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(strokeWidth);
        paint.setAntiAlias(true);
        sdf = new SimpleDateFormat("ss");
        date = new Date();
        mWidth =weightPx*9 +3*strokeWidth;
        mHeight = weightPx*6+2*strokeWidth;

        pointPaint = new Paint();
        pointPaint.setColor(Color.WHITE);
        pointPaint.setAntiAlias(true);
        pointPaint.setStrokeWidth(2);
    }

    public void updateClock(){
//        init();
        drawClock();
    }

    private void drawClock() {
        application = WeatherApplication.getApplication();
        widgetManager = AppWidgetManager.getInstance(application);
        remoteViews = new RemoteViews(application.getPackageName(), R.layout.layout_widget);
        componentName = new ComponentName(application, MyWidgetProvider.class);
        String time = sdf.format(date);
        int second = Integer.parseInt(time);
        Bitmap bitmap = Bitmap.createBitmap(mWidth, mHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        RectF bigRectF=new RectF(mWidth-6*weightPx-2*strokeWidth,
                strokeWidth,
                mWidth-strokeWidth,
                mHeight-strokeWidth);
        canvas.drawArc(bigRectF,120,300,false,paint);
        //画小圆
        RectF smalRectF=new RectF(strokeWidth,
                2*weightPx,
                4*weightPx+strokeWidth,
                mHeight-strokeWidth);
        canvas.drawArc(smalRectF,120,180,false,paint);
        canvas.save();
//        canvas.translate(6*weightPx+2*strokeWidth,3*weightPx+strokeWidth);
        canvas.rotate(6*second,6*weightPx+2*strokeWidth,3*weightPx+strokeWidth);

        canvas.drawCircle(6*weightPx+2*strokeWidth,strokeWidth+DensityUtil.dip2px(10),5,pointPaint);
        canvas.restore();
        remoteViews.setImageViewBitmap(R.id.clockImg, bitmap);
        widgetManager.updateAppWidget(componentName,remoteViews);
        canvas=null;
        bitmap=null;
    }

    private void init(){
        if (application==null){
            application = WeatherApplication.getApplication();
        }
        if (widgetManager==null){
            widgetManager = AppWidgetManager.getInstance(application);
        }
        if (remoteViews==null){
            remoteViews = new RemoteViews(application.getPackageName(), R.layout.layout_widget);
        }
        if (componentName==null){
            componentName = new ComponentName(application, MyWidgetProvider.class);
        }

    }
}
