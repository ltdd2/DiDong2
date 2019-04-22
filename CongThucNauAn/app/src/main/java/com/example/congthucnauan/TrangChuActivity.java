package com.example.congthucnauan;



import android.app.Dialog;
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
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.example.congthucnauan.adapter.MonAnNewAdapter;
import com.example.congthucnauan.adapter.QuanAnAdapter;
import com.example.congthucnauan.adapter.VideoAdapter;
import com.example.congthucnauan.database.Database;
import com.example.congthucnauan.models.MonAn;
import com.example.congthucnauan.models.QuanAn;
import com.example.congthucnauan.models.Video;
import java.util.ArrayList;
import java.util.List;

public class TrangChuActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    Toolbar toolbar;
    RecyclerView reMonAn,reQuanAn,reVideo;
    MonAnNewAdapter monAnAdapter;
    QuanAnAdapter quanAnAdapter;
    VideoAdapter videoAdapter;
    ArrayList<QuanAn> quanAns;
    List<MonAn> monAns;
    ArrayList<Video> videos;
    ViewFlipper viewFlipper;
    Animation in ,out;
    ArrayList<String> hinh;
    public static Database database;
    public static boolean KiemTra = false;
    Cursor c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trang_chu_layout);
        //Database
        database = new Database(this);
        database.createDatabase();
        //Toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(R.string.trangchu);
        drawerLayout = (DrawerLayout) findViewById(R.id.draw_layout);
        NavigationView navigationView = findViewById(R.id.navigation);
        navigationView.setNavigationItemSelectedListener(this);
        //Chuyển hình
        hinh = new ArrayList<>();
        Cursor cursor = database.GetData("SELECT * FROM MonAn");
        while (cursor.moveToNext()){
            String img = cursor.getString(14);
            hinh.add(img);
        }
        viewFlipper = findViewById(R.id.viewFliper);
        for ( int i = 0; i<hinh.size();i++){
            ImageView img = new ImageView(this);
            img.setImageBitmap(database.getBitmapFromAssets(hinh.get(i).toString()));
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
        //Get data
        Cursor monan = database.GetData("SELECT * FROM MonAn");
        while (monan.moveToNext()){
            String ten = monan.getString(1);
            String mota = monan.getString(2);
            String hinh = monan.getString(14);
           monAns.add(new MonAn(hinh,ten,mota));
        }
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
        Cursor qAn = TrangChuActivity.database.GetData("SELECT * FROM QuanAn");
        while (qAn.moveToNext()){
            String ten = qAn.getString(1);
            String hinh = qAn.getString(2);
            String diachi  = qAn.getString(6);
            quanAns.add(new QuanAn(hinh,ten,diachi));
        }
        quanAnAdapter =  new QuanAnAdapter(quanAns,this);
        reQuanAn.setAdapter(quanAnAdapter);
        reQuanAn.setItemAnimator(new DefaultItemAnimator());
        //video
        reVideo = (RecyclerView) findViewById(R.id.reVideo);
        videos = new ArrayList<>();
        Cursor v = TrangChuActivity.database.GetData("SELECT * FROM Video");
        while (v.moveToNext()){
            String ten = v.getString(1);
            String hinh = v.getString(2);
            String tenkd  = v.getString(3);
            videos.add(new Video(ten,hinh,tenkd));
        }
        videoAdapter = new VideoAdapter(videos,this);
        reVideo.setLayoutManager(new GridLayoutManager(this,2));
        reVideo.setAdapter(videoAdapter);
        reVideo.setItemAnimator(new DefaultItemAnimator());
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(actionBarDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        switch (item.getItemId()){
            case R.id.mnuLogin:
                DangNhap();
                return true;
                default:
                    return onOptionsItemSelected(item);
        }
    }

    private void DangNhap() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_dang_nhap_layout);
        dialog.setCanceledOnTouchOutside(false);
        final EditText edtTenDN = dialog.findViewById(R.id.edtTenDangNhap);
        final EditText edtMatKhau = dialog.findViewById(R.id.edtMatKhau);
        final Button  btnDangNhap = dialog.findViewById(R.id.btnDangNhap);
        final Button btnHuy = dialog.findViewById(R.id.btnHuy);
        final Button btnDangXuat = dialog.findViewById(R.id.btnDangXuat);
        final TextView txtDangNhap = dialog.findViewById(R.id.txtDangNhap);
        final Button btnThoat = dialog.findViewById(R.id.btnThoat);
        //Database
        c = database.GetData("SELECT *  FROM NguoiDung");
        if (KiemTra == true) {
            btnDangNhap.setVisibility(View.GONE);
            btnHuy.setVisibility(View.GONE);
            btnDangXuat.setVisibility(View.VISIBLE);
            edtMatKhau.setVisibility(View.GONE);
            edtTenDN.setVisibility(View.GONE);
            btnThoat.setVisibility(View.VISIBLE);
            txtDangNhap.setText("Xin Chao: Do Minh Van");
        }
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    while (c.moveToNext()){
                        if(edtTenDN.getText().toString().equals("van") && edtMatKhau.getText().toString().equals("123")){
                            Toast.makeText(TrangChuActivity.this,"Dang Nhap Thanh Cong",Toast.LENGTH_SHORT).show();
                            KiemTra = true;
                            dialog.dismiss();
                        }else {
                            Toast.makeText(TrangChuActivity.this,"Đăng Nhập Thất Bại",Toast.LENGTH_SHORT).show();
                        }

                }
            }
        });
        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        btnDangXuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KiemTra = false;
                btnDangXuat.setVisibility(View.GONE);
                btnDangNhap.setVisibility(View.VISIBLE);
                btnHuy.setVisibility(View.VISIBLE);
                edtMatKhau.setVisibility(View.VISIBLE);
                edtTenDN.setVisibility(View.VISIBLE);
                txtDangNhap.setText("ĐĂNG NHẬP");
                btnThoat.setVisibility(View.GONE);
            }
        });
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
    private void DangXuat(){
        final Dialog dlog = new Dialog(this);
        dlog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dlog.setContentView(R.layout.dialog_dang_xuat_layout);
        dlog.setCanceledOnTouchOutside(false);
        final Button  btnYes = dlog.findViewById(R.id.btnYes);
        final Button btnNo = dlog.findViewById(R.id.btnNo);
        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TrangChuActivity.this, "Bạn Vẫn Ở Trang Này", Toast.LENGTH_SHORT).show();
                dlog.dismiss();
            }
        });
        dlog.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.login,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.montrangmieng:
                Intent intent = new Intent(TrangChuActivity.this,DanhSachMonAnActivity.class);
                intent.putExtra("Key","Món Tráng Miệng");
                intent.putExtra("ID",1);
                startActivity(intent);
                overridePendingTransition(R.anim.in,R.anim.out);
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            case R.id.monxao:
                Intent intent1 = new Intent(TrangChuActivity.this,DanhSachMonAnActivity.class);
                intent1.putExtra("Key","Món Xào");
                intent1.putExtra("ID",2);
                startActivity(intent1);
                overridePendingTransition(R.anim.in,R.anim.out);
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            case R.id.monlau:
                Intent intent2 = new Intent(TrangChuActivity.this,DanhSachMonAnActivity.class);
                intent2.putExtra("Key","Món Lẩu");
                intent2.putExtra("ID",3);
                startActivity(intent2);
                overridePendingTransition(R.anim.in,R.anim.out);
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            case R.id.monkho:
                Intent intent3 = new Intent(TrangChuActivity.this,DanhSachMonAnActivity.class);
                intent3.putExtra("Key","Món Kho");
                intent3.putExtra("ID",4);
                startActivity(intent3);
                overridePendingTransition(R.anim.in,R.anim.out);
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            case R.id.monchien:
                Intent intent4 = new Intent(TrangChuActivity.this,DanhSachMonAnActivity.class);
                intent4.putExtra("Key","Món Chiên");
                intent4.putExtra("ID",5);
                startActivity(intent4);
                overridePendingTransition(R.anim.in,R.anim.out);
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            case R.id.quanan:
                Intent intent5 = new Intent(TrangChuActivity.this,QuanAnActivity.class);
                intent5.putExtra("Key","DANH SÁCH QUÁN ĂN");
                intent5.putExtra("ID",6);
                startActivity(intent5);
                overridePendingTransition(R.anim.in,R.anim.out);
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            case R.id.video:
                Intent intent6 = new Intent(TrangChuActivity.this,ManHinhVideoActivity.class);
                intent6.putExtra("Key","VIDEO HƯỚNG DẪN NẤU ĂN");
                intent6.putExtra("ID",7);
                startActivity(intent6);
                overridePendingTransition(R.anim.in,R.anim.out);
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            case R.id.thoat:
                DangXuat();
                break;
        }
        return true;
    }

}
