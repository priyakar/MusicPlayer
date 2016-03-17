package com.example.priya.musicplayer.activity;

import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.priya.musicplayer.Retrofit.RetrofitManager;
import com.example.priya.musicplayer.adapter.ListViewAdapter;
import com.example.priya.musicplayer.model.Model;
import com.example.priya.musicplayer.model.ResponseGson;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {


    List<ResponseGson.Group> songs;
    ListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSongs();
        songs = new ArrayList<>();
    }

    private Drawable getBackgroundDrawable(int resId) {
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        return new BitmapDrawable(getResources(), BitmapFactory.decodeResource(getResources(), resId, options));

    }

    private void getSongs() {
        RetrofitManager.getSlackServiceInstatnce().getPlaylists(new Callback<Model>() {
            @Override
            public void success(Model model, Response response) {

                BufferedReader reader;
                StringBuilder sb = new StringBuilder();
                try {

                    reader = new BufferedReader(new InputStreamReader(response.getBody().in()));

                    String line;

                    try {
                        while ((line = reader.readLine()) != null) {
                            sb.append(line);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                String result = sb.toString();

                ResponseGson gson = new Gson().fromJson(result, ResponseGson.class);
                songs = gson.getGroups();
                adapter = new ListViewAdapter(MainActivity.this, songs);
//                albums.setLayoutManager(new LinearLayoutManager(MainActivity.this));
//                albums.setAdapter(adapter);
            }

            @Override
            public void failure(RetrofitError error) {
                Log.e("response", "error " + error.toString());
            }
        });
    }

}
