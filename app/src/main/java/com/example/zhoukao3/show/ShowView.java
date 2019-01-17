package com.example.zhoukao3.show;

import com.example.zhoukao3.bean.ShowBean;

import java.util.List;


public interface ShowView {
    void  getRxxp(List<ShowBean.ResultBean.RxxpBean> rxxpBeans);
    void  getPzsh(List<ShowBean.ResultBean.PzshBean> pzssBeans);
    void  getMlss(List<ShowBean.ResultBean.MlssBean> mlssBeans);
    void  failed(Exception e);
}
