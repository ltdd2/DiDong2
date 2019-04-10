package com.example.congthucnauan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

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
        String quanAn = intent.getStringExtra("Key");
        toolbarChiTiet.setTitle(quanAn);
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
