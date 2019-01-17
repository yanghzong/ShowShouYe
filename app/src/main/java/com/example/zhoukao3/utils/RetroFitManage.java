package com.example.zhoukao3.utils;

import android.util.Log;

import com.example.zhoukao3.inter.ICallBack;
import com.example.zhoukao3.inter.MyInterFace;

import java.lang.reflect.Type;
import java.util.Observable;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroFitManage {
   /* private static  volatile   RetroFitManage  instance;
    private final Retrofit.Builder builder;
    private final OkHttpClient client;
    private MyInterFace myInterFace;


    private RetroFitManage(){

        //设置日志拦截器
        HttpLoggingInterceptor.Level level=HttpLoggingInterceptor.Level.BODY;

        HttpLoggingInterceptor httpLoggingInterceptor=new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                //打印
                Log.i("http", "log: "+message);
            }
        });
        httpLoggingInterceptor.setLevel(level);
        client = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build();

        //将client对象放入retrofit中
        //创建retrofit对象

        builder = new Retrofit.Builder();
        //设置json转换
        builder.addConverterFactory(GsonConverterFactory.create());
        builder.client(client);



    }
    public  static  RetroFitManage getInstance(){
        if (instance==null){
            synchronized (RetroFitManage.class){
                if (instance==null){
                    instance=new RetroFitManage();
                }
            }
        }
        return instance;
    }
    public  void  getShow(String  url){
        Retrofit retrofit = builder.baseUrl(url)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                 .build();

        myInterFace = retrofit.create(MyInterFace.class);


    }
    public  void  getShow(String  url, ICallBack callBack, Type type){
        getShow(url);
      *//*  Observable banner = myInterFace.getBanner("");*//*

    }*/

}
