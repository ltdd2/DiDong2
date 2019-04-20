package com.example.congthucnauan.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.congthucnauan.PlayVideoActivity;
import com.example.congthucnauan.R;
import com.example.congthucnauan.TrangChuActivity;
import com.example.congthucnauan.models.Video;

import java.util.ArrayList;
import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.ViewHolder> {
    ArrayList<Video> videos;
    Context context;

    public VideoAdapter(ArrayList<Video> videos, Context context) {
        this.videos = videos;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, final int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View v = inflater.inflate(R.layout.item_video,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.imgHinhVideo.setImageBitmap(TrangChuActivity.database.getBitmapFromAssets(videos.get(i).getImgHinhVideo()));
        viewHolder.txtTenVideo.setText(videos.get(i).getTenVideo());
        viewHolder.idVideo.setText(videos.get(i).getIdVideo());
    }

    @Override
    public int getItemCount() {
        return videos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgHinhVideo;
        TextView  txtTenVideo,idVideo;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgHinhVideo = itemView.findViewById(R.id.imgVideo);
            txtTenVideo = itemView.findViewById(R.id.txtVideo);
            idVideo = itemView.findViewById(R.id.idVideo);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(context,PlayVideoActivity.class);
                    i.putExtra("Key",txtTenVideo.getText().toString());
                    i.putExtra("Id",idVideo.getText().toString());
                    context.startActivity(i);
                }
            });
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    if(TrangChuActivity.KiemTra == false){
                        Toast.makeText(context,"Ban Chua Dang Nhap", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(context, "Click", Toast.LENGTH_SHORT).show();
                    }
                    return true;
                }
            });
        }
    }
}
