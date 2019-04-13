package com.cdqblog.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;
import com.jfinal.kit.PropKit;

public class DeleteUserInterceptor implements Interceptor {
    @Override
    public void intercept(Invocation inv) {
        Controller controller=inv.getController();
        if (controller.getSessionAttr("cdqblog_admin_username")!=null&&controller.getSessionAttr("cdqblog_admin_username").equals("admin")){
            inv.invoke();
        }else{
            controller.setAttr("power_error","权限不足!");
            controller.render("admin/error/power_error.html");
        }

    }
}
