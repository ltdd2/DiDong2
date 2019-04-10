package com.example.demoexe4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class DSVideo extends AppCompatActivity {
    ListView lvVideo;
    ArrayList<Video> mp3ArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dsvideo);
        lvVideo = (ListView) findViewById(R.id.lvVideo);
        mp3ArrayList = new ArrayList<>();
        mp3ArrayList.add(new Video("Bai Hat 1",R.drawable.mp3,"b1"));
        mp3ArrayList.add(new Video("Bai Hat 2",R.drawable.mp3,"b3"));
        ListViewAdapter listviewAdapter = new ListViewAdapter(this,R.layout.activity_dsvideo,mp3ArrayList);
        lvVideo.setAdapter(listviewAdapter);
    }
}
