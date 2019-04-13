package com.cdqblog.interceptor;

import com.cdqblog.service.ArticleService;
import com.cdqblog.service.impl.ArticleServiceImpl;
import com.jfinal.aop.Inject;
import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;
import com.jfinal.kit.PropKit;

public class GetArticleInterceptor implements Interceptor {

    @Inject(ArticleServiceImpl.class)
    private ArticleService articleService;

    @Override
    public void intercept(Invocation inv) {
        Controller controller=inv.getController();
        long id = controller.getParaToInt("id");
        int status=articleService.getArticleById_admin(id).getStatus();
        if (status==-1){
            controller.setAttr("url",PropKit.get("serverUrl"));
            controller.render("admin/error/404.html");
        }
        if(status==0){
            inv.invoke();
        }
    }
}
