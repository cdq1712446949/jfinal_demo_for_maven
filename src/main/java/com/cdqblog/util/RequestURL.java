package com.cdqblog.util;

import com.cdqblog.model.Photo;
import com.jfinal.json.Jackson;
import com.jfinal.json.Json;
import net.sf.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class RequestURL {

    private static URL url;

    public static Photo modelToJson(String data){
        return  Jackson.getJson().parse(data,Photo.class);
    }

    public JSONObject requestUrl(String u){
        StringBuilder json=new StringBuilder();
        try {
            url=new URL(u);
            URLConnection connection=url.openConnection();
            //防止乱码
            BufferedReader in=new BufferedReader(new InputStreamReader(connection.getInputStream(),"utf-8"));
            String input=null;
            while ((input=in.readLine())!=null){
                json.append(input);
            }
            in.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String jsonString=json.toString();
        return JSONObject.fromObject(jsonString);
    }

    public void okHttp(){

    }

}
