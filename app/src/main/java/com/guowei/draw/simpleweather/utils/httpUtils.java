package com.guowei.draw.simpleweather.utils;


import com.guowei.draw.simpleweather.bean.CaiRealTimeBean;
import com.guowei.draw.simpleweather.http.CaiyunServer;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class HttpUtils {
    public static final String CaiBaseUrl="https://api.caiyunapp.com/v2/";
    public static final String key="TAkhjf8d1nlSlspN";

    private static HttpUtils INSTANCE;

    public HttpUtils(){}
    public static synchronized HttpUtils getInstance(){
        if (INSTANCE==null){
            INSTANCE=new HttpUtils();
        }
        return INSTANCE;
    }

    private Retrofit caiRetrofit;
    private CaiyunServer caiyunServer;
    private void createCaiRetrofit(){
        if (caiRetrofit==null){
            caiRetrofit=new Retrofit.Builder()
                    .baseUrl(CaiBaseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
        }
        if (caiyunServer==null){
            caiyunServer=caiRetrofit.create(CaiyunServer.class);
        }
    }

    public void getCaiRealTimeWeather(String longitude, String latitude, Subscriber<CaiRealTimeBean> subscriber){
        createCaiRetrofit();
        Observable<CaiRealTimeBean> observable = caiyunServer.getRealTimeWeather(key, longitude, latitude);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
}
