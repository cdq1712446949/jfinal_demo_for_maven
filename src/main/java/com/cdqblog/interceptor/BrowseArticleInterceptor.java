package com.cdqblog.interceptor;

import com.cdqblog.service.ArticleService;
import com.cdqblog.service.impl.ArticleServiceImpl;
import com.jfinal.aop.Inject;
import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;

/**
 * @author cdq
 * 浏览文章拦截器
 */

public class BrowseArticleInterceptor implements Interceptor {

    @Inject(ArticleServiceImpl.class)
    private ArticleService articleService;

    @Override
    public void intercept(Invocation inv) {
        Controller controller=inv.getController();
        long id = controller.getParaToInt("id");
        articleService.addNumLook(id);
        inv.invoke();
    }
}
