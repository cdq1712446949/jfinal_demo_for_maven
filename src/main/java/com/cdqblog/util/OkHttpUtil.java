package com.cdqblog.util;

import okhttp3.*;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class OkHttpUtil {

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    //创建连接对象
    private static OkHttpClient okHttpClient=new OkHttpClient();

    public static String postUrl(String url,File file){
        RequestBody requestBody=RequestBody.create(MediaType.parse("image/*"),file);
        Request request=new Request.Builder()
                .url(url)          //传递请求地址
                .post(requestBody)     //设置请求参数
                .build();
        try {
            Response response=okHttpClient.newCall(request).execute();
//            System.out.println(response.body().string());
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "false";
    }

    public static String bowlingJson(File file) {
        return "{'smfile':'"+file+"']}";
    }

}
