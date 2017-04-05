package com.guowei.draw.simpleweather.utils;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
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
    private SimpleDateFormat sdfS;
    private Date date;
    private Paint pointPaint;
    private SimpleDateFormat sdfE;
    private final SimpleDateFormat sdfH;
    //画温度的paint
    private Paint tempPaint;
    //根号3的近似值
    private float radical3=1.732f;
    //温度角标的边长
    private int indicateLine=5;
    //温度角标和表盘的间距
    private int indicateMargin=3;
    private final Paint indicatePaint;

    public DrawUtils(){
        application = WeatherApplication.getApplication();
        paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(strokeWidth);
        paint.setAntiAlias(true);
        //把时间格式化成秒
        sdfS = new SimpleDateFormat("ss");
        //把时间格式化成星期
        sdfE = new SimpleDateFormat("EEE");
        //把时间格式化成小时，分钟
        sdfH = new SimpleDateFormat("HH:mm");
        date = new Date();
        mWidth =weightPx*9 +3*strokeWidth;
        mHeight = weightPx*6+2*strokeWidth;

        pointPaint = new Paint();
        pointPaint.setColor(Color.WHITE);
        pointPaint.setAntiAlias(true);
        pointPaint.setStrokeWidth(2);

        tempPaint=new Paint();
        tempPaint.setColor(WeatherApplication.getApplication().getResources().getColor(R.color.colorBlue));
        tempPaint.setStrokeCap(Paint.Cap.ROUND);
        tempPaint.setStyle(Paint.Style.STROKE);
        tempPaint.setStrokeWidth(strokeWidth);
        tempPaint.setAntiAlias(true);

        indicatePaint = new Paint();
        indicatePaint.setColor(WeatherApplication.getApplication().getResources().getColor(R.color.colorBlue));
        indicatePaint.setStrokeWidth(5);
        indicatePaint.setAntiAlias(true);
    }

    public void updateClock(){
//        init();
        drawClock();
    }

    private void drawClock() {
        widgetManager = AppWidgetManager.getInstance(application);
        remoteViews = new RemoteViews(application.getPackageName(), R.layout.layout_widget);
        componentName = new ComponentName(application, MyWidgetProvider.class);
        String eFormat = sdfE.format(date);
        String hourFormat = sdfH.format(date);
        String secondFormat = sdfS.format(date);
        int second = Integer.parseInt(secondFormat);
        Bitmap bitmap = Bitmap.createBitmap(mWidth, mHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        //画大圆
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
        //画温度
        int temp = SpUtil.getInt("local", "temp",0);
        if (temp>=30){
            tempPaint.setColor(WeatherApplication.getApplication().getResources().getColor(R.color.colorRed));
        }else{
            tempPaint.setColor(WeatherApplication.getApplication().getResources().getColor(R.color.colorBlue));
        }
        int arc=180/45*temp;
        canvas.drawArc(smalRectF,120,arc,false,tempPaint);
        //画温度角标
        canvas.save();
        canvas.rotate(-150,weightPx*2+strokeWidth,4*weightPx+strokeWidth);
        canvas.rotate(arc,weightPx*2+strokeWidth,4*weightPx+strokeWidth);
        Path tempPath=new Path();
        tempPath.moveTo(weightPx*2+strokeWidth,weightPx*2+strokeWidth+DensityUtil.dip2px(indicateMargin));
        tempPath.lineTo(weightPx*2-DensityUtil.dip2px(0.5f*indicateLine)+strokeWidth,weightPx*2+strokeWidth+DensityUtil.dip2px(indicateMargin)+DensityUtil.dip2px(radical3*indicateLine));
        tempPath.lineTo(weightPx*2+DensityUtil.dip2px(0.5f*indicateLine)+strokeWidth,weightPx*2+strokeWidth+DensityUtil.dip2px(indicateMargin)+DensityUtil.dip2px(radical3*indicateLine));
        tempPath.close();
        canvas.drawPath(tempPath,indicatePaint);
        canvas.restore();
        canvas.save();
        canvas.rotate(6*second,6*weightPx+2*strokeWidth,3*weightPx+strokeWidth);
        //画小点
        canvas.drawCircle(6*weightPx+2*strokeWidth,strokeWidth+DensityUtil.dip2px(10),5,pointPaint);
        canvas.restore();
        remoteViews.setTextViewText(R.id.widget_time,eFormat+"\n"+hourFormat);
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
