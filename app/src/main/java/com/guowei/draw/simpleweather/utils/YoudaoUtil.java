package com.guowei.draw.simpleweather.utils;

import android.widget.TextView;

import com.guowei.draw.simpleweather.bean.YoudaoBean;

import rx.functions.Action1;

public class YoudaoUtil {
    public static void getFangyi(String zhString, final TextView textView, final String beforeString){
        HttpUtils.getInstance().getFangyi(zhString, new Action1<YoudaoBean>() {
            @Override
            public void call(YoudaoBean youdaoBean) {
                textView.setText(beforeString+youdaoBean.getTranslation().get(0));
            }
        });
    }
}
