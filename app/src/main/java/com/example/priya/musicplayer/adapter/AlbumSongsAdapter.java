package com.example.priya.musicplayer.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.priya.musicplayer.R;
import com.example.priya.musicplayer.databinding.SongListItemBinding;
import com.example.priya.musicplayer.model.ResponseGson;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class AlbumSongsAdapter extends RecyclerView.Adapter<AlbumSongsAdapter.ViewHolder> {

    List<ResponseGson.Item> items = new ArrayList<>();
    Context context;

    public AlbumSongsAdapter(Context context, List<ResponseGson.Item> logEntryList) {
        super();
        this.items = logEntryList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        SongListItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent
                .getContext()), R.layout.song_list_item, parent, false);
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

    private Bitmap getImageFromBase64(String imagePath) {

        byte[] str = (Base64.decode(imagePath, Base64.DEFAULT));
        return BitmapFactory.decodeByteArray(str, 0, str.length);

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        SongListItemBinding binding;

        public ViewHolder(SongListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bindConnection(ResponseGson.Item item) {
            binding.setItem(item);
            Picasso.with(context).load(binding.getItem().getImagePath()).into(binding.songImage);
        }
    }
}
