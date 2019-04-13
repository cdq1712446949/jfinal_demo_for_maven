package com.cdqblog.controller;

import com.cdqblog.interceptor.BrowseArticleInterceptor;
import com.cdqblog.interceptor.GetArticleInterceptor;
import com.cdqblog.model.Article;
import com.cdqblog.model.Comment;
import com.cdqblog.model.Notice;
import com.cdqblog.service.*;
import com.cdqblog.service.impl.*;
import com.jfinal.aop.Before;
import com.jfinal.aop.Inject;
import com.jfinal.core.Controller;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.Page;

/**
 * @author cdq
 * created on 2018/11/22
 * 查看博客详细内容
 */

public class BlogController extends Controller {

    @Inject(ArticleServiceImpl.class)
    private ArticleService articleService;

    @Inject(OneDayServiceImpl.class)
    private OneDayWordService oneDayWordService;

    @Inject(NoticeServiceImpl.class)
    private NoticeService noticeService;

    @Inject(CommentServiceImpl.class)
    private CommentService commentService;

    @Before({GetArticleInterceptor.class, BrowseArticleInterceptor.class})
    public void initArticle(int id, int comment_pn) {
        if (comment_pn == 0) {
            comment_pn = 1;
        }
        Page<Notice> noticePage = noticeService.getNotice_user(1);
        Article article = articleService.getArticleById(id);//通过id获取Article只能获取一个，id为主键
        Page<Article> hotarticlePage = articleService.getHotArticle();    //获取热门文章
        Page<Comment> commentPage = commentService.getComment_user(comment_pn, id);
        setAttr("commentPage", commentPage);
        setAttr("noticePage", noticePage);
        setAttr("hotArticlePage", hotarticlePage);
        setAttr("onedayword", oneDayWordService.getNewOneDayWord());
        setAttr("article", article);
        render("blog.html");
    }

    //通过type获取文章
    public void getArticleByType(int pn, int type) {
        if (pn == 0) {
            pn = 1;
        }
        Page<Article> articlePage = articleService.getArticleByType(pn, type);
        setAttr("type", type);
        setAttr("articlePage", articlePage);
        render("blog_type_list.html");
    }

    public void test() {
        Page<Article> articlePage = articleService.getArticleByType(1, 0);
//        setAttr("type",type);
//        setAttr("articlePage",articlePage);
        renderJson(articlePage);
    }

}
