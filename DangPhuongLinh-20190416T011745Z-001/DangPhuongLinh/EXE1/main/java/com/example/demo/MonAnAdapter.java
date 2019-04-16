package com.example.demo;

import android.content.Context;
import android.content.Intent;
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

public class MonAnAdapter extends RecyclerView.Adapter<MonAnAdapter.ViewHolder> {
    ArrayList<MonAn> monAnArrayList;
    Context context;

    public MonAnAdapter(ArrayList<MonAn> monAnArrayList, Context context) {
        this.monAnArrayList = monAnArrayList;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.cardview,viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.imgHinh.setImageResource(monAnArrayList.get(i).getImgHinh());
        viewHolder.txtTenMonAn.setText(monAnArrayList.get(i).getTxtTen());
    }

    @Override
    public int getItemCount() {
        return monAnArrayList.size();
    }
    public void removeItem(int ViTri){
        monAnArrayList.remove(ViTri);
        notifyItemRemoved(ViTri);
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgHinh;
        TextView txtTenMonAn;
        Button btnDatMon;
       public ViewHolder(@NonNull final View itemView) {
           super(itemView);
           imgHinh = (ImageView) itemView.findViewById(R.id.imgHinh);
           txtTenMonAn =(TextView) itemView.findViewById(R.id.txtTenMon);
           btnDatMon =(Button) itemView.findViewById(R.id.btnDatMon);
           itemView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   //removeItem(getAdapterPosition());
                   //Toast.makeText(context,"Da Xoa " + txtTenMonAn.getText(),Toast.LENGTH_SHORT).show();
                   context = itemView.getContext();
                   Intent intent = new Intent(itemView.getContext(), ChiTietActivity.class);
                   intent.putExtra("Ten",txtTenMonAn.getText());
                   context.startActivity(intent);
               }
           });
           btnDatMon.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Toast.makeText(context,"Ban Da Dat Mon  " + txtTenMonAn.getText(),Toast.LENGTH_SHORT).show();
               }
           });
       }

   }
}
