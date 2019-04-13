package com.cdqblog.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;
import com.jfinal.kit.PropKit;

/**
 * @author cdq
 * created on 2019.4.4
 * 该拦截器用于拦截未登录的用户非法获取数据库内容，适用于试图路径为/view的controller
 */

public class CheckLogin_UserController_Interceptor implements Interceptor {
    @Override
    public void intercept(Invocation inv) {
        Controller controller = inv.getController();
        if (controller.getSessionAttr("cdqblog_admin_username") == null) {
            controller.setAttr("login_error", "请登陆！");
            controller.setAttr("url", PropKit.get("serverUrl"));
            controller.render("admin/admin_login.html");
        } else {
            inv.invoke();
        }
    }
}
