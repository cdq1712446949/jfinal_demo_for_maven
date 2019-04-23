package com.cdqblog.controller;

import com.cdqblog.interceptor.CheckLogin_UserController_Interceptor;
import com.cdqblog.model.Photo;
import com.cdqblog.service.PhotoService;
import com.cdqblog.service.impl.PhotoServiceImpl;
import com.cdqblog.util.ImageJsonUtil;
import com.jfinal.aop.Before;
import com.jfinal.aop.Inject;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Page;

@Before(CheckLogin_UserController_Interceptor.class)
public class PhotoController extends Controller {

    @Inject(PhotoServiceImpl.class)
    private PhotoService photoService;

    //返回上传图片页面
    public void goSubmitPhoto(){
        render("admin/subImage.html");
    }

    //管理员获取图片列表
    public void getPhoto(int pn){
        if(pn==0){
            pn=1;
        }
        Page<Photo> photoPage=photoService.getPhotoByPn(pn);
        setAttr("photoPage",photoPage);
        render("admin/photoList.html");
    }

    //管理员通过id获取photo对象
    public void getPhotoById(long id){
        Photo photo=photoService.getPhotoById(id);
        setAttr("photo",photo);
        render("admin/photo.html");
    }

    //上传图片
    public void addPhoto(String image){
        Photo photo=ImageJsonUtil.toPhoto(image);
        photoService.addPhoto(photo);
        render("admin/subImage.html");
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
