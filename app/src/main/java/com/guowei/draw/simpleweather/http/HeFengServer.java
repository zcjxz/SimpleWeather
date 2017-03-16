package com.guowei.draw.simpleweather.http;


import com.guowei.draw.simpleweather.bean.HefengSearchBean;
import com.guowei.draw.simpleweather.bean.HefengSuggestionBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface HeFengServer {
    @GET("suggestion")
    Observable<HefengSuggestionBean> getHefengSuggestion(@Query("city") String city, @Query("key") String key);
    @GET("search")
    Observable<HefengSearchBean> getHefengSearch(@Query("city") String city, @Query("key") String key);
}
