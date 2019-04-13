package com.cdqblog.dao;

import com.cdqblog.model.Article;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;

import java.util.List;

public class ArticleDAO {

    //只能获取状态为0的article
    public Page<Article> getArticle(int pn) {
        Page<Article> page = Article.dao.paginate(pn, 5, "select *", "from article where status=0");
        return page;
    }

    //通过分页方式获取article，可以获取所有article
    public Page<Article> getArticleByPn_admin(int pn) {
        Page<Article> page = Article.dao.paginate(pn, 10, "select *", "from article");
        return page;
    }

    //只能获取状态为0的article
    public Article getArticleByHotArticle(int id) {
        return Article.dao.findFirst("select * from article where id=? and status=0", id);
    }

    //管理员通过id获取article的方法
    public Article getArticleByIb_admin(long id) {
        return Article.dao.findFirst("select * from article where id=?", id);
    }

    //修改article 状态属性值
    public boolean changeStatus(long id, int status) {
        Article article = new Article();
        article.setId(id);
        article.setStatus(status);
        return article.update();
    }

    //添加article
    public boolean add(Article article) {
        return article.save();
    }

    //获取最新发布的五篇文章
    public Page<Article> getNewArticle() {
        return Article.dao.paginate(1, 5,
                "select *",
                "from article where status=0 order by id desc ");
    }

    //article浏览次数加一
    public int addNumLook(long id){
        return Db.update("update article set num_look=num_look+1 where id=?",id);
    }

    //通过类型获取文章列表
    public Page<Article> findArticleByType(int pn,int type){
        return Article.dao.paginate(pn,10,"select * ","from article where status=? and type=?",0,type);
    }

    //通过num_look获取热门文章
    public Page<Article> findHotArticle(){
        return Article.dao.paginate(1,5,"select * ","from article where status=? and num_look>200 order by id desc",0);
    }

}
