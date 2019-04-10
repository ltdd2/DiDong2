package com.example.setting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity {
        Button btnNew,btnChoiLai,btnTongDiem,btnThoat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_layout);
        btnNew = (Button) findViewById(R.id.btnNew);
        btnChoiLai = (Button) findViewById(R.id.btnChoiLai);
        btnTongDiem = (Button) findViewById(R.id.btnTongDiem);
        btnThoat = (Button) findViewById(R.id.btnThoat);
        btnNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(GameActivity.this,"Game Moi",Toast.LENGTH_SHORT).show();
            }
        });
        btnChoiLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(GameActivity.this,"Choi Lai",Toast.LENGTH_SHORT).show();
            }
        });
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(GameActivity.this,"Thoat",Toast.LENGTH_SHORT).show();
            }
        });
        btnTongDiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(GameActivity.this,"Tong Diem",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
