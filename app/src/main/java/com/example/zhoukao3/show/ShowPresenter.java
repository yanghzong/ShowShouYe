package com.example.zhoukao3.show;

import com.example.zhoukao3.banner.BannerView;
import com.example.zhoukao3.banner.Bannermodel;
import com.example.zhoukao3.bean.BannerBean;
import com.example.zhoukao3.bean.ShowBean;
import com.example.zhoukao3.inter.Apis;
import com.example.zhoukao3.inter.ICallBack;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class ShowPresenter {
    private ShowModel showModel;
    private ShowView  showView;

    public  void attach(ShowView showView){
        this.showView=showView;
        showModel=new ShowModel();

    }

    public  void getShowP(String url){
        Type type=new TypeToken<ShowBean>(){}.getType();
        showModel.getShow( url,new ICallBack() {
            @Override
            public void onSuccess(Object obj) {
                ShowBean showBean= (ShowBean) obj;
                showView.getMlss(showBean.getResult().getMlss());
                showView.getRxxp(showBean.getResult().getRxxp());
                showView.getPzsh(showBean.getResult().getPzsh());
            }

            @Override
            public void onFailed(Exception e) {


            }
        },type);

    }
}
