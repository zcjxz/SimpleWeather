package com.guowei.draw.simpleweather.utils;


import com.guowei.draw.simpleweather.bean.CaiForecastBean;
import com.guowei.draw.simpleweather.bean.CaiRealTimeBean;
import com.guowei.draw.simpleweather.bean.HefengSearchBean;
import com.guowei.draw.simpleweather.bean.HefengSuggestionBean;
import com.guowei.draw.simpleweather.bean.YoudaoBean;
import com.guowei.draw.simpleweather.http.CaiyunServer;
import com.guowei.draw.simpleweather.http.HeFengServer;
import com.guowei.draw.simpleweather.http.YoudaoServer;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class HttpUtils {
    public static final String caiBaseUrl ="https://api.caiyunapp.com/v2/";
    public static final String cai_key ="7sPviCtTxhQ1bcu9";

    public static final String hefeng_key ="369f85b879624fe3ba5d05a1b4037c7e";
    public static final String hefengBaseUrl="https://free-api.heweather.com/v5/";

    public static final String youdaoBaseUrl="http://fanyi.youdao.com/";
    public static final String youdao_keyFrom="SimpleWeather";
    public static final String youdao_key="155983422";
    public static final String youdao_type="data";
    public static final String youdao_doctype="json";
    public static final String youdao_only="translate";
    public static final String youdao_version="1.1";

    private static HttpUtils INSTANCE;

    private static final String TAG="zcj_http";

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
                    .baseUrl(caiBaseUrl)
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

    private Retrofit youdaoRetrofit;
    private YoudaoServer youdaoServer;
    private void createYoudaoRetrofit(){
        if (youdaoRetrofit==null){
            youdaoRetrofit=new Retrofit.Builder()
                    .baseUrl(youdaoBaseUrl)
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        if (youdaoServer==null){
            youdaoServer=youdaoRetrofit.create(YoudaoServer.class);
        }
    }

    public void getCaiRealTimeWeather(String longitude, String latitude, Subscriber<CaiRealTimeBean> subscriber){
        DebugUtil.debug(TAG,"caiRealTime");
        createCaiRetrofit();
        Observable<CaiRealTimeBean> observable = caiyunServer.getRealTimeWeather(cai_key, longitude, latitude);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
    public void getCaiForecast(String longitude, String latitude, Subscriber<CaiForecastBean> subscriber){
        DebugUtil.debug(TAG,"caiForecast");
        createCaiRetrofit();
        Observable<CaiForecastBean> observable = caiyunServer.getForecastWeather(cai_key, longitude, latitude);
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
        DebugUtil.debug(TAG,"hefengCity");
        createHefengRetrofit();
        Observable<HefengSearchBean> observable = heFengServer.getHefengSearch(city, hefeng_key);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
    public void getHefengSuggestion(String cityId, Subscriber<HefengSuggestionBean> subscriber){
        DebugUtil.debug(TAG,"hefengSuggestion");
        createHefengRetrofit();
        Observable<HefengSuggestionBean> observable=heFengServer.getHefengSuggestion(cityId, hefeng_key);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
    public void getFangyi(String query,Action1<YoudaoBean> subscriber){
        DebugUtil.debug(TAG,"fangyi");
        createYoudaoRetrofit();
        Observable<YoudaoBean> observable = youdaoServer.getFangYi(youdao_keyFrom, youdao_key,
                youdao_type, youdao_doctype, youdao_only, youdao_version, query);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
}
