package com.example.priya.musicplayer.view_model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.text.Editable;
import android.text.TextWatcher;

import com.example.priya.musicplayer.BR;

public class ViewModel extends BaseObservable {

    String name;

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public TextWatcher textWatcher = new TextWatcher() {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            setName(s.toString());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}



