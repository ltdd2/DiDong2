package com.example.recyclerviewcardview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ChiTietActivity extends AppCompatActivity {
TextView txtTenChiTiet, txtGiaChiTiet, txtQuayLai;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chi_tiet_layout);
        txtTenChiTiet = (TextView) findViewById(R.id.txtTenChiTiet);
        txtGiaChiTiet = (TextView) findViewById(R.id.txtGiaChiTiet);
        txtQuayLai = (TextView) findViewById(R.id.txtQuayLai);

        final Intent intent = getIntent();
        txtTenChiTiet.setText(intent.getStringExtra("Ten"));
        txtGiaChiTiet.setText(intent.getStringExtra("Gia"));

        txtQuayLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(ChiTietActivity.this,RecyclerviewCardviewActivity.class);
                startActivity(intent1);
            }
        });
    }
}
