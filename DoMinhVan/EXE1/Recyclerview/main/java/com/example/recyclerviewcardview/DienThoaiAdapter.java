package com.example.recyclerviewcardview;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class DienThoaiAdapter extends RecyclerView.Adapter<DienThoaiAdapter.ViewHolder> {
    //Tao mang chua du lieu
    ArrayList<DienThoai> arrayList;
    Context context;

    public DienThoaiAdapter(ArrayList<DienThoai> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.cardview_layout,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
            viewHolder.imgHinh.setImageResource(arrayList.get(i).getImgHinh());
            viewHolder.txtTen.setText(arrayList.get(i).getTxtTen());
            viewHolder.txtGia.setText(arrayList.get(i).getTxtGia());
    }

    @Override

    public int getItemCount() {
        return arrayList.size();
    }

    /*
    public void removeItem(int ViTri){
        arrayList.remove(ViTri);
        notifyItemRemoved(ViTri);
    }*/

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgHinh;
        TextView txtTen,txtGia;
        Button btnMuaHang, btnTragop;
        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            imgHinh = (ImageView) itemView.findViewById(R.id.imgHinh);
            txtTen = (TextView) itemView.findViewById(R.id.txtTen);
            txtGia = (TextView) itemView.findViewById(R.id.txtGia);
            btnMuaHang =(Button) itemView.findViewById(R.id.btnMuaHang);
            btnTragop = (Button) itemView.findViewById(R.id.btnTraGop);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   // removeItem(getAdapterPosition());
                   // Toast.makeText(context,"Remove" + txtTen.getText(),Toast.LENGTH_SHORT).show();
                    context = itemView.getContext();
                    Intent intent = new Intent(context, ChiTietActivity.class);
                    intent.putExtra("Ten",txtTen.getText());
                    intent.putExtra("Gia",txtGia.getText());
                    context.startActivity(intent);
                }
            });
            btnMuaHang.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context,"Mua Dien Thoai " + txtTen.getText(),Toast.LENGTH_SHORT).show();
                }
            });
            btnTragop.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context,"Tra Gop Dien Thoai " + txtTen.getText(),Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
