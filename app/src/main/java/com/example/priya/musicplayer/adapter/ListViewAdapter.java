package com.example.priya.musicplayer.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.priya.musicplayer.R;
import com.example.priya.musicplayer.model.ResponseGson;

import java.util.ArrayList;
import java.util.List;

public class ListViewAdapter extends BaseAdapter {

    List<ResponseGson.Group> items = new ArrayList<>();
    LayoutInflater inflater;
    Context context;
    ViewHolder holder;

    public ListViewAdapter(Context context, List<ResponseGson.Group> logEntryList) {
        this.items = logEntryList;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.context = context;
    }
    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return items.indexOf(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            holder = new ViewHolder();
            convertView = this.inflater.inflate(R.layout.listview_item,
                    parent, false);
            holder.albumName = (TextView) convertView
                    .findViewById(R.id.album_name);
            holder.artistName = (TextView) convertView
                    .findViewById(R.id.artist_name);
            holder.image = (ImageView) convertView.findViewById(R.id.album_image);
            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        ResponseGson.Group album = items.get(position);
        getImageFromBase64(album.getImagePath());
        holder.albumName.setText(album.getTitle());
        holder.artistName.setText(album.getSubtitle());

        return convertView;
    }

    private void getImageFromBase64(String imagePath) {
//        if (imagePath.length() == 0 ){
//            return context.getDrawable(R.drawable.record_album);
//        }

        byte[] decodedString = Base64.decode(imagePath, Base64.DEFAULT);
        final Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
         holder.image.setImageBitmap(getRoundedShape(decodedByte));
//         new BitmapDrawable(context.getResources(), decodedByte);
    }
    public Bitmap getRoundedShape(Bitmap scaleBitmapImage) {
        int targetWidth = 50;
        int targetHeight = 50;
        Bitmap targetBitmap = Bitmap.createBitmap(targetWidth,
                targetHeight,Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(targetBitmap);
        Path path = new Path();
        path.addCircle(((float) targetWidth - 1) / 2,
                ((float) targetHeight - 1) / 2,
                (Math.min(((float) targetWidth),
                        ((float) targetHeight)) / 2),
                Path.Direction.CCW);

        canvas.clipPath(path);
        Bitmap sourceBitmap = scaleBitmapImage;
        if (sourceBitmap != null)
        canvas.drawBitmap(sourceBitmap,
                new Rect(0, 0, sourceBitmap.getWidth(),
                        sourceBitmap.getHeight()),
                new Rect(0, 0, targetWidth, targetHeight), null);
        return targetBitmap;
    }

    public class ViewHolder{
        ImageView image;
        TextView albumName, artistName;
    }
}
