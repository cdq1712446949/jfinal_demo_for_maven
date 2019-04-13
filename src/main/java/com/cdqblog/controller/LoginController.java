package com.cdqblog.controller;

import com.cdqblog.model.Article;
import com.cdqblog.model.Notice;
import com.cdqblog.model.User;
import com.cdqblog.service.*;
import com.cdqblog.service.impl.*;
import com.jfinal.aop.Inject;
import com.jfinal.core.Controller;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.Page;

import java.util.Date;

public class LoginController extends Controller {

    @Inject(UserServiceImpl.class)
    private UserService userService;

    @Inject(ArticleServiceImpl.class)
    private ArticleService articleService;//使用Inject注解注入对象，解耦和

    @Inject(OneDayServiceImpl.class)
    private OneDayWordService oneDayWordService;

    @Inject(NoticeServiceImpl.class)
    private NoticeService noticeService;

    //忘记密码
    public void forgetPd() {
        render("forgetPd.html");
    }

    //普通用户前往登陆页面
    public void goLogin() {
        render("user_login.html");
    }

    //普通用户前往登陆页面
    public void registView() {
        render("user_login.html");
    }

    //登陆结果
    public void loginResult(User user) {
        boolean result = userService.login(user);
        if (result) {
            User login_user = userService.findUserByPhone(user.getPhone());
            setSessionAttr("cdqblog_user_username", login_user.getUsername());
            setSessionAttr("cdqblog_user_id", login_user.getId());
            Page<Notice> noticePage = noticeService.getNotice_user(1);
            Page<Article> articlePage = articleService.getNewArticle();
            Page<Article> hotarticlePage = articleService.getHotArticle();
            setAttr("noticePage", noticePage);
            setAttr("onedayword", oneDayWordService.getNewOneDayWord());
            setAttr("articlePage", articlePage);
            setAttr("hotArticlePage", hotarticlePage);          //热门文章列表
            setAttr("blogName", PropKit.get("blogName"));
            render("index.html");
        } else {
            setAttr("login_error", "登陆失败，请检查手机号或者密码是否正确!");
            render("user_login.html");
        }
    }

    //注册结果
    public void registResult(User user) {
        user.setCreatedDate(new Date());
        if(user.getPhone()==null||user.getUsername()==null||user.getPassword()==null){
            setAttr("regist_error", "四个框，按提示填写，不能少!");
            render("user_login.html");
        }else {
            boolean result = userService.regist(user);
            if (result) {
                User login_user = userService.findUserByPhone(user.getPhone());
                setSessionAttr("cdqblog_user_usernam", user.getUsername());
                render("user_login.html");
            } else {
                setAttr("regist_error", "注册失败，该手机号已注册!");
                render("user_login.html");
            }
        }
    }

}
