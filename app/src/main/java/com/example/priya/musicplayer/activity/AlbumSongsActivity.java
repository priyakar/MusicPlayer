package com.example.priya.musicplayer.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.priya.musicplayer.Constants;
import com.example.priya.musicplayer.R;
import com.example.priya.musicplayer.adapter.AlbumSongsAdapter;
import com.example.priya.musicplayer.adapter.RecyclerViewAdapter;
import com.example.priya.musicplayer.model.ResponseGson;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class AlbumSongsActivity extends AppCompatActivity {

    @InjectView(R.id.albums)
    RecyclerView songs;
    List<ResponseGson.Item> songsList;
    AlbumSongsAdapter adapter;
    ResponseGson gson;
    int positionNum;
    RecyclerViewAdapter.GroupClickListener listener;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        songsList = new ArrayList<>();
        listener = new RecyclerViewAdapter.GroupClickListener() {
            @Override
            public void onGroupItemClick(int position) {
                positionNum = position;
            }
        };
        gson = new Gson().fromJson(PreferenceManager.getDefaultSharedPreferences(this).getString(Constants.SHARED_PREFS_JSON, null), ResponseGson.class);
        songsList = gson.getGroups().get(positionNum).getItems();
        adapter = new AlbumSongsAdapter(this, songsList);
        songs.setLayoutManager(new LinearLayoutManager(AlbumSongsActivity.this));
        songs.setAdapter(adapter);
    }
}
