package com.example.congthucnauan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.congthucnauan.database.Database;

import de.hdodenhof.circleimageview.CircleImageView;

public class ManHinhChaoActivity extends AppCompatActivity {
    public static Database database;
    CircleImageView imgIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.man_hinh_chao_layout);
        final Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(500);
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
        //DATABASE
        database = new Database(this, "CongThucNauAn.sqlite", null, 1);
        //Tạo bảng MonAn
        database.QueryData("CREATE TABLE IF NOT EXISTS MonAn(Id INTEGER PRIMARY KEY AUTOINCREMENT, TenMonAn VARCHAR(100), MoTa TEXT, IdDanhMuc INTEGER,NguyenLieu TEXT,Buoc1 TEXT,Buoc2 TEXT,Buoc3 TEXT, Buoc4 TEXT, ThanhPham TEXT,Hinh VARCHAR(20),Hinh1 VARCHAR(20),Hinh2 VARCHAR(20),Hinh3 VARCHAR(20),Hinh4 VARCHAR(20),Hinh5 VARCHAR(20))");
        database.QueryData("CREATE TABLE IF NOT EXISTS Video(Id INTEGER PRIMARY KEY AUTOINCREMENT,TenVideo VARCHAR(50),Hinh VARCHAR(50), TenKhongDau VARCHAR(50))");

    }
}
