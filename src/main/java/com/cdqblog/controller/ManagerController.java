package com.cdqblog.controller;

import com.cdqblog.interceptor.CheckLoginInterceptor;
import com.cdqblog.model.Manager;
import com.cdqblog.model.User;
import com.cdqblog.service.ManagerService;
import com.cdqblog.service.impl.ManagerServiceImpl;
import com.jfinal.aop.Before;
import com.jfinal.aop.Clear;
import com.jfinal.aop.Inject;
import com.jfinal.core.Controller;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.Page;

import javax.servlet.http.HttpSession;

/**
 * @author cdq
 * created on 2018/11/22
 * 管理员登陆控制器
 */

@Before(CheckLoginInterceptor.class)
public class ManagerController extends Controller {

    @Inject(ManagerServiceImpl.class)
    private ManagerService managerService;

    @Clear(CheckLoginInterceptor.class)
    public void index() {
        render("admin_login.html");
    }

    @Clear(CheckLoginInterceptor.class)
    public void admin_login(String username, String password) {
        Manager manager = new Manager();
        manager.setUserName(username);
        manager.setPassword(password);
        boolean result = managerService.admin_login(manager);
        if (result) {
            setSessionAttr("cdqblog_admin_username", username);
            render("index.html");
        } else {
            setAttr("login_error", "用户名或者密码错误，请检查后重新登陆!");
            render("admin_login.html");
        }
    }

    //退出登录
    public void logout() {
        removeSessionAttr("cdqblog_admin_username");
        render("admin_login.html");
    }

    //admin首页
    public void admin_index() {
        render("index.html");
    }


}
