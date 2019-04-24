package com.example.exe4;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvMp3;
    ArrayList<Mp3> mp3ArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_play);
        lvMp3 = (ListView) findViewById(R.id.lvMp3);
        mp3ArrayList = new ArrayList<>();
        mp3ArrayList.add(new Mp3("Nhac Nang",R.drawable.mp3,"destroy.wav"));
        mp3ArrayList.add(new Mp3("Noi Ay",R.drawable.b1,"b1.mp3"));
        mp3ArrayList.add(new Mp3("Mua Bang Gia",R.drawable.b2,"b1.mp3"));
        mp3ArrayList.add(new Mp3("Lạc Trôi",R.drawable.b3,"b1.mp3"));
        mp3ArrayList.add(new Mp3("Anh Nho Em",R.drawable.b4,"destroy.wav"));
        mp3ArrayList.add(new Mp3("Lang Nghe Nuoc Mat",R.drawable.b5,"b1.mp3"));
        mp3ArrayList.add(new Mp3("Bai Hat 7",R.drawable.mp3,"b1.mp3"));
        mp3ArrayList.add(new Mp3("Bai Hat 8",R.drawable.mp3,"b1.mp3"));
        mp3ArrayList.add(new Mp3("Bai Hat 9",R.drawable.mp3,"destroy.wav"));
        mp3ArrayList.add(new Mp3("Bai Hat 10",R.drawable.mp3,"b1.mp3"));
        mp3ArrayList.add(new Mp3("Bai Hat 11",R.drawable.mp3,"b1.mp3"));
        mp3ArrayList.add(new Mp3("Bai Hat 12",R.drawable.mp3,"b1.mp3"));
        mp3ArrayList.add(new Mp3("Bai Hat 13",R.drawable.mp3,"destroy.wav"));
        mp3ArrayList.add(new Mp3("Bai Hat 14",R.drawable.mp3,"b1.mp3"));
        mp3ArrayList.add(new Mp3("Bai Hat 15",R.drawable.mp3,"b1.mp3"));
        mp3ArrayList.add(new Mp3("Bai Hat 16",R.drawable.mp3,"b1.mp3"));
        mp3ArrayList.add(new Mp3("Bai Hat 17",R.drawable.mp3,"destroy.wav"));
        mp3ArrayList.add(new Mp3("Bai Hat 18",R.drawable.mp3,"b1.mp3"));
        mp3ArrayList.add(new Mp3("Bai Hat 19",R.drawable.mp3,"b1.mp3"));
        mp3ArrayList.add(new Mp3("Bai Hat 20",R.drawable.mp3,"b1.mp3"));
        ListviewAdapter listviewAdapter = new ListviewAdapter(this,R.layout.demo_play,mp3ArrayList);
        lvMp3.setAdapter(listviewAdapter);
    }
}