package com.example.priya.musicplayer.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.priya.musicplayer.R;
import com.example.priya.musicplayer.databinding.ListviewItemBinding;
import com.example.priya.musicplayer.model.ResponseGson;

import java.util.ArrayList;
import java.util.List;

public class ListViewAdapter extends RecyclerView.Adapter<ListViewAdapter.ViewHolder> {

    List<ResponseGson.Group> items = new ArrayList<>();
    Context context;

    public ListViewAdapter(Context context, List<ResponseGson.Group> logEntryList) {
        super();
        this.items = logEntryList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ListviewItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.listview_item, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindConnection(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    private void getImageFromBase64(String imagePath) {

        byte[] decodedString = Base64.decode(imagePath, Base64.DEFAULT);
        final Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ListviewItemBinding binding;

        public ViewHolder(ListviewItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bindConnection(ResponseGson.Group group){
            binding.setGroup(group);
        }
    }
}
