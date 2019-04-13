package com.cdqblog.controller;

import com.cdqblog.interceptor.CheckLogin_UserController_Interceptor;
import com.cdqblog.model.Article;
import com.cdqblog.model.Articletype;
import com.cdqblog.service.ArticleService;
import com.cdqblog.service.ArticleTypeService;
import com.cdqblog.service.impl.ArticleServiceImpl;
import com.cdqblog.service.impl.ArticleTypeServiceImpl;
import com.jfinal.aop.Before;
import com.jfinal.aop.Inject;
import com.jfinal.core.Controller;
import com.jfinal.core.paragetter.Para;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.Page;

import java.util.List;

/**
 * 0表示java web，1表示java，2表示jfinal，3表示mysql，4表示maven，5表示asp.net，6表示adndroid，7表示ssh，8表示ssm
 */

@Before(CheckLogin_UserController_Interceptor.class)
public class ArticleController extends Controller {

    @Inject(ArticleServiceImpl.class)
    private ArticleService articleService;

    @Inject(ArticleTypeServiceImpl.class)
    private ArticleTypeService articleTypeService;

    //管理员获取article列表
    public void getAllArticle(int pn) {
        Page<Article> page = articleService.getArticleByPn_admin(pn);
        if (page == null) {
            page = new Page<Article>();
        }
        setSessionAttr("admin_article_pn",pn);
        setAttr("articlePage", page);
        render("admin/articlelist.html");
    }

    //前往article添加页面
    public void goAddArticle() {
        List<Articletype> list = articleTypeService.getAllArticleType();
        setAttr("list", list);
        render("admin/editor.html");
    }

    //添加article
    public void addArticleResult(Article article, String type) {
        int num = articleService.toNum(type);
        article.setType(num);
        boolean result = articleService.addArticle(article);
        if (result) {
            render("admin/add_success.html");
        } else {
            render("admin/error/unkonw_error.html");
        }
    }

    //删除article
    public void deleteArticle(long id) {
        boolean result = articleService.changeStatus(id, -1);
        if (result) {
            Page<Article> page = articleService.getArticleByPn_admin(getSessionAttr("admin_article_pn"));
            if (page == null) {
                page = new Page<Article>();
            }
            setAttr("articlePage", page);
            render("admin/articlelist.html");
        } else {
            render("admin/error/unkonw_error.html");
        }
    }

    //恢复删除article
    public void huifuArticle(long id) {
        boolean result = articleService.changeStatus(id, 0);
        if (result) {
            Page<Article> page = articleService.getArticleByPn_admin(getSessionAttr("admin_article_pn"));
            if (page == null) {
                page = new Page<Article>();
            }
            setAttr("articlePage", page);
            render("admin/articlelist.html");
        } else {
            render("admin/error/unkonw_error.html");
        }
    }


}
