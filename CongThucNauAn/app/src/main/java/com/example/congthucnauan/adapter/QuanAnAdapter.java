package com.example.congthucnauan.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.congthucnauan.R;
import com.example.congthucnauan.ReviewQuanAnActivity;
import com.example.congthucnauan.TrangChuActivity;
import com.example.congthucnauan.models.QuanAn;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class QuanAnAdapter extends RecyclerView.Adapter<QuanAnAdapter.ViewHolder> {
   ArrayList<QuanAn> quanAns;
   Context context;

   public QuanAnAdapter(ArrayList<QuanAn> quanAns , Context context) {
       this.quanAns = quanAns;
       this.context = context;
   }

   @NonNull
   @Override
   public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
       View view = layoutInflater.inflate(R.layout.item_quan_an_layout,viewGroup,false);
       return new ViewHolder(view);
   }
   @Override
   public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
     //  Uri imgUri = Uri.parse("android.resource://com.example.congthucnauan" + "/drawable/" + quanAns.get(i).getImgHinhQuanAn());
       viewHolder.imgHinhQuanAn.setImageBitmap(TrangChuActivity.database.getBitmapFromAssets(quanAns.get(i).getImgHinhQuanAn()));
       viewHolder.txtTenQuanAn.setText(quanAns.get(i).getTxtTenQuanAn());
       viewHolder.txtDiaChi.setText(quanAns.get(i).getTxtDiaChi());
   }

   @Override
   public int getItemCount() {
       return quanAns.size();
   }

   public class ViewHolder extends RecyclerView.ViewHolder {
       CircleImageView imgHinhQuanAn;
       TextView txtTenQuanAn,txtDiaChi;

       public ViewHolder(@NonNull final View itemView) {
           super(itemView);
           imgHinhQuanAn = (CircleImageView) itemView.findViewById(R.id.imgHinhQuanAn);
           txtTenQuanAn = (TextView) itemView.findViewById(R.id.txtTenQuanAn);
           txtDiaChi = (TextView) itemView.findViewById(R.id.txtDiaChiQuanAn);
           itemView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent intent = new Intent(context, ReviewQuanAnActivity.class);
                   intent.putExtra("Key",txtTenQuanAn.getText());
                   context.startActivity(intent);
               }
           });
       }
   }
}
