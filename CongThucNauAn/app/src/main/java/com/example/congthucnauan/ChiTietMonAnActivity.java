package com.example.congthucnauan;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import java.util.ArrayList;

public class ChiTietMonAnActivity extends AppCompatActivity {
Toolbar toolbarChiTiet;
TextView txtMonAn,txtNguyenLieu,txtBuoc1,txtBuoc2,txtBuoc3,txtBuoc4,txtThanhPham;
ImageView imgBuoc1,imgBuoc2,imgBuoc3,imgBuoc4,imgThanhPham;
ArrayList<String> hinhViewflipper = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chi_tiet_mon_an_layout);
        //Toolbar
        toolbarChiTiet = (Toolbar) findViewById(R.id.toolbarChiTiet);
        Intent intent = getIntent();
        String monAn = intent.getStringExtra("Key");
        toolbarChiTiet.setTitle(monAn);
        setSupportActionBar(toolbarChiTiet);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarChiTiet.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //Anh xa
        AnhXa();
        Cursor cursor = TrangChuActivity.database.GetData("SELECT * FROM MonAn WHERE TenMonAn LIKE '"+monAn+"'");
        while (cursor.moveToNext()){
           String tenmon = cursor.getString(1);
           String  nguyenlieu = cursor.getString(4);
           String b1 = cursor.getString(5);
            String b2 = cursor.getString(6);
            String b3 = cursor.getString(7);
            String b4 = cursor.getString(8);
            String thanhpham = cursor.getString(9);
            String hinh = cursor.getString(14);
            String hinh1 = cursor.getString(10);
            String hinh2 = cursor.getString(11);
            String hinh3 = cursor.getString(12);
            String hinh4 = cursor.getString(13);
            txtMonAn.setText("Cách Làm Món "+tenmon);
            txtNguyenLieu.setText(nguyenlieu.toString());
            txtBuoc1.setText(b1.toString());
            txtBuoc2.setText(b2.toString());
            txtBuoc3.setText(b3.toString());
            txtBuoc4.setText(b4.toString());
            txtThanhPham.setText(thanhpham.toString());
            imgBuoc1.setImageBitmap(TrangChuActivity.database.getBitmapFromAssets(hinh1));
            imgBuoc2.setImageBitmap(TrangChuActivity.database.getBitmapFromAssets(hinh2));
            imgBuoc3.setImageBitmap(TrangChuActivity.database.getBitmapFromAssets(hinh3));
            imgBuoc4.setImageBitmap(TrangChuActivity.database.getBitmapFromAssets(hinh4));
            imgThanhPham.setImageBitmap(TrangChuActivity.database.getBitmapFromAssets(hinh));
            hinhViewflipper.add(hinh1);
            hinhViewflipper.add(hinh2);
            hinhViewflipper.add(hinh3);
            hinhViewflipper.add(hinh4);
            hinhViewflipper.add(hinh);
        }
       ViewFlipper viewFlipper = findViewById(R.id.viewFliperChiTiet);
       Animation in = AnimationUtils.loadAnimation(this,R.anim.in_chitiet);
       Animation out = AnimationUtils.loadAnimation(this,R.anim.out_chitiet);
        viewFlipper.setInAnimation(in);
        viewFlipper.setOutAnimation(out);
        viewFlipper.setFlipInterval(3000);
        viewFlipper.setAutoStart(true);
        for (int i = 0 ; i < hinhViewflipper.size(); i++){
            ImageView img = new ImageView(this);
            img.setImageBitmap(TrangChuActivity.database.getBitmapFromAssets(hinhViewflipper.get(i).toString()));
            img.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipper.addView(img);
        }
    }


    private void AnhXa() {
        txtMonAn = (TextView) findViewById(R.id.txtTenMon);
        txtNguyenLieu=(TextView) findViewById(R.id.txtNguyenLieu);
        txtBuoc1 = (TextView) findViewById(R.id.txtBuoc1);
        txtBuoc2 = (TextView) findViewById(R.id.txtBuoc2);
        txtBuoc3 = (TextView) findViewById(R.id.txtBuoc3);
        txtBuoc4 = (TextView) findViewById(R.id.txtBuoc4);
        txtThanhPham =(TextView) findViewById(R.id.txtThanhPham);
        imgBuoc1 =  (ImageView) findViewById(R.id.imgBuoc1);
        imgBuoc2 =  (ImageView) findViewById(R.id.imgBuoc2);
        imgBuoc3 =  (ImageView) findViewById(R.id.imgBuoc3);
        imgBuoc4 =  (ImageView) findViewById(R.id.imgBuoc4);
        imgThanhPham =  (ImageView) findViewById(R.id.imgThanhPham);
    }
}
