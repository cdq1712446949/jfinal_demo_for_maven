package com.cdqblog.service.impl;

import com.cdqblog.dao.PhotoDAO;
import com.cdqblog.model.Photo;
import com.cdqblog.service.PhotoService;
import com.jfinal.plugin.activerecord.Page;

public class PhotoServiceImpl implements PhotoService {

    private PhotoDAO photoDAO;

    public PhotoServiceImpl(){
        this.photoDAO=new PhotoDAO();
    }

    @Override
    public boolean addPhoto(Photo photo) {
        return photoDAO.addPhoto(photo);
    }

    @Override
    public boolean changeStatus(long id, int status) {
        return photoDAO.changeStatus(id,status);
    }

    @Override
    public Page<Photo> getPhotoByPn(int pn) {
        return photoDAO.findPhotoByPn_admin(pn);
    }

    @Override
    public Photo getPhotoById(long id) {
        return photoDAO.findPhotoById_admin(id);
    }
}
