package com.example.zhoukao3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.zhoukao3.adapter.MlssAdapter;
import com.example.zhoukao3.adapter.PzshAdapter;
import com.example.zhoukao3.adapter.RxxpAdapter;
import com.example.zhoukao3.banner.BannerPresenter;
import com.example.zhoukao3.banner.BannerView;
import com.example.zhoukao3.bean.BannerBean;
import com.example.zhoukao3.bean.ShowBean;
import com.example.zhoukao3.inter.Apis;
import com.example.zhoukao3.show.ShowPresenter;
import com.example.zhoukao3.show.ShowView;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity implements BannerView ,ShowView {
    @BindView(R.id.xb_banner)
    XBanner  xbBanner;
    @BindView(R.id.rv_mlss)
    RecyclerView  rvMlss;
    @BindView(R.id.rv_rxxp)
    RecyclerView  rvRxxp;
    @BindView(R.id.rv_pzsh)
    RecyclerView  rvPzsh;

    private Unbinder bind;
    private ShowPresenter showPresenter;
    private List<ShowBean.ResultBean.RxxpBean.CommodityListBean> rxxplist;
    private List<ShowBean.ResultBean.MlssBean.CommodityListBeanXX> mlsslist;
    private List<ShowBean.ResultBean.PzshBean.CommodityListBeanX> pzshlist;
    private RxxpAdapter rxxpAdapter;
    private MlssAdapter mlssAdapter;
    private PzshAdapter pzshAdapter;
    private BannerPresenter bannerPresenter;
    private List<BannerBean.ResultBean> bannerlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bind = ButterKnife.bind(this, this);
        //初始化p层
        showPresenter = new ShowPresenter();
        showPresenter.attach(this);
        showPresenter.getShowP(Apis.ShowUrl);
        bannerPresenter = new BannerPresenter();
        bannerPresenter.attach(this);
        bannerPresenter.getBannerP(Apis.BannerUrl);

        //rxxp
        rxxplist = new ArrayList<>();
        rvRxxp.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        rxxpAdapter = new RxxpAdapter(this,rxxplist);
        rvRxxp.setAdapter(rxxpAdapter);
        //mlss
        mlsslist = new ArrayList<>();
        rvMlss.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        mlssAdapter = new MlssAdapter(this,mlsslist);
        rvMlss.setAdapter(mlssAdapter);
        //pzsh
        pzshlist = new ArrayList<>();
        rvPzsh.setLayoutManager(new GridLayoutManager(this,2));
        pzshAdapter = new PzshAdapter(this,pzshlist);
        rvPzsh.setAdapter(pzshAdapter);


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bind.unbind();
    }

    @Override
    public void getBanner(BannerBean bean) {
        if (bean  instanceof BannerBean){
            BannerBean banner1= (BannerBean) bean;
            xbBanner.setData(banner1.getResult(),null);
            xbBanner.loadImage(new XBanner.XBannerAdapter() {
                @Override
                public void loadBanner(XBanner banner, Object model, View view, int position) {
                    BannerBean.ResultBean bean= (BannerBean.ResultBean) model;
                    Glide.with(MainActivity.this).load(bean.getImageUrl()).into((ImageView) view);
                    banner.setPageChangeDuration(1000);
                }
            });
        }



    }

    @Override
    public void getRxxp(List<ShowBean.ResultBean.RxxpBean> rxxpBeans) {

        if (rxxplist != null) {
            for (ShowBean.ResultBean.RxxpBean mlssBean : rxxpBeans) {
                rxxplist.clear();
                rxxplist.addAll(mlssBean.getCommodityList());
                rxxpAdapter.notifyDataSetChanged();
            }
        }



    }

    @Override
    public void getPzsh(List<ShowBean.ResultBean.PzshBean> pzssBeans) {
        if (pzssBeans != null) {
            for (ShowBean.ResultBean.PzshBean pzshBean : pzssBeans) {
                pzshlist.clear();
                pzshlist.addAll(pzshBean.getCommodityList());
                pzshAdapter.notifyDataSetChanged();
            }
        }
    }



    @Override
    public void getMlss(List<ShowBean.ResultBean.MlssBean> mlssBeans) {
        if (mlssBeans != null) {
            for (ShowBean.ResultBean.MlssBean mlssBean : mlssBeans) {
                mlsslist.clear();
                mlsslist.addAll(mlssBean.getCommodityList());
                mlssAdapter.notifyDataSetChanged();
            }
        }
    }



    @Override
    public void failed(Exception e) {

    }
}
