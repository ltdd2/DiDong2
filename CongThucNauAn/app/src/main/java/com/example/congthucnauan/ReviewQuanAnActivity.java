package com.example.congthucnauan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class ReviewQuanAnActivity extends AppCompatActivity {
    Toolbar toolbarReviewQuanAn;

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
    }
}
