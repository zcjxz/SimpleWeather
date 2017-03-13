package com.guowei.draw.simpleweather.utils;

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
}
