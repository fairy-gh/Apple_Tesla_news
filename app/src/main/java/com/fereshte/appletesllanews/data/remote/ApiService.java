package com.fereshte.appletesllanews.data.remote;

import android.content.Context;
import com.fereshte.appletesllanews.R;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {
    private static Retrofit instance = null;
    public static Retrofit getInstance(Context context) {
        if (instance == null) {
            instance = new Retrofit.Builder()
                    .baseUrl(context.getResources().getString(R.string.base_url))
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return instance;
    }
}
