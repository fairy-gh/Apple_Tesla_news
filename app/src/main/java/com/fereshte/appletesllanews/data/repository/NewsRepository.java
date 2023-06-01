package com.fereshte.appletesllanews.data.repository;

import android.content.Context;
import com.fereshte.appletesllanews.data.local.model.NewsModel;
import com.fereshte.appletesllanews.data.remote.ApiInterface;
import com.fereshte.appletesllanews.data.remote.ApiService;
import retrofit2.Call;

public class NewsRepository {
    private final Context context;
    public NewsRepository(Context context) {
        this.context = context;
    }
    public Call<NewsModel> getApiServiceData(String company, String from, String sortBy, String apiKey){
        return ApiService.getInstance(context).create(ApiInterface.class).getNews(company, from, sortBy, apiKey);
    }
}
