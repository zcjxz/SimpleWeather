package com.guowei.draw.simpleweather.http;

import com.guowei.draw.simpleweather.bean.CaiForecastBean;
import com.guowei.draw.simpleweather.bean.CaiRealTimeBean;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

public interface CaiyunServer {
    //获取实时天气
    @GET("{cai_key}/{longitude},{latitude}/realtime.json")
    Observable<CaiRealTimeBean> getRealTimeWeather(@Path("cai_key") String key, @Path("longitude") String longitude, @Path("latitude") String latitude);

    //获取天气预报
    @GET("{cai_key}/{longitude},{latitude}/forecast.json")
    Observable<CaiForecastBean> getForecastWeather(@Path("cai_key") String key,@Path("longitude") String longitude,@Path("latitude") String latitude);
}
