package com.example.congthucnauan;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;

import com.example.congthucnauan.adapter.MonAnAdapter;
import com.example.congthucnauan.adapter.MonAnNewAdapter;
import com.example.congthucnauan.database.Database;
import com.example.congthucnauan.models.MonAn;

import java.util.ArrayList;

public class DanhSachMonAnActivity extends AppCompatActivity {
    Toolbar toolbarDSMonAn;
    MonAnAdapter monAnAdapter;
    ArrayList<MonAn> monAns;
    RecyclerView reDSMonAn;
    Database database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.danh_sach_mon_an_layout);
        //Toolbar
        toolbarDSMonAn = (Toolbar) findViewById(R.id.toolbarDSMonAn);
        Intent intent = getIntent();
        String monan = intent.getStringExtra("Key");
        toolbarDSMonAn.setTitle(monan);
        setSupportActionBar(toolbarDSMonAn);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarDSMonAn.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //Nội Dung
        reDSMonAn =  (RecyclerView) findViewById(R.id.reDSMonAn);
        reDSMonAn.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        reDSMonAn.setLayoutManager(linearLayoutManager);
        monAns = new ArrayList<>();
        for (int i = 0; i < DuLieuMonAn.imgHinh.length; i++) {
            monAns.add(new MonAn(DuLieuMonAn.imgHinh[i], DuLieuMonAn.txtTenMonAn[i],DuLieuMonAn.txtMoTaMonAn[i]));
        }
        monAnAdapter = new MonAnAdapter(monAns,this);
        reDSMonAn.setAdapter(monAnAdapter);
        reDSMonAn.setItemAnimator(new DefaultItemAnimator());
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search,menu);
        return super.onCreateOptionsMenu(menu);
    }
}
