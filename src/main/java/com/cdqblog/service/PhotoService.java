package com.cdqblog.service;

import com.cdqblog.model.Photo;

public interface PhotoService {

    //添加图片记录
    boolean addPhoto(Photo photo);

    //通过图片id修改图片状态
    boolean changeStatus(long id,int status);

}
