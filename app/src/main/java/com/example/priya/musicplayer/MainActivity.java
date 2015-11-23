package com.example.priya.musicplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.priya.musicplayer.Retrofit.RetrofitManager;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RetrofitManager.getSlackServiceInstatnce().getPlaylists(new Callback<Model>() {
            @Override
            public void success(Model model, Response response) {
                Log.e("response",""+response.getBody().toString());
            }

            @Override
            public void failure(RetrofitError error) {
                Log.e("response","error "+error.toString());
            }
        });
    }
}
