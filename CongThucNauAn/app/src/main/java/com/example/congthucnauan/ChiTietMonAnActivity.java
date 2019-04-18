package com.example.congthucnauan;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.congthucnauan.models.MonAn;

public class ChiTietMonAnActivity extends AppCompatActivity {
Toolbar toolbarChiTiet;
TextView txtMonAn,txtNguyenLieu,txtBuoc1,txtBuoc2,txtBuoc3,txtBuoc4,txtThanhPham;
ImageView imgMonAn,imgBuoc1,imgBuoc2,imgBuoc3,imgBuoc4,imgThanhPham;
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
            Uri img = Uri.parse("android.resource://com.example.congthucnauan" + "/drawable/" + hinh);
            Uri img1 = Uri.parse("android.resource://com.example.congthucnauan" + "/drawable/" + hinh1);
            Uri img2 = Uri.parse("android.resource://com.example.congthucnauan" + "/drawable/" + hinh2);
            Uri img3 = Uri.parse("android.resource://com.example.congthucnauan" + "/drawable/" + hinh3);
            Uri img4 = Uri.parse("android.resource://com.example.congthucnauan" + "/drawable/" + hinh4);
            Uri img5 = Uri.parse("android.resource://com.example.congthucnauan" + "/drawable/" + hinh);
            imgMonAn.setImageURI(img);
            imgBuoc1.setImageURI(img1);
            imgBuoc2.setImageURI(img2);
            imgBuoc3.setImageURI(img3);
            imgBuoc4.setImageURI(img4);
            imgThanhPham.setImageURI(img5);
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
        imgMonAn =(ImageView) findViewById(R.id.imgMonAn);
        imgBuoc1 =  (ImageView) findViewById(R.id.imgBuoc1);
        imgBuoc2 =  (ImageView) findViewById(R.id.imgBuoc2);
        imgBuoc3 =  (ImageView) findViewById(R.id.imgBuoc3);
        imgBuoc4 =  (ImageView) findViewById(R.id.imgBuoc4);
        imgThanhPham =  (ImageView) findViewById(R.id.imgThanhPham);
    }
}
