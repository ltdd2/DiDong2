package com.example.congthucnauan;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.congthucnauan.adapter.MonAnAdapter;
import com.example.congthucnauan.adapter.MonAnNewAdapter;
import com.example.congthucnauan.database.Database;
import com.example.congthucnauan.models.MonAn;

import java.util.ArrayList;
import java.util.List;

public class DanhSachMonAnActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    Toolbar toolbarDSMonAn;
    MonAnAdapter monAnAdapter;
    ArrayList<MonAn> monAns;
    RecyclerView reDSMonAn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.danh_sach_mon_an_layout);
        //Toolbar
        toolbarDSMonAn = (Toolbar) findViewById(R.id.toolbarDSMonAn);
        Intent intent = getIntent();
        String monan = intent.getStringExtra("Key");
        int id = intent.getIntExtra("ID",0);
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
        Cursor cursor = TrangChuActivity.database.GetData("SELECT * FROM MonAn WHERE IdDanhMuc = '"+id+"'");
        while (cursor.moveToNext()){
            String ten = cursor.getString(1);
            String mota = cursor.getString(2);
            String hinh = cursor.getString(14);
            monAns.add(new MonAn(hinh,ten,mota));
        }
         UpdateAdapter(monAns);
        reDSMonAn.setItemAnimator(new DefaultItemAnimator());
    }
    private void UpdateAdapter(List<MonAn> list){
        monAnAdapter = new MonAnAdapter(monAns,this);
        reDSMonAn.setAdapter(monAnAdapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search,menu);
        MenuItem item = menu.findItem(R.id.searchView);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(this);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {

        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        monAns = TimMonAnTheoTen(newText.toLowerCase());
        UpdateAdapter(monAns);
        monAnAdapter.notifyDataSetChanged();
        return true;
    }
    private ArrayList<MonAn> TimMonAnTheoTen(String tenMonAn){
        ArrayList<MonAn> list = new ArrayList<>();
        Cursor cursor = TrangChuActivity.database.GetData("SELECT * FROM MonAn WHERE TenKhongDau LIKE '"+tenMonAn+"'");
        while (cursor.moveToNext()){
            String ten = cursor.getString(1);
            String mota = cursor.getString(2);
            String hinh = cursor.getString(14);
            monAns.add(new MonAn(hinh,ten,mota));
        }
        return list;
    }
}
