package com.example.exe4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class ChiTiet extends AppCompatActivity {
ImageView imgHinh;
TextView txtTen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chi_tiet_layout);
        imgHinh = (ImageView) findViewById(R.id.imgHinh);
        txtTen = (TextView) findViewById(R.id.txtTen);
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("BH");
        String tenBH = bundle.getString("ten");
        int hinh = bundle.getInt("hinh");
        txtTen.setText(tenBH);
        imgHinh.setImageResource(hinh);
        Animation animation = AnimationUtils.loadAnimation(ChiTiet.this,R.anim.xoay);
        imgHinh.setAnimation(animation);
    }
}
