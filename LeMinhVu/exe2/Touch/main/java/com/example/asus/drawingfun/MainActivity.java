package com.example.asus.drawingfun;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {
    private DrawingView drawingView;
    private ImageButton currPaint;
    Context context;
    ImageView imgXoa,imgMoi,imgVe,imgLuu,imgLoad;
    int REQUEST_CODE_FOLDER = 123;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       drawingView = (DrawingView)findViewById(R.id.drawing);
        LinearLayout paintLayout = (LinearLayout)findViewById(R.id.paint_colors);
        currPaint = (ImageButton)paintLayout.getChildAt(0);
        currPaint.setImageDrawable(getResources().getDrawable(R.drawable.paint_pressed));
        imgXoa = (ImageView) findViewById(R.id.imgXoa);
        imgMoi = (ImageView) findViewById(R.id.imgMoi);
        imgVe = (ImageView) findViewById(R.id.imgVe);
        imgLuu = (ImageView) findViewById(R.id.imgLuu);
        imgLoad = (ImageView) findViewById(R.id.imgLoad);
        imgXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawingView.setErase(true);
            }
        });
        imgVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawingView.setErase(false);
            }
        });
        imgLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    }
        });
        imgMoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawingView.Moi();
            }
        });
        imgLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
               // ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},REQUEST_CODE_FOLDER);
            startActivityForResult(intent,REQUEST_CODE_FOLDER);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE_FOLDER && requestCode == RESULT_OK && data != null){
            Uri  uri = data.getData();
            InputStream inputStream = null;
            try {
                inputStream = getContentResolver().openInputStream(uri);
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                Drawable  drawable = Drawable.createFromResourceStream(null,null,inputStream,null);
                drawingView.setBackground(drawable);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }
    }

    public void paintClicked(View view){
        //use chosen color
        if(view!=currPaint){
            //update color
            ImageButton imgView = (ImageButton)view;
            String color = view.getTag().toString();
            drawingView.setColor(color);

            imgView.setImageDrawable(getResources().getDrawable(R.drawable.paint_pressed));
            currPaint.setImageDrawable(getResources().getDrawable(R.drawable.paint));
            currPaint=(ImageButton)view;
        }
    }



}
