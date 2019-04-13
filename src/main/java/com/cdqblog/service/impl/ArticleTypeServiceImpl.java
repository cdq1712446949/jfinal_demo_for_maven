package com.cdqblog.service.impl;

import com.cdqblog.dao.ArticleTypeDAO;
import com.cdqblog.model.Articletype;
import com.cdqblog.service.ArticleTypeService;
import com.jfinal.plugin.activerecord.Page;

import java.util.List;

public class ArticleTypeServiceImpl implements ArticleTypeService {

    private ArticleTypeDAO articleTypeDAO;

    public ArticleTypeServiceImpl(){
        this.articleTypeDAO=new ArticleTypeDAO();
    }

    @Override
    public Page<Articletype> getArticleTypeByPn(int pn) {
        return articleTypeDAO.findArticleTypeByPn(pn);
    }

    @Override
    public Articletype getArticleTypeById(long id) {
        return articleTypeDAO.findArticleTypeById(id);
    }

    @Override
    public boolean changeStatus(long id, int status) {
        return articleTypeDAO.changeStatus(id,status);
    }

    @Override
    public boolean addArticleType(Articletype articletype) {
        return articleTypeDAO.add(articletype);
    }

    @Override
    public List<Articletype> getAllArticleType() {
        return articleTypeDAO.getAllArticle();
    }
}
