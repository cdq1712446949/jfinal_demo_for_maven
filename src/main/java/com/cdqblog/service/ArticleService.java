package com.cdqblog.service;

import com.cdqblog.model.Article;
import com.jfinal.plugin.activerecord.Page;

import java.util.List;

public interface ArticleService {

    //通过pn获取article列表
    Page<Article> getArticle(int pn);

    //通过id获取article
    Article getArticleById(int id);

    //修改article状态
    boolean changeStatus(long id,int status);

    //添加article
    boolean addArticle(Article article);

    //管理员通过pn获取article列表(管理员可以获取已删除的article)
    Page<Article> getArticleByPn_admin(int pn);

    //管理元通过id获取article（管理员可以获取已删除的article）
    Article getArticleById_admin(long id);

    //根据类型名字返回类型值
    int toNum(String type);

    //获取最新的五篇文章
    Page<Article> getNewArticle();

    //根据id为article的浏览次数加一
    int addNumLook(long id);

    //根据type获取article
    Page<Article> getArticleByType(int pn,int type);

    //获取热门文章（浏览次数大于200的前五篇文章）
    Page<Article> getHotArticle();

}
