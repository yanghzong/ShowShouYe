package com.example.zhoukao3.show;

import com.example.zhoukao3.inter.ICallBack;
import com.example.zhoukao3.utils.HttpUtils;

import java.lang.reflect.Type;

public class ShowModel {
    public  void  getShow(String url, ICallBack callBack, Type type){
        HttpUtils.getInstance().get(url,callBack,type);
    }
}
