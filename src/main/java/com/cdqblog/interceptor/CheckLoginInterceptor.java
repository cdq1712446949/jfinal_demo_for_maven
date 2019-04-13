package com.cdqblog.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;
import com.jfinal.kit.PropKit;

public class CheckLoginInterceptor implements Interceptor {
    @Override
    public void intercept(Invocation inv) {
        Controller controller = inv.getController();
        if (controller.getSessionAttr("cdqblog_admin_username") == null) {
            controller.setAttr("login_error", "请登陆！");
            controller.setAttr("url", PropKit.get("serverUrl"));
            controller.render("admin_login.html");
        } else {
            inv.invoke();
        }
    }
}
