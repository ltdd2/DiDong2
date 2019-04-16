package com.example.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ChiTietActivity extends AppCompatActivity {
    TextView txtTenMonAn,txtQuayLai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chi_tiet_layout);
        txtTenMonAn = (TextView) findViewById(R.id.txtTenMonAn);
        txtQuayLai = (TextView) findViewById(R.id.txtQuayLai);
        final Intent intent = getIntent();
        txtTenMonAn.setText(intent.getStringExtra("Ten"));
        txtQuayLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chitiet = new Intent(ChiTietActivity.this,RecyclerviewCardviewActivity.class);
                startActivity(chitiet);
            }
        });
    }
}
