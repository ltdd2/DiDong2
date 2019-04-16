package com.example.animation2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class AnimationActivity extends AppCompatActivity {
     ImageView imgBanh;
     Button btnTren, btnDuoi, btnTrai , btnPhai, btnXoayPhai, btnXoayTrai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animation_layout);
        imgBanh = (ImageView) findViewById(R.id.imgHinh);
        btnTren = (Button) findViewById(R.id.tren);
        btnDuoi = (Button) findViewById(R.id.duoi);
        btnTrai = (Button) findViewById(R.id.trai);
        btnPhai = (Button) findViewById(R.id.phai);
        btnXoayPhai =  (Button) findViewById(R.id.xoayphai);
        btnXoayTrai = (Button) findViewById(R.id.xoaytrai);
        final Animation phai = AnimationUtils.loadAnimation(this,R.anim.phai);
        final Animation trai = AnimationUtils.loadAnimation(this,R.anim.trai);
        final Animation tren = AnimationUtils.loadAnimation(this,R.anim.tren);
        final Animation duoi = AnimationUtils.loadAnimation(this,R.anim.duoi);
        final Animation xoayPhai = AnimationUtils.loadAnimation(this,R.anim.xoayphai);
        final Animation xoayTrai = AnimationUtils.loadAnimation(this,R.anim.xoaytrai);
        final Animation phongto = AnimationUtils.loadAnimation(this,R.anim.to);
        btnPhai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgBanh.startAnimation(phai);
            }
        });
        btnTrai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgBanh.startAnimation(trai);
            }
        });
        btnTren.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgBanh.startAnimation(tren);
            }
        });
        btnDuoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgBanh.startAnimation(duoi);
            }
        });
        btnXoayPhai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgBanh.startAnimation(xoayPhai);
            }
        });
        btnXoayTrai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgBanh.startAnimation(xoayTrai);
            }
        });
        imgBanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(phongto);
            }
        });
    }
}
