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

public class ReviewQuanAnActivity extends AppCompatActivity {
    Toolbar toolbarReviewQuanAn;
    TextView txtTenQuan,txtDiaChi,txtGioMCua,txtGiaBan,txtMoTa1,txtMoTa2,txtMoTa3,txtMoTa4,txtChiDuong;
    ImageView  imgHinh, imgHinh1, imgHinh2, imgHinh3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.review_quan_an_layout);
        //Toolbar
        toolbarReviewQuanAn = (Toolbar) findViewById(R.id.toolbarReviewQuanAn);
        Intent intent = getIntent();
        String review = intent.getStringExtra("Key");
        toolbarReviewQuanAn.setTitle(review);
        setSupportActionBar(toolbarReviewQuanAn);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarReviewQuanAn.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //Anh xa
        AnhXa();
        //get data
        Cursor cursor = TrangChuActivity.database.GetData("SELECT * FROM QuanAn WHERE TenQuanAn LIKE '"+review+"'");
        while (cursor.moveToNext()){
            String ten =  cursor.getString(1);
            String mota1 =  cursor.getString(4);
            String mota2 =  cursor.getString(5);
            String mota3 =  cursor.getString(9);
            String mota4 =  cursor.getString(10);
            String hinh =  cursor.getString(2);
            String hinh1 =  cursor.getString(3);
            String hinh2 =  cursor.getString(11);
            String hinh3 =  cursor.getString(12);
            String diachi =  cursor.getString(6);
            String giomocua =  cursor.getString(7);
            String giaban =  cursor.getString(8);
            Uri img = Uri.parse("android.resource://com.example.congthucnauan" + "/drawable/" + hinh);
            Uri img2 = Uri.parse("android.resource://com.example.congthucnauan" + "/drawable/" + hinh1);
            Uri img3 = Uri.parse("android.resource://com.example.congthucnauan" + "/drawable/" + hinh2);
            Uri img4 = Uri.parse("android.resource://com.example.congthucnauan" + "/drawable/" + hinh3);
            txtTenQuan.setText(ten);
            txtGioMCua.setText(giomocua);
            txtDiaChi.setText(diachi);
            txtGiaBan.setText(giaban);
            txtMoTa1.setText(mota1);
            txtMoTa2.setText(mota2);
            txtMoTa3.setText(mota3);
            txtMoTa4.setText(mota4);
            imgHinh.setImageURI(img);
            imgHinh1.setImageURI(img2);
            imgHinh2.setImageURI(img3);
            imgHinh3.setImageURI(img4);

        }
    }

    private void AnhXa() {
        txtTenQuan = (TextView) findViewById(R.id.txtQuanAn);
        txtGioMCua = (TextView) findViewById(R.id.txtGioMCua);
        txtMoTa1 = (TextView) findViewById(R.id.txtMota1);
        txtMoTa2 = (TextView) findViewById(R.id.txtMota2);
        txtMoTa3 = (TextView) findViewById(R.id.txtMota3);
        txtMoTa4 = (TextView) findViewById(R.id.txtMota4);
        imgHinh = (ImageView) findViewById(R.id.hinh);
        imgHinh1 = (ImageView) findViewById(R.id.hinh1);
        imgHinh2 = (ImageView) findViewById(R.id.hinh2);
        imgHinh3 = (ImageView) findViewById(R.id.hinh3);
        txtChiDuong = (TextView) findViewById(R.id.txtChiDuong);
        txtDiaChi = (TextView) findViewById(R.id.txtDChi);
        txtGiaBan = (TextView) findViewById(R.id.txtGiaBan);
    }
}
