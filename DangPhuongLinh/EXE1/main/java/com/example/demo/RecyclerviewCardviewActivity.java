package com.example.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerviewCardviewActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview);
        recyclerView =(RecyclerView) findViewById(R.id.recyclerview);

        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        final ArrayList<MonAn> monAnArrayList = new ArrayList<>();

        for(int i = 0 ; i <  DuLieu.imgHinh.length;i++){
            monAnArrayList.add(new MonAn(DuLieu.imgHinh[i],DuLieu.txtTenMonAn[i]));
        }
        final MonAnAdapter monAnAdapter = new MonAnAdapter(monAnArrayList,getApplicationContext());
        recyclerView.setAdapter(monAnAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

}
