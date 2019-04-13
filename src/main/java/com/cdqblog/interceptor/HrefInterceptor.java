package com.cdqblog.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;
import com.jfinal.kit.PropKit;

public class HrefInterceptor implements Interceptor {
    @Override
    public void intercept(Invocation inv) {
        Controller controller=inv.getController();
        controller.setAttr("href",PropKit.get("href"));
        inv.invoke();
    }
}
