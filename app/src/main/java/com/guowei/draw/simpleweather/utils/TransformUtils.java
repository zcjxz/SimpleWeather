package com.guowei.draw.simpleweather.utils;

import com.guowei.draw.simpleweather.R;

public class TransformUtils {
    /**
     * 把风速转化成等级
     * @param speed
     * @return
     */
    public static String transformSpeed(double speed){
        if (speed<=2){
            return "无风";
        }else if (speed<=6){
            return "一级";
        }else if (speed<=12){
            return "二级";
        }else if (speed<=19){
            return "三级";
        }else if (speed<=30){
            return "四级";
        }else if (speed<=40){
            return "五级";
        }else if (speed<=51){
            return "六级";
        }else if (speed<=62){
            return "七级";
        }else if (speed<=75){
            return "八级";
        }else if (speed<=87){
            return "九级";
        }else if (speed<=103){
            return "十级";
        }else if (speed<=117){
            return "十一级";
        }else if (speed<=132){
            return "十二级";
        }else if (speed<=149){
            return "十三级";
        }else if (speed<=166){
            return "十四级";
        }else if (speed<=183){
            return "十五级";
        }else if (speed<=201){
            return "十六级";
        }else if (speed<=220){
            return "十七级";
        }else{
            return "十八级";
        }
    }

    /**
     * 把角度转化成风向
     * @param direction
     * @return
     */
    public static String transformDirection(double direction){
        if (direction<=22.5){
            return "北风";
        }else if (direction<=67.5){
            return "东北风";
        }else if (direction<=112.5){
            return "东风";
        }else if (direction<=157.5){
            return "东南风";
        }else if (direction<=202.5){
            return "南风";
        }else if (direction<=247.5){
            return  "西南风";
        }else if (direction<=292.5){
            return "西风";
        }else {
            return "北风";
        }
    }

    /**
     * 把天气概况转化为icon的id
     * @param skycon
     * @return
     */
    public static int transformIcon(String skycon){
        if (skycon.equals("CLEAR_DAY")){
            return R.drawable.clear_day;
        }else if (skycon.equals("CLEAR_NIGHT")){
            return R.drawable.clear_night;
        }else if (skycon.equals("PARTLY_CLOUDY_DAY")){
            return R.drawable.cloudy_day;
        }else if (skycon.equals("PARTLY_CLOUDY_NIGHT")){
            return R.drawable.cloudy_night;
        }else if (skycon.equals("CLOUDY")){
            return R.drawable.cloudy;
        }else if (skycon.equals("RAIN")){
            return R.drawable.rain;
        }else if (skycon.equals("WIND")){
            return R.drawable.wind;
        }else if (skycon.equals("FOG")){
            return R.drawable.fog;
        }else if (skycon.equals("SNOW")){
            return R.drawable.snow;
        }
        return R.drawable.clear_day;
    }

    /**
     * 把天气概况转化为文字
     * @param skycon
     * @return
     */
    public static String transformSkycon(String skycon){
        if (skycon.equals("CLEAR_DAY")){
            return "晴";
        }else if (skycon.equals("CLEAR_NIGHT")){
            return "晴夜";
        }else if (skycon.equals("PARTLY_CLOUDY_DAY")){
            return "多云";
        }else if (skycon.equals("PARTLY_CLOUDY_NIGHT")){
            return "多云";
        }else if (skycon.equals("CLOUDY")){
            return "阴";
        }else if (skycon.equals("RAIN")){
            return "雨";
        }else if (skycon.equals("SNOW")){
            return "雪";
        }else if (skycon.equals("WIND")){
            return "风";
        }else if (skycon.equals("FOG")){
            return "雾";
        }
        return "晴";
    }

    /**
     * 转化aqi为优良等级
     * @param aqi
     * @return
     */
    public static String transformAQI(double aqi){
        if (aqi<=50){
            return "优";
        }else if (aqi<=100){
            return "良";
        }else if (aqi<=150){
            return "轻度污染";
        }else if (aqi<=200){
            return "中度污染";
        }else if (aqi<=300){
            return "重度污染";
        }else{
            return "严重污染";
        }
    }

    /**
     * 去掉百度地图获取的城市后面的 省，市
     * @param city
     * @return
     */
    public static String transformCityName(String city){
        if (city.length()<=1){
            return "错误";
        }
        return city.substring(0, city.length() - 1);
    }
}
