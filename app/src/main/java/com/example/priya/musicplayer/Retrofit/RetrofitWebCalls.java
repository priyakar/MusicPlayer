package com.example.priya.musicplayer.Retrofit;

import com.example.priya.musicplayer.model.ViewModel;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Header;

public interface RetrofitWebCalls {

    @GET("/tracks.json")
    void getPlaylists(
            @Header("Content-Type: application/json") Callback<ViewModel> callback);
}
