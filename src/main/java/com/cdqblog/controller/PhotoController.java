package com.cdqblog.controller;

import com.cdqblog.interceptor.CheckLogin_UserController_Interceptor;
import com.cdqblog.model.Photo;
import com.cdqblog.service.PhotoService;
import com.cdqblog.service.impl.PhotoServiceImpl;
import com.cdqblog.util.ImageJsonUtil;
import com.jfinal.aop.Before;
import com.jfinal.aop.Inject;
import com.jfinal.core.Controller;

@Before(CheckLogin_UserController_Interceptor.class)
public class PhotoController extends Controller {

    @Inject(PhotoServiceImpl.class)
    private PhotoService photoService;

    //返回上传图片页面
    public void goSubmitPhoto(){
        render("admin/subimage.html");
    }

    //上传图片
    public void addPhoto(String image){
        Photo photo=ImageJsonUtil.toPhoto(image);
        photoService.addPhoto(photo);
        render("admin/subimage.html");
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
