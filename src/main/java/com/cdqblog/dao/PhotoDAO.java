package com.cdqblog.dao;

import com.cdqblog.model.Photo;
import com.jfinal.plugin.activerecord.Page;

import java.io.File;
import java.util.List;

public class PhotoDAO {

    //上传图片
    public boolean addPhoto(Photo photo){
        return photo.save();
    }

    //根据id修改图片状态
    public boolean changeStatus(long id,int status){
        Photo photo=new Photo();
        photo.setId(id);
        photo.setStatus(status);
        return photo.update();
    }

    //管理员查询图片列表
    public Page<Photo> findPhotoByPn_admin(int pn){
        return Photo.dao.paginate(pn,10,"select *","from photo");
    }

    //管理员通过id查询指定图片
    public Photo findPhotoById_admin(int id){
        return Photo.dao.findFirst("select * ","from photo id=?",id);
    }

}
