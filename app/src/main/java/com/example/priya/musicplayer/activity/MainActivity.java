package com.example.priya.musicplayer.activity;

import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.priya.musicplayer.Constants;
import com.example.priya.musicplayer.R;
import com.example.priya.musicplayer.Retrofit.RetrofitManager;
import com.example.priya.musicplayer.adapter.RecyclerViewAdapter;
import com.example.priya.musicplayer.model.ResponseGson;
import com.example.priya.musicplayer.model.ViewModel;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {


    @InjectView(R.id.albums)
    RecyclerView albums;
    List<ResponseGson.Group> songs;
    RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        albums.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        getSongs();
        songs = new ArrayList<>();
    }

    private Drawable getBackgroundDrawable(int resId) {
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        return new BitmapDrawable(getResources(), BitmapFactory.decodeResource(getResources(), resId, options));

    }

    private void getSongs() {
        RetrofitManager.getSlackServiceInstatnce().getPlaylists(new Callback<ViewModel>() {
            @Override
            public void success(ViewModel viewModel, Response response) {

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
                SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(MainActivity.this).edit();
                editor.putString(Constants.SHARED_PREFS_JSON, gson.toString()).apply();
                songs = gson.getGroups();
                adapter = new RecyclerViewAdapter(MainActivity.this, songs);
                albums.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                albums.setAdapter(adapter);
            }

            @Override
            public void failure(RetrofitError error) {
                Log.e("response", "error " + error.toString());
            }
        });
    }

}
