package com.example.congthucnauan.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.congthucnauan.ManHinhVideoActivity;
import com.example.congthucnauan.PlayVideoActivity;
import com.example.congthucnauan.R;
import com.example.congthucnauan.models.Video;

import java.util.ArrayList;
import java.util.List;

public class VideoAdapter extends BaseAdapter {
    List<Video> videos;
    Context context;
    int layout;

    public VideoAdapter(List<Video> videos, Context context, int layout) {
        this.videos = videos;
        this.context = context;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return videos.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final TextView txtTenVideo;
        ImageView imgHinhVideo;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.item_video,null);
        txtTenVideo = (TextView) convertView.findViewById(R.id.txtVideo);
        imgHinhVideo = (ImageView) convertView.findViewById(R.id.imgVideo);
        Video video = videos.get(position);
        txtTenVideo.setText(video.getTenVideo());
        Uri imgUri = Uri.parse("android.resource://com.example.congthucnauan" + "/drawable/" + videos.get(position).getImgHinhVideo());
        imgHinhVideo.setImageURI(imgUri);
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PlayVideoActivity.class);
                intent.putExtra("Key",videos.get(position).getTenVideo());
                intent.putExtra("BH",videos.get(position).getIdVideo());
                context.startActivity(intent);
            }
        });
        return convertView;
    }
}
