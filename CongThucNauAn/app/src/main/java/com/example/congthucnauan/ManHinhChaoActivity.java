package com.example.congthucnauan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.congthucnauan.database.Database;

public class ManHinhChaoActivity extends AppCompatActivity {
    public static Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.man_hinh_chao_layout);
        final Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(500);
                }catch (Exception e){

                }finally {
                    Intent i = new Intent(ManHinhChaoActivity.this,TrangChuActivity.class);
                    startActivity(i);

                }
            }
        });
        thread.start();
        //DATABASE
        database =  new Database(this,"CongThucNauAn.sqlite",null,1);
        //Tạo bảng MonAn
        database.QueryData("CREATE TABLE IF NOT EXISTS MonAn(Id INTEGER PRIMARY KEY AUTOINCREMENT, TenMonAn VARCHAR(100), MoTa TEXT, IdDanhMuc INTEGER,NguyenLieu TEXT,Buoc1 TEXT,Buoc2 TEXT,Buoc3 TEXT, Buoc4 TEXT, ThanhPham TEXT,Hinh VARCHAR(20),Hinh1 VARCHAR(20),Hinh2 VARCHAR(20),Hinh3 VARCHAR(20),Hinh4 VARCHAR(20),Hinh5 VARCHAR(20))");
       // database.QueryData("INSERT INTO MonAn VALUES(null,'mon 2','mo ta mon an',1,'nguyen lieu','buoc1','buoc1','buoc1','buoc1','goitom','thitkho','goitom','goitom','goitom','goitom','goitom')");
    }
}
