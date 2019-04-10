package com.example.congthucnauan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;

import com.example.congthucnauan.adapter.DSQuanAnAdapter;
import com.example.congthucnauan.adapter.QuanAnAdapter;
import com.example.congthucnauan.models.QuanAn;

import java.util.ArrayList;

public class QuanAnActivity extends AppCompatActivity {
    Toolbar toolbarQuanAn;
    RecyclerView reQuanAn;
    DSQuanAnAdapter dsQuanAnAdapter;
    ArrayList<QuanAn> quanAns;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.man_hinh_quan_an_layout);
        //Toolbar
        toolbarQuanAn = (Toolbar) findViewById(R.id.toolbarQuanAn);
        Intent intent = getIntent();
        String quanAn = intent.getStringExtra("Key");
        toolbarQuanAn.setTitle(quanAn);
        setSupportActionBar(toolbarQuanAn);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarQuanAn.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //Recycle quan an
        reQuanAn = (RecyclerView) findViewById(R.id.reQuanAna);
        reQuanAn.setHasFixedSize(true);
        //LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        reQuanAn.setLayoutManager(new GridLayoutManager(this,2));
        quanAns = new ArrayList<>();
        for(int i = 0; i< DuLieuQuanAn.imgHinhQuanAn.length;i++){
            quanAns.add(new QuanAn(DuLieuQuanAn.imgHinhQuanAn[i],DuLieuQuanAn.txtTenQuanAn[i],DuLieuQuanAn.txtDiaChi[i]));
        }
        dsQuanAnAdapter =  new DSQuanAnAdapter(quanAns,this);
        reQuanAn.setAdapter(dsQuanAnAdapter);
        reQuanAn.setItemAnimator(new DefaultItemAnimator());
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search,menu);
        return super.onCreateOptionsMenu(menu);
    }
}
