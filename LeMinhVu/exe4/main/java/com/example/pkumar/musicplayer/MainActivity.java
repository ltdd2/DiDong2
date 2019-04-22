package com.example.pkumar.musicplayer;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Music> arrayList;
    private CustomMusicAdapter adapter;
    private ListView songList;
    Button feedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        songList = (ListView) findViewById(R.id.songList);
        arrayList = new ArrayList<>();
        arrayList.add(new Music("Hồng kông 1", "Nguyễn Trọng Tài", R.raw.hongkong1, R.drawable.hongkong1));
        arrayList.add(new Music("Buồn không em", "Đạt G", R.raw.buonkhongem2,R.drawable.datg));
        arrayList.add(new Music("Đưa nhau đi trốn","Đen vâu",R.raw.duanhau,R.drawable.denvau));
        arrayList.add(new Music("One way","One direction",R.raw.song1,R.drawable.oned));
        arrayList.add(new Music("Girl like you","Adam Levine",R.raw.girllikeu,R.drawable.adam));



        adapter = new CustomMusicAdapter(this, R.layout.custommusicitem, arrayList);
        songList.setAdapter(adapter);
    }
}