package com.example.lh.architecture.http;

import android.content.Context;

import com.example.lh.architecture.config.Constant;
import com.example.lh.architecture.utils.ACache;
import com.google.gson.Gson;
import com.halcyon.logger.HttpLogInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lh_ha on 2016/12/21.
 */

public class DataSource implements BaseRepository<Api,ACache>{

    private final Api mApi;

    public DataSource(String url) {
        //remote source init
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(Constant.CONNECT_TIME, TimeUnit.MILLISECONDS)
                .addInterceptor(new HttpLogInterceptor())
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                .build();
        mApi = retrofit.create(Api.class);
    }

    @Override
    public Api remote() {
        return mApi;
    }

    @Override
    public ACache local(Context context) {
        return ACache.get(context);
    }
}
