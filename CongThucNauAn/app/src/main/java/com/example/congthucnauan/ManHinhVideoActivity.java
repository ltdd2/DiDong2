package com.example.congthucnauan;

import android.content.Intent;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.congthucnauan.adapter.VideoAdapter;
import com.example.congthucnauan.models.MonAn;
import com.example.congthucnauan.models.Video;

import java.util.ArrayList;

public class ManHinhVideoActivity extends AppCompatActivity {
    Toolbar toolbarVideo;
    ArrayList<Video> videos;
    VideoAdapter videoAdapter;
    RecyclerView reVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.man_hinh_video_layout);
        //Toolbar
        toolbarVideo = (Toolbar) findViewById(R.id.toolbarVideo);
        Intent intent = getIntent();
        String tenVideo = intent.getStringExtra("Key");
        toolbarVideo.setTitle(tenVideo);
        setSupportActionBar(toolbarVideo);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarVideo.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //Anhs xạ
        reVideo = (RecyclerView) findViewById(R.id.reVideo);
        videos = new ArrayList<>();
        /*for(int i = 0 ; i<DuLieuVideo.imgHinhVideo.length;i++){
            videos.add(new Video(DuLieuVideo.txtTenVideo[i],DuLieuVideo.imgHinhVideo[i],DuLieuVideo.idVideo[i]));
        }*/
        Cursor video = ManHinhChaoActivity.database.GetData("SELECT * FROM Video");
        while (video.moveToNext()){
            String ten = video.getString(1);
            String hinh = video.getString(2);
            String tenkd  = video.getString(3);
            videos.add(new Video(ten,hinh,tenkd));
        }
        videoAdapter = new VideoAdapter(videos,this);
        reVideo.setLayoutManager(new GridLayoutManager(this,2));
        reVideo.setAdapter(videoAdapter);
        reVideo.setItemAnimator(new DefaultItemAnimator());
    }
}
