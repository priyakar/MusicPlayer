package com.example.priya.musicplayer.Retrofit;

import android.util.Base64;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.OkHttpClient;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.converter.GsonConverter;

public class RetrofitManager {

    private  static final Gson GSON = new GsonBuilder().create();
    static RestAdapter builder = new RestAdapter.Builder()
            .setEndpoint("http://shahmalav.com/tracks.json")
            .setConverter(new GsonConverter(new Gson()))
            .setClient(new OkClient(new OkHttpClient()))
            .setLogLevel(RestAdapter.LogLevel.FULL)
            .setRequestInterceptor(new RequestInterceptor() {
                @Override
                public void intercept(RequestFacade request) {
                    request.addHeader("Accept", "application/json");
                }
            })
            .build();

    private static RetrofitWebCalls malavApi;
    public static RetrofitWebCalls getSlackServiceInstatnce(){

        if (malavApi == null){
            malavApi = builder.create(RetrofitWebCalls.class);
        }
        return malavApi;
    }
}
