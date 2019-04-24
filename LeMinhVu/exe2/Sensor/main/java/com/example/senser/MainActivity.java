package com.example.senser;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  implements SensorEventListener {
    SensorManager sensorManager;
    long tgianTruoc;
    boolean color = false;
    int i = 1;
    LinearLayout view;
    ImageView imgHinh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        tgianTruoc = System.currentTimeMillis();
        view = (LinearLayout) findViewById(R.id.view);
        imgHinh = (ImageView) findViewById(R.id.imgHinh);
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
            if((tgSau - tgianTruoc) > 400){
                    i++;
                    view.setBackgroundColor(Color.RED);
                    if(i == 3 ){
                        imgHinh.setImageResource(R.drawable.dt1);
                        view.setBackgroundColor(Color.BLUE);
                    }
                    if(i == 4 ){
                        imgHinh.setImageResource(R.drawable.dt2);
                        view.setBackgroundColor(Color.YELLOW);
                    }
                    if(i == 5 ){
                        imgHinh.setImageResource(R.drawable.dt3);
                        view.setBackgroundColor(Color.DKGRAY);
                    }
                    if(i == 6 ){
                        imgHinh.setImageResource(R.drawable.dt4);
                        view.setBackgroundColor(Color.GREEN);
                    }
                    if(i == 7 ){
                        imgHinh.setImageResource(R.drawable.dt5);
                        view.setBackgroundColor(Color.GRAY);
                        i = 1;
                    }
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
