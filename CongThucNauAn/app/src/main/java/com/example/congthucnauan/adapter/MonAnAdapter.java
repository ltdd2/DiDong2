package com.example.congthucnauan.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.congthucnauan.ChiTietMonAnActivity;
import com.example.congthucnauan.R;
import com.example.congthucnauan.TrangChuActivity;
import com.example.congthucnauan.models.MonAn;
import java.util.ArrayList;
import de.hdodenhof.circleimageview.CircleImageView;
public class MonAnAdapter extends RecyclerView.Adapter<MonAnAdapter.ViewHolder> {
   ArrayList<MonAn> monAns;
   Context context;

   public MonAnAdapter(ArrayList<MonAn> monAns, Context context) {
       this.monAns = monAns;
       this.context = context;
   }

   @NonNull
   @Override
   public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
       View view = layoutInflater.inflate(R.layout.item_mon_an,viewGroup,false);
       return new ViewHolder(view);
   }
   @Override
   public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
       viewHolder.imgHinhMonAn.setImageBitmap(TrangChuActivity.database.getBitmapFromAssets(monAns.get(i).getImgHinhMonAn()));
       viewHolder.txtTenMonAn.setText(monAns.get(i).getTxtTenMonAn());
       viewHolder.txtMoTaMonAn.setText(monAns.get(i).getTxtMoTaMonAn());
   }

   @Override
   public int getItemCount() {
       return monAns.size();
   }

   public class ViewHolder extends RecyclerView.ViewHolder {
       CircleImageView imgHinhMonAn;
       TextView txtTenMonAn, txtMoTaMonAn;
       ImageView imgNew;

       public ViewHolder(@NonNull final View itemView) {
           super(itemView);
           imgHinhMonAn = (CircleImageView) itemView.findViewById(R.id.imgMonAn);
           txtMoTaMonAn = (TextView) itemView.findViewById(R.id.txtMoTaMAn);
           txtTenMonAn = (TextView) itemView.findViewById(R.id.txtTenMAn);
           imgNew = (ImageView) itemView.findViewById(R.id.imgNew);
           itemView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent i = new Intent(context, ChiTietMonAnActivity.class);
                   i.putExtra("Key",txtTenMonAn.getText());
                   context.startActivity(i);
               }
           });
           itemView.setOnLongClickListener(new View.OnLongClickListener() {
               @Override
               public boolean onLongClick(View v) {
                   if(TrangChuActivity.KiemTra == false){
                       Toast.makeText(context,"Ban Chua Dang Nhap", Toast.LENGTH_SHORT).show();
                   }else{
                       Toast.makeText(context, "Click", Toast.LENGTH_SHORT).show();
                   }
                   return true;
               }
           });
           Animation animation = AnimationUtils.loadAnimation(context,R.anim.recyclerview_anim);
           itemView.startAnimation(animation);
       }
   }
}
