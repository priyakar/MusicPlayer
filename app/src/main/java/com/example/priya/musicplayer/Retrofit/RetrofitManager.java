package com.example.priya.musicplayer.Retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

public class RetrofitManager {

    private  static final Gson GSON = new GsonBuilder().create();
    static RestAdapter builder = new RestAdapter.Builder()
            .setEndpoint("http://shahmalav.com/")
            .setConverter(new GsonConverter(GSON))
            .setLogLevel(RestAdapter.LogLevel.FULL)
            .build();

    private static RetrofitWebCalls malavApi;
    public static RetrofitWebCalls getSlackServiceInstatnce(){

        if (malavApi == null){
            malavApi = builder.create(RetrofitWebCalls.class);
        }
        return malavApi;
    }
}
