package com.example.priya.musicplayer.activity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.priya.musicplayer.R;
import com.example.priya.musicplayer.databinding.ActivityHelloWorldBinding;
import com.example.priya.musicplayer.model.ViewModel;

public class HelloWorldActivity extends AppCompatActivity {

     ViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityHelloWorldBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_hello_world);
        viewModel = new ViewModel();
        binding.setViewModel(viewModel);
    }
}
