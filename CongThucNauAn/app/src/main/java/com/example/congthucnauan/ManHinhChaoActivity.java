package com.example.congthucnauan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.congthucnauan.database.Database;

import de.hdodenhof.circleimageview.CircleImageView;

public class ManHinhChaoActivity extends AppCompatActivity {
    CircleImageView imgIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.man_hinh_chao_layout);
        final Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (Exception e) {

                } finally {
                    Intent i = new Intent(ManHinhChaoActivity.this, TrangChuActivity.class);
                    startActivity(i);

                }
            }
        });
        thread.start();
        //Xoay HInh
        imgIcon = (CircleImageView) findViewById(R.id.icon);
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.xoay);
        imgIcon.startAnimation(animation);
    }
}
