package com.example.congthucnauan;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class PlayVideoActivity extends AppCompatActivity {
    Toolbar toolbarPlay;
    private VideoView videoView;
    private MediaController mediaController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_video_layout);
        //Toolbar
        toolbarPlay = (Toolbar) findViewById(R.id.toolbarPlay);
        Intent intent = getIntent();
        String txtPlay = intent.getStringExtra("Key");
        String tenBH = intent.getStringExtra("Id");
        toolbarPlay.setTitle(txtPlay);
        setSupportActionBar(toolbarPlay);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarPlay.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //Video
        videoView = (VideoView) findViewById(R.id.video);
        if(mediaController == null){
            mediaController = new MediaController(PlayVideoActivity.this);
            mediaController.setAnchorView(videoView);
            videoView.setMediaController(mediaController);
        }
        try {
            // ID của file video.
            int id = this.getRawResIdByName(tenBH);
            videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + id));

        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }
    }


    public int getRawResIdByName(String resName) {
        String pkgName = this.getPackageName();
        // Trả về 0 nếu không tìm thấy.
        int resID = this.getResources().getIdentifier(resName, "raw", pkgName);
        Log.i("AndroidVideoView", "Res Name: " + resName + "==> Res ID = " + resID);
        return resID;
    }
}
