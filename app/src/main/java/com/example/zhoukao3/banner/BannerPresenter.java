package com.example.zhoukao3.banner;

import com.example.zhoukao3.bean.BannerBean;
import com.example.zhoukao3.inter.Apis;
import com.example.zhoukao3.inter.ICallBack;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class BannerPresenter {
    private  Bannermodel bannermodel;
    private BannerView bannerView;

    public  void attach(BannerView bannerView){
        this.bannerView=bannerView;
        bannermodel=new Bannermodel();

    }

    public  void getBannerP(String url){
        Type type=new TypeToken<BannerBean>(){}.getType();
        bannermodel.getBanner(Apis.BannerUrl, new ICallBack() {
            @Override
            public void onSuccess(Object obj) {
                BannerBean bannerBean= (BannerBean) obj;
                if (bannerBean!=null){
                    bannerView.getBanner(bannerBean);
                }
            }

            @Override
            public void onFailed(Exception e) {


            }
        },type);

    }
}
