package com.example.zhoukao3.utils;

import android.os.Handler;
import android.util.Log;

import com.example.zhoukao3.inter.ICallBack;
import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.Type;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

public class HttpUtils {
    private static  volatile   HttpUtils  instance;
    private final OkHttpClient client;
    private Handler handler=new Handler();


    private HttpUtils(){

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





    }
    public  static  HttpUtils getInstance(){
        if (instance==null){
            synchronized (RetroFitManage.class){
                if (instance==null){
                    instance=new HttpUtils();
                }
            }
        }
        return instance;
    }

    public void  get(String  url, final ICallBack callBack, final Type type){
        Request request=new Request
                .Builder()
                .get()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        callBack.onFailed(e);
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Gson gson=new Gson();
                final Object o = gson.fromJson(string, type);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        callBack.onSuccess(o);
                    }
                });
            }
        });

    }

}
