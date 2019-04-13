package com.cdqblog.service.impl;

import com.cdqblog.dao.ArticleDAO;
import com.cdqblog.model.Article;
import com.cdqblog.service.ArticleService;
import com.jfinal.plugin.activerecord.Page;

public class ArticleServiceImpl implements ArticleService {

    private ArticleDAO articleDAO;

    public ArticleServiceImpl() {
        articleDAO = new ArticleDAO();
    }

    @Override
    public Page<Article> getArticle(int pn) {
        return articleDAO.getArticle(pn);
    }

    @Override
    public Article getArticleById(int id) {
        Article article = null;
        article = articleDAO.getArticleByHotArticle(id);
        return article;
    }

    @Override
    public boolean changeStatus(long id, int status) {
        return articleDAO.changeStatus(id, status);
    }

    @Override
    public boolean addArticle(Article article) {
        return articleDAO.add(article);
    }

    @Override
    public Page<Article> getArticleByPn_admin(int pn) {
        Page<Article> page = null;
        page = articleDAO.getArticleByPn_admin(pn);
        return page;
    }

    @Override
    public Article getArticleById_admin(long id) {
        Article article = null;
        article = articleDAO.getArticleByIb_admin(id);
        return article;
    }

    @Override
    public int toNum(String type) {
        int num = 0;
        switch (type) {
            case "Java Web":
                num = 0;
                break;
            case "Java":
                num = 1;
                break;
            case "JFinal":
                num = 2;
                break;
            case "MySQL":
                num = 3;
                break;
            case "Maven":
                num = 4;
                break;
            case "ASP.NET":
                num = 5;
                break;
            case "Android":
                num = 6;
                break;
            case "SSH":
                num = 7;
                break;
            case "SSM":
                num = 8;
                break;
        }
        return num;
    }

    @Override
    public Page<Article> getNewArticle() {
        return articleDAO.getNewArticle();
    }

    @Override
    public int addNumLook(long id) {
        return articleDAO.addNumLook(id);
    }

    @Override
    public Page<Article> getArticleByType(int pn, int type) {
        return articleDAO.findArticleByType(pn,type);
    }

    @Override
    public Page<Article> getHotArticle() {
        return articleDAO.findHotArticle();
    }
}
