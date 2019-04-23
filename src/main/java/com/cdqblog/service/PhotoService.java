package com.cdqblog.service;

import com.cdqblog.model.Photo;
import com.jfinal.plugin.activerecord.Page;

public interface PhotoService {

    //添加图片记录
    boolean addPhoto(Photo photo);

    //通过图片id修改图片状态
    boolean changeStatus(long id,int status);

    //管理员获取图片列表
    Page<Photo> getPhotoByPn(int pn);

    //通过id获取photo对象
    Photo getPhotoById(long id);

}
