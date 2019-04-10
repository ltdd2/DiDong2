package com.example.congthucnauan;


import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.example.congthucnauan.adapter.MonAnNewAdapter;
import com.example.congthucnauan.adapter.QuanAnAdapter;
import com.example.congthucnauan.database.Database;
import com.example.congthucnauan.models.MonAn;
import com.example.congthucnauan.models.QuanAn;

import java.util.ArrayList;

public class TrangChuActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    Toolbar toolbar;
    RecyclerView reMonAn,reQuanAn;
    MonAnNewAdapter monAnAdapter;
    QuanAnAdapter quanAnAdapter;
    ArrayList<QuanAn> quanAns;
    ArrayList<MonAn> monAns;
    ViewFlipper viewFlipper;
    Animation in ,out;
    String[] hinh={"goimuc","goioc","goitom"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trang_chu_layout);
        //Toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(R.string.trangchu);
        drawerLayout = (DrawerLayout) findViewById(R.id.draw_layout);
        NavigationView navigationView = findViewById(R.id.navigation);
        navigationView.setNavigationItemSelectedListener(this);
        //Chuyển hình
        viewFlipper = findViewById(R.id.viewFliper);
        for ( int i = 0; i<hinh.length;i++){
            ImageView img = new ImageView(this);
            Uri imgUri = Uri.parse("android.resource://com.example.congthucnauan" + "/drawable/" + hinh[i]);
            img.setImageURI(imgUri);
            img.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipper.addView(img);
        }
        in = AnimationUtils.loadAnimation(this,R.anim.in);
        out = AnimationUtils.loadAnimation(this,R.anim.out);
        viewFlipper.setInAnimation(in);
         viewFlipper.setOutAnimation(out);
        viewFlipper.setFlipInterval(3000);
        viewFlipper.setAutoStart(true);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //Recyclerview  mon an
        reMonAn = (RecyclerView) findViewById(R.id.reMonAn);
        reMonAn.setLayoutManager(new GridLayoutManager(this,2));
        monAns = new ArrayList<MonAn>();
       for (int i = 0 ; i< DuLieuMonAn.imgHinh.length; i++){
           monAns.add(new MonAn(DuLieuMonAn.imgHinh[i],DuLieuMonAn.txtTenMonAn[i],DuLieuMonAn.txtMoTaMonAn[i]));
       }
      /* Cursor  data = ManHinhChaoActivity.database.GetData("SELECT * FROM MonAn");
       while (data.moveToNext()){
           String hinh = data.getString(10);
           monAns.add(new MonAn(hinh,"mon 1","mo ta 1"));
       }*/
        monAnAdapter = new MonAnNewAdapter(monAns,this);
        monAnAdapter.notifyDataSetChanged();
        reMonAn.setAdapter(monAnAdapter);
        reMonAn.setItemAnimator(new DefaultItemAnimator());

        //Recycle quan an
        reQuanAn = (RecyclerView) findViewById(R.id.reQuanAn);
        reQuanAn.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        reQuanAn.setLayoutManager(linearLayoutManager);
        quanAns = new ArrayList<>();
        for(int i = 0; i< DuLieuQuanAn.imgHinhQuanAn.length;i++){
            quanAns.add(new QuanAn(DuLieuQuanAn.imgHinhQuanAn[i],DuLieuQuanAn.txtTenQuanAn[i],DuLieuQuanAn.txtDiaChi[i]));
        }
        quanAnAdapter =  new QuanAnAdapter(quanAns,this);
        reQuanAn.setAdapter(quanAnAdapter);
        reQuanAn.setItemAnimator(new DefaultItemAnimator());
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(actionBarDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return onOptionsItemSelected(item);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.montrangmieng:
                Intent intent = new Intent(TrangChuActivity.this,DanhSachMonAnActivity.class);
                intent.putExtra("Key","Món Tráng Miệng");
                startActivity(intent);
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            case R.id.monxao:
                Intent intent1 = new Intent(TrangChuActivity.this,DanhSachMonAnActivity.class);
                intent1.putExtra("Key","Món Xào");
                startActivity(intent1);
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            case R.id.monlau:
                Intent intent2 = new Intent(TrangChuActivity.this,DanhSachMonAnActivity.class);
                intent2.putExtra("Key","Món Lẩu");
                startActivity(intent2);
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            case R.id.monkho:
                Intent intent3 = new Intent(TrangChuActivity.this,DanhSachMonAnActivity.class);
                intent3.putExtra("Key","Món Kho");
                startActivity(intent3);
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            case R.id.monchien:
                Intent intent4 = new Intent(TrangChuActivity.this,DanhSachMonAnActivity.class);
                intent4.putExtra("Key","Món Chiên");
                startActivity(intent4);
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            case R.id.quanan:
                Intent intent5 = new Intent(TrangChuActivity.this,QuanAnActivity.class);
                intent5.putExtra("Key","DANH SÁCH QUÁN ĂN");
                startActivity(intent5);
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            case R.id.thoat:
                finish();
                break;
        }

        return true;
    }
}
