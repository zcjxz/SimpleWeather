package com.guowei.draw.simpleweather.http;


import com.guowei.draw.simpleweather.bean.HefengSearch;
import com.guowei.draw.simpleweather.bean.HefengSuggestion;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface HeFengServer {
    @GET("suggestion")
    Observable<HefengSuggestion> getHefengSuggestion(@Query("city") String city,@Query("key") String key);
    @GET("search")
    Observable<HefengSearch> getHefengSearch(@Query("city") String city,@Query("key") String key);
}
