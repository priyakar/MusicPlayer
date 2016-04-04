package com.example.priya.musicplayer.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.priya.musicplayer.R;
import com.example.priya.musicplayer.databinding.ListviewItemBinding;
import com.example.priya.musicplayer.model.ResponseGson;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    List<ResponseGson.Group> items = new ArrayList<>();
    Context context;
    GroupClickListener listener;

    public RecyclerViewAdapter(Context context, List<ResponseGson.Group> logEntryList) {
        super();
        this.items = logEntryList;
        this.context = context;
    }


    public interface GroupClickListener {
        void onGroupItemClick(int position);
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

    private Bitmap getImageFromBase64(String imagePath) {

        byte[] str = (Base64.decode(imagePath, Base64.DEFAULT));
        return BitmapFactory.decodeByteArray(str, 0, str.length);

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ListviewItemBinding binding;

        public ViewHolder(ListviewItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bindConnection(ResponseGson.Group group) {
            binding.setGroup(group);
            Picasso.with(context).load(binding.getGroup().getImagePath()).into(binding.albumImage);
            binding.listItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        listener.onGroupItemClick(getAdapterPosition());
                    }
                }
            });
        }
    }

    public void setListener(GroupClickListener listener) {
        this.listener = listener;
    }
}
