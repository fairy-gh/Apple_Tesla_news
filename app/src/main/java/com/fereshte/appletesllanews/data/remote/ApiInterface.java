package com.fereshte.appletesllanews.data.remote;

import com.fereshte.appletesllanews.data.local.model.NewsModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("everything")
    Call<NewsModel> getNews(@Query("q") String company,
                            @Query("from") String from,
                            @Query("sortBy") String sortBy,
                            @Query("apiKey") String apiKey);

}
