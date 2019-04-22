package com.example.exe4;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ListviewAdapter extends BaseAdapter {

    Context context;
    int layout;
    List<Mp3>  list;




    public ListviewAdapter(Context context, int layout, List<Mp3> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView =  layoutInflater.inflate(R.layout.dong_listview,null);
        TextView txtTenBh = (TextView) convertView.findViewById(R.id.txtTenBaiHat);
        final ImageView imgMp3 = (ImageView) convertView.findViewById(R.id.imgMp3);
        txtTenBh.setText(list.get(position).getTxtTenBaiHat());
        imgMp3.setImageResource(list.get(position).getImgHinh());
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent intent = new Intent(context,ChiTiet.class);
              Bundle bundle = new Bundle();
              bundle.putString("ten",list.get(position).getTxtTenBaiHat());
              intent.putExtra("BH",bundle);
              bundle.putInt("hinh",list.get(position).getImgHinh());
              context.startActivity(intent);
            }
        });
        Animation animation = AnimationUtils.loadAnimation(context,R.anim.scale);
        convertView.setAnimation(animation);
        return convertView;
    }
}
