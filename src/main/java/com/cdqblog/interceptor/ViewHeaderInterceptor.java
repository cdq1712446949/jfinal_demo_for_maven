package com.cdqblog.interceptor;

import com.cdqblog.model.Articletype;
import com.cdqblog.service.ArticleTypeService;
import com.cdqblog.service.impl.ArticleTypeServiceImpl;
import com.jfinal.aop.Inject;
import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;

import java.util.List;

public class ViewHeaderInterceptor implements Interceptor {

    @Inject(ArticleTypeServiceImpl.class)
    private ArticleTypeService articleTypeService;

    @Override
    public void intercept(Invocation inv) {
        Controller controller=inv.getController();
        List<Articletype> list=articleTypeService.getAllArticleType();
        controller.setSessionAttr("headList",list);
        inv.invoke();
    }
}
