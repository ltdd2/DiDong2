package com.example.recyclerviewcardview;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerviewCardviewActivity extends AppCompatActivity implements SensorEventListener {
    RecyclerView recyclerView;
    TextView txtSoLuong;
    SensorManager sensorManager;
    long tgianTruoc;
    boolean color = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview_cardview);
        recyclerView =  (RecyclerView) findViewById(R.id.recyclerview);
        txtSoLuong = (TextView) findViewById(R.id.txtSoluong);

        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),DividerItemDecoration.VERTICAL);
        Drawable drawable = ContextCompat.getDrawable(getApplicationContext(),R.drawable.custom_divider);
        dividerItemDecoration.setDrawable(drawable);

        recyclerView.addItemDecoration(dividerItemDecoration);

        final ArrayList<DienThoai> dienThoais = new ArrayList<>();
            for(int i = 0 ; i < Data.txtTen.length;i++){
               dienThoais.add(new DienThoai(Data.imgHinh[i],Data.txtTen[i],Data.txtGia[i]));
         }

        final DienThoaiAdapter dienThoaiAdapter = new DienThoaiAdapter(dienThoais,getApplicationContext());
        recyclerView.setAdapter(dienThoaiAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        tgianTruoc = System.currentTimeMillis();
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER){
            layVecTorvathaydoitext(event);
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
    public void layVecTorvathaydoitext(SensorEvent event){
        float[] values = event.values;
        float x = values[0];
        float y = values[1];
        float z = values[2];
        float vector = ( x*x + y*y + z*z )/(SensorManager.GRAVITY_EARTH * SensorManager.GRAVITY_EARTH);
        if (vector >= 2){
            long tgSau = event.timestamp;
            if((tgSau - tgianTruoc) > 200){
                txtSoLuong.setText("Ban Da Lac DT");
                txtSoLuong.setBackgroundColor(Color.RED);
            }
            tgianTruoc = tgSau;
            color = true;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this,sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),SensorManager.SENSOR_DELAY_NORMAL);
    }


    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

}
