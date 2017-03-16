package com.guowei.draw.simpleweather.utils;


import com.guowei.draw.simpleweather.bean.CaiForecastBean;
import com.guowei.draw.simpleweather.bean.CaiRealTimeBean;
import com.guowei.draw.simpleweather.bean.HefengSearchBean;
import com.guowei.draw.simpleweather.bean.HefengSuggestionBean;
import com.guowei.draw.simpleweather.http.CaiyunServer;
import com.guowei.draw.simpleweather.http.HeFengServer;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class HttpUtils {
    public static final String CaiBaseUrl="https://api.caiyunapp.com/v2/";
    public static final String caiKey ="7sPviCtTxhQ1bcu9";

    public static final String hefengKey="369f85b879624fe3ba5d05a1b4037c7e";
    public static final String hefengBaseUrl="https://free-api.heweather.com/v5/";

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
    private Retrofit hefengRetrofit;
    private HeFengServer heFengServer;
    private void createHefengRetrofit(){
        if (hefengRetrofit==null){
            hefengRetrofit=new Retrofit.Builder()
                    .baseUrl(hefengBaseUrl)
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        if (heFengServer==null){
            heFengServer=hefengRetrofit.create(HeFengServer.class);
        }
    }

    public void getCaiRealTimeWeather(String longitude, String latitude, Subscriber<CaiRealTimeBean> subscriber){
        createCaiRetrofit();
        Observable<CaiRealTimeBean> observable = caiyunServer.getRealTimeWeather(caiKey, longitude, latitude);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
    public void getCaiForecast(String longistude, String latitude, Subscriber<CaiForecastBean> subscriber){
        createCaiRetrofit();
        Observable<CaiForecastBean> observable = caiyunServer.getForecastWeather(caiKey, longistude, latitude);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 获取城市信息
     * @param city
     * @param subscriber
     */
    public void getHefengCity(String city, Subscriber<HefengSearchBean> subscriber){
        createHefengRetrofit();
        Observable<HefengSearchBean> observable = heFengServer.getHefengSearch(city, hefengKey);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
    public void getHefengSuggestion(String cityId, Subscriber<HefengSuggestionBean> subscriber){
        createHefengRetrofit();
        Observable<HefengSuggestionBean> observable=heFengServer.getHefengSuggestion(cityId,hefengKey);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
}
