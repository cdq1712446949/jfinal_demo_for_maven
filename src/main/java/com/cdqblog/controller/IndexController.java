package com.cdqblog.controller;

import com.cdqblog.interceptor.ViewHeaderInterceptor;
import com.cdqblog.model.Article;
import com.cdqblog.model.Notice;
import com.cdqblog.service.ArticleService;
import com.cdqblog.service.NoticeService;
import com.cdqblog.service.OneDayWordService;
import com.cdqblog.service.impl.ArticleServiceImpl;
import com.cdqblog.service.impl.NoticeServiceImpl;
import com.cdqblog.service.impl.OneDayServiceImpl;
import com.jfinal.aop.Before;
import com.jfinal.aop.Inject;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Page;

/**
 * @author cdq
 * creadted on 2018/11/21
 * 索引控制器
 */

public class IndexController extends Controller {

    @Inject(ArticleServiceImpl.class)
    private ArticleService articleService;//使用Inject注解注入对象，解耦和

    @Inject(OneDayServiceImpl.class)
    private OneDayWordService oneDayWordService;

    @Inject(NoticeServiceImpl.class)
    private NoticeService noticeService;

    //索引方法
    @Before(ViewHeaderInterceptor.class)
    public void index(){
        Page<Notice> noticePage=noticeService.getNotice_user(1);
        Page<Article> articlePage=articleService.getNewArticle();
        Page<Article> hotarticlePage=articleService.getHotArticle();
        setAttr("noticePage",noticePage);     //公告列表
        setAttr("onedayword",oneDayWordService.getNewOneDayWord());  //每日一句
        setAttr("articlePage",articlePage);         //文章列表
        setAttr("hotArticlePage", hotarticlePage);          //热门文章列表
        render("index.html");          //返回页面
    }


}
