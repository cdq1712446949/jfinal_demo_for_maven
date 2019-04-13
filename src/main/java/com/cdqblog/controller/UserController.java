package com.cdqblog.controller;

import com.cdqblog.interceptor.CheckLoginInterceptor;
import com.cdqblog.interceptor.CheckLogin_UserController_Interceptor;
import com.cdqblog.interceptor.DeleteUserInterceptor;
import com.cdqblog.model.Article;
import com.cdqblog.model.User;
import com.cdqblog.service.ArticleService;
import com.cdqblog.service.UserService;
import com.cdqblog.service.impl.ArticleServiceImpl;
import com.cdqblog.service.impl.UserServiceImpl;
import com.jfinal.aop.Before;
import com.jfinal.aop.Inject;
import com.jfinal.core.Controller;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.Page;

@Before(CheckLogin_UserController_Interceptor.class)
public class UserController extends Controller {

    @Inject(UserServiceImpl.class)
    private UserService userService;

    @Inject(ArticleServiceImpl.class)
    private ArticleService articleService;

    //获取用户列表
    public void getAllUsers(int pn) {
        Page<User> page = userService.getUsersByPn(pn);
        setSessionAttr("admin_user_pn",pn);
        setAttr("userPage", page);
        render("admin/list.html");
    }

    //删除用户
    @Before(DeleteUserInterceptor.class)
    public void deleteUser(long id) {
        boolean result = userService.deleteUser(id);
        if (result) {
            Page<User> page = userService.getUsersByPn(getSessionAttr("admin_user_pn"));
            setAttr("userPage", page);
            render("admin/list.html");
        } else {
            setAttr("delete_error", "删除失败！");
            Page<User> page = userService.getUsersByPn(1);
            setAttr("userPage", page);
            render("admin/list.html");
        }
    }

    //拉黑用户
    public void laheiUser(long id) {
        boolean result = userService.changeUserStatus(id, -1);
        Page<User> page = userService.getUsersByPn(getSessionAttr("admin_user_pn"));
        setAttr("userPage", page);
        render("admin/list.html");
    }

    //撤销拉黑
    public void chexiaoLaHeiUser(long id) {
        boolean result = userService.changeUserStatus(id, 0);
        Page<User> page = userService.getUsersByPn(getSessionAttr("admin_user_pn"));
        setAttr("userPage", page);
        render("admin/list.html");
    }

}
