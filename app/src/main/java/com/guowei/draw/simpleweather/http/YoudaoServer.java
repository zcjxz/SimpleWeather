package com.guowei.draw.simpleweather.http;


import com.guowei.draw.simpleweather.bean.YoudaoBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface YoudaoServer {
    @GET("openapi.do")
    Observable<YoudaoBean> getFangYi(@Query("keyfrom") String keyfrom, @Query("key") String key,@Query("type") String type,@Query("doctype") String doctype,
                                     @Query("only") String only,@Query("version") String version,@Query("q") String q);
}
