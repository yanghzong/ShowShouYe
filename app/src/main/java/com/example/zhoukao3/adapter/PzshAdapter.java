package com.example.zhoukao3.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.zhoukao3.R;
import com.example.zhoukao3.bean.ShowBean;

import java.util.List;

public class PzshAdapter  extends RecyclerView.Adapter<PzshAdapter.ViewHolder>{
    private Context context;
    private List<ShowBean.ResultBean.PzshBean.CommodityListBeanX> list;

    public PzshAdapter(Context context, List<ShowBean.ResultBean.PzshBean.CommodityListBeanX> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View  itemView=View.inflate(context, R.layout.item_pzss,null);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Glide.with(context).load(list.get(i).getMasterPic()).into(viewHolder.pzshImg);
        viewHolder.tvPzshName.setText(list.get(i).getCommodityName());
        viewHolder.tvPzshPrice.setText(list.get(i).getPrice()+"");
    }



    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvPzshName;
        private final TextView tvPzshPrice;
        private final ImageView pzshImg;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvPzshName = itemView.findViewById(R.id.tv_pzsh_name);
            tvPzshPrice = itemView.findViewById(R.id.tv_pzsh_price);
             pzshImg = itemView.findViewById(R.id.pzsh_img);

        }
    }
}
