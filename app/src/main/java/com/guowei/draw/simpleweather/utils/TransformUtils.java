package com.guowei.draw.simpleweather.utils;

import com.guowei.draw.simpleweather.C;
import com.guowei.draw.simpleweather.R;
import com.guowei.draw.simpleweather.WeatherApplication;

public class TransformUtils {
    /**
     * 把风速转化成等级
     * @param speed
     * @return
     */
    public static String transformSpeed(double speed){
        if (speed<=2){
            return ResourcesUtil.getString(R.string.none_wind);
        }else if (speed<=6){
            return ResourcesUtil.getString(R.string.force_1);
        }else if (speed<=12){
            return ResourcesUtil.getString(R.string.force_2);
        }else if (speed<=19){
            return ResourcesUtil.getString(R.string.force_3);
        }else if (speed<=30){
            return ResourcesUtil.getString(R.string.force_4);
        }else if (speed<=40){
            return ResourcesUtil.getString(R.string.force_5);
        }else if (speed<=51){
            return ResourcesUtil.getString(R.string.force_6);
        }else if (speed<=62){
            return ResourcesUtil.getString(R.string.force_7);
        }else if (speed<=75){
            return ResourcesUtil.getString(R.string.force_8);
        }else if (speed<=87){
            return ResourcesUtil.getString(R.string.force_9);
        }else if (speed<=103){
            return ResourcesUtil.getString(R.string.force_10);
        }else if (speed<=117){
            return ResourcesUtil.getString(R.string.force_11);
        }else if (speed<=132){
            return ResourcesUtil.getString(R.string.force_12);
        }else if (speed<=149){
            return ResourcesUtil.getString(R.string.force_13);
        }else if (speed<=166){
            return ResourcesUtil.getString(R.string.force_14);
        }else if (speed<=183){
            return ResourcesUtil.getString(R.string.force_15);
        }else if (speed<=201){
            return ResourcesUtil.getString(R.string.force_16);
        }else if (speed<=220){
            return ResourcesUtil.getString(R.string.force_17);
        }else{
            return ResourcesUtil.getString(R.string.force_18);
        }
    }

    /**
     * 把角度转化成风向
     * @param direction
     * @return
     */
    public static String transformDirection(double direction){
        if (direction<=22.5){
            return ResourcesUtil.getString(R.string.north_wind);
        }else if (direction<=67.5){
            return ResourcesUtil.getString(R.string.northeast_wind);
        }else if (direction<=112.5){
            return ResourcesUtil.getString(R.string.east_wind);
        }else if (direction<=157.5){
            return ResourcesUtil.getString(R.string.southeast_wind);
        }else if (direction<=202.5){
            return ResourcesUtil.getString(R.string.south_wind);
        }else if (direction<=247.5){
            return  ResourcesUtil.getString(R.string.southwest_wind);
        }else if (direction<=292.5){
            return ResourcesUtil.getString(R.string.west_wind);
        }else {
            return ResourcesUtil.getString(R.string.none_wind);
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
            return ResourcesUtil.getString(R.string.clear_day);
        }else if (skycon.equals("CLEAR_NIGHT")){
            return ResourcesUtil.getString(R.string.clear_night);
        }else if (skycon.equals("PARTLY_CLOUDY_DAY")){
            return ResourcesUtil.getString(R.string.cloudy);
        }else if (skycon.equals("PARTLY_CLOUDY_NIGHT")){
            return ResourcesUtil.getString(R.string.cloudy);
        }else if (skycon.equals("CLOUDY")){
            return ResourcesUtil.getString(R.string.cloudy);
        }else if (skycon.equals("RAIN")){
            return ResourcesUtil.getString(R.string.raining);
        }else if (skycon.equals("SNOW")){
            return ResourcesUtil.getString(R.string.snow);
        }else if (skycon.equals("WIND")){
            return ResourcesUtil.getString(R.string.wind);
        }else if (skycon.equals("FOG")){
            return ResourcesUtil.getString(R.string.fog);
        }
        return ResourcesUtil.getString(R.string.cloudy);
    }

    /**
     * 转化aqi为优良等级
     * @param aqi
     * @return
     */
    public static String transformAQI(double aqi){
        if (aqi<=50){
            return ResourcesUtil.getString(R.string.aqi_eximious);
        }else if (aqi<=100){
            return ResourcesUtil.getString(R.string.aqi_fine);
        }else if (aqi<=150){
            return ResourcesUtil.getString(R.string.aqi_lightly_pollution);
        }else if (aqi<=200){
            return ResourcesUtil.getString(R.string.aqi_middle_pollution);
        }else if (aqi<=300){
            return ResourcesUtil.getString(R.string.aqi_serious_pollution);
        }else{
            return ResourcesUtil.getString(R.string.aqi_eximious);
        }
    }

    /**
     * 去掉百度地图获取的城市后面的 省，市
     * @param city
     * @return
     */
    public static String transformCityName(String city){
        if (city.length()<=1){
            return "error";
        }
        return city.substring(0, city.length() - 1);
    }

    public static String transformTemp(int temp){
        String degree = SpUtil.getString(C.SP_NAME, C.DEGREE, "℃");
        switch (degree){
            case "℃":
                return temp+C.Centigrade;
            case "℉":
                return (int)(temp*1.8+32)+C.Fahrenheit;
        }
        return temp+C.Centigrade;
    }
}
