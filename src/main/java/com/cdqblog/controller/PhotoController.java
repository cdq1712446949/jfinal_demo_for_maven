package com.cdqblog.controller;

import com.cdqblog.model.Photo;
import com.cdqblog.service.PhotoService;
import com.cdqblog.service.impl.PhotoServiceImpl;
import com.cdqblog.util.RequestURL;
import com.jfinal.aop.Inject;
import com.jfinal.core.Controller;
import net.sf.json.JSONObject;

import java.io.File;
import java.util.List;

public class PhotoController extends Controller {

    @Inject(PhotoServiceImpl.class)
    private PhotoService photoService;

    //上传图片
    public void addPhoto(File file){
        RequestURL requestURL=new RequestURL();
        JSONObject jsonObject =requestURL.requestUrl("https://sm.ms/api/upload");
    }

    //清除上传历史
    public void deleteHistory(){

    }

    //删除指定照片
    public void deletePhoto(){

    }

    //查询上传历史
    public void queryHistory(){

    }

}
