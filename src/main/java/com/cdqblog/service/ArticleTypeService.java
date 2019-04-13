package com.cdqblog.service;

import com.cdqblog.model.Articletype;
import com.jfinal.plugin.activerecord.Page;

import java.util.List;

public interface ArticleTypeService {

    //分页获取articelType列表
    Page<Articletype> getArticleTypeByPn(int pn);

    //通过过id查询articleType
    Articletype getArticleTypeById(long id);

    //通过id修改articleType的状态
    boolean changeStatus(long id,int status);

    //添加articleType
    boolean addArticleType(Articletype articletype);

    //用list获取所有articleType
    List<Articletype> getAllArticleType();

}
