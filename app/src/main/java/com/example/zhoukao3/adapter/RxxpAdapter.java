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

public class RxxpAdapter  extends RecyclerView.Adapter<RxxpAdapter.ViewHolder>{
    private Context context;
    private List<ShowBean.ResultBean.RxxpBean.CommodityListBean> list;

    public RxxpAdapter(Context context, List<ShowBean.ResultBean.RxxpBean.CommodityListBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView=View.inflate(context, R.layout.item_rxxp,null);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Glide.with(context).load(list.get(i).getMasterPic()).into(viewHolder.rxxpImg);
        viewHolder.tvRxxpName.setText(list.get(i).getCommodityName());
        viewHolder.tvRxxpPrice.setText(list.get(i).getPrice()+"");

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvRxxpName;
        private final TextView tvRxxpPrice;
        private final ImageView rxxpImg;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvRxxpName = itemView.findViewById(R.id.tv_rxxp_name);
            tvRxxpPrice = itemView.findViewById(R.id.tv_rxxp_price);
            rxxpImg = itemView.findViewById(R.id.rxxp_img);

        }
    }
}
