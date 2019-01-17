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

public class MlssAdapter  extends RecyclerView.Adapter<MlssAdapter.ViewHolder> {
    private Context context;
    private List<ShowBean.ResultBean.MlssBean.CommodityListBeanXX> list;

    public MlssAdapter(Context context, List<ShowBean.ResultBean.MlssBean.CommodityListBeanXX> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View  itemView=View.inflate(context, R.layout.item_mlss,null);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Glide.with(context).load(list.get(i).getMasterPic()).into(viewHolder.mlssImg);
        viewHolder.tvMlssName.setText(list.get(i).getCommodityName());
        viewHolder.tvMlssPrice.setText(list.get(i).getPrice()+"");

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvMlssName;
        private final TextView tvMlssPrice;
        private final ImageView mlssImg;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvMlssName = itemView.findViewById(R.id.tv_mlsh_name);
            tvMlssPrice = itemView.findViewById(R.id.tv_mlsh_price);
            mlssImg = itemView.findViewById(R.id.mlsh_img);

        }
    }
}
