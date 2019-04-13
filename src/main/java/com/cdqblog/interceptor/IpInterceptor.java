package com.cdqblog.interceptor;

import com.cdqblog.model.Userip;
import com.cdqblog.service.UserIpService;
import com.cdqblog.service.impl.UserIpServiceImpl;
import com.cdqblog.util.IpUtil;
import com.jfinal.aop.Inject;
import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;

import java.util.Date;

public class IpInterceptor implements Interceptor {

    @Inject(UserIpServiceImpl.class)
    private UserIpService userIpService;

    @Override
    public void intercept(Invocation inv) {
        Controller controller=inv.getController();
        String ip=IpUtil.getIp(controller.getRequest());
        System.out.println("请求ip为："+ip);
        Userip userip=new Userip();
        userip.setAddress(ip);
        userip.setCreatedDate(new Date());
        userIpService.addUserIp(userip);
        inv.invoke();
    }
}
