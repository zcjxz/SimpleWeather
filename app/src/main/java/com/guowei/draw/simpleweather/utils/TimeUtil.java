package com.guowei.draw.simpleweather.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {
    //2017-03-14 17:00
    private static String PAT_SERVICE="yyyy-MM-dd HH:mm";
    private static String PAT_LOCAL="HH:mm";
    private static SimpleDateFormat sdf_s=null;
    private static SimpleDateFormat sdf_l=null;
    private static TimeUtil INSTANCE;
    private TimeUtil(){
    }
    public static synchronized TimeUtil getINSTANCE(){
        if (INSTANCE==null){
            INSTANCE=new TimeUtil();
        }
        return INSTANCE;
    }
    public String getTime(String serviceTime){
        if (sdf_s==null){
            sdf_s=new SimpleDateFormat(PAT_SERVICE);
        }
        if (sdf_l==null){
            sdf_l=new SimpleDateFormat(PAT_LOCAL);
        }
        Date date=null;
        try {
            date=sdf_s.parse(serviceTime);
            return sdf_l.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "时间格式化失败";
    }
    public String getTimeFormat(String from,String to,String date){
        SimpleDateFormat fromFormat=new SimpleDateFormat(from);
        SimpleDateFormat toFormat=new SimpleDateFormat(to);
        Date timeDate=null;
        try {
            timeDate=fromFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return toFormat.format(timeDate);
    }
}
