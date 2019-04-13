package com.cdqblog.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;
import com.jfinal.kit.PropKit;

public class UserNameInterceptor implements Interceptor {
    @Override
    public void intercept(Invocation inv) {
        Controller controller=inv.getController();
        if (controller.getSessionAttr("cdqblog_user_username")==null){
            controller.setSessionAttr("cdqblog_user_username","");
            if (controller.getSessionAttr("blogName")==null){
                controller.setSessionAttr("blogName",PropKit.get("blogName"));
            }
        }
        inv.invoke();
    }
}
