package com.cdqblog.service.impl;

import com.cdqblog.dao.PhotoDAO;
import com.cdqblog.model.Photo;
import com.cdqblog.service.PhotoService;

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
}
