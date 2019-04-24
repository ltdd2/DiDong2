package com.example.chamsocvalamdep.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.chamsocvalamdep.Model.danhMuc;
import java.util.ArrayList;
import com.example.chamsocvalamdep.R;
import de.hdodenhof.circleimageview.CircleImageView;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {

    // Các thuộc tính
    private ArrayList<danhMuc> listFunction;  // Danh sách
    private Context context;   // Màn hình hiện tại
    private LayoutInflater inflater;


    // Phương thức khởi tạo
    public HomeAdapter(Context context, ArrayList<danhMuc> list) {
        this.context = context;
        this.listFunction = list;
        inflater = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        // Liên kết với giao diện item
        View itemView = inflater.inflate(R.layout.list_item_home, viewGroup, false);
        return new ViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        // Lấy từ hiện tại
        final danhMuc dm = listFunction.get(i);


        // Set từng giá trị lên item

        viewHolder.imgicon.setImageResource(dm.getHinhAnh());
        viewHolder.tvdanhmuc.setText(dm.getTenDanhMuc());
        viewHolder.tvtonghop.setText(dm.getTongHopPhuongPhap());


        // Bắt sự kiện nhấn vào một item
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickedListener.onItemClick(dm.getIdDanhMuc());
            }
        });
    }

    @Override
    public int getItemCount() {
        return listFunction.size();
    }


    // Tạo ra một view holder
    class ViewHolder extends RecyclerView.ViewHolder {


        private CircleImageView imgicon;
        private TextView tvdanhmuc;
        private TextView tvtonghop;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgicon = (CircleImageView) itemView.findViewById(R.id.imgicon);
            tvdanhmuc = (TextView) itemView.findViewById(R.id.tvdanhmuc);
            tvtonghop = (TextView) itemView.findViewById(R.id.tvtonghop);
        }
    }


    // Khai báo một phương thức  để ta có thể gọi nó bên ngoài để lấy được dữ liệu
    public interface OnItemClickedListener {
        void onItemClick(int idFunction);

    }

    // Khai báo một biến interface
    private OnItemClickedListener onItemClickedListener;

    // Tạo setter cho biến interface ta vừa tạo
    public void setOnItemClickedListener(OnItemClickedListener onItemClickedListener) {

        this.onItemClickedListener = onItemClickedListener;
    }

}
