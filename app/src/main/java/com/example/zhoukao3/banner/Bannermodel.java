package com.example.zhoukao3.banner;

import com.example.zhoukao3.inter.ICallBack;
import com.example.zhoukao3.utils.HttpUtils;

import java.lang.reflect.Type;

public class Bannermodel {
    public  void  getBanner(String url, ICallBack callBack, Type type){
        HttpUtils.getInstance().get(url,callBack,type);
    }
}
