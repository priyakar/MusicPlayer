package com.example.priya.musicplayer.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.priya.musicplayer.R;
import com.example.priya.musicplayer.databinding.ActivityLandingBinding;

public class LandingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityLandingBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_landing);
    }

    public void onMusicListButtonClick(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }

    public void onHelloWorldButtonClick(View view) {
        startActivity(new Intent(this, HelloWorldActivity.class));
    }
}
