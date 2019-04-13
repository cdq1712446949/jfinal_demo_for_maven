package com.cdqblog.controller;

import com.cdqblog.interceptor.CheckLogin_UserController_Interceptor;
import com.cdqblog.model.Articletype;
import com.cdqblog.service.ArticleTypeService;
import com.cdqblog.service.impl.ArticleTypeServiceImpl;
import com.jfinal.aop.Before;
import com.jfinal.aop.Inject;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Page;

/**
 * @author cdq
 * created on 2019.4.6
 */

@Before(CheckLogin_UserController_Interceptor.class)
public class ArticleTypeController extends Controller {

    @Inject(ArticleTypeServiceImpl.class)
    private ArticleTypeService articleTypeService;

    //获取标签类型列表
    public void getAllArticleType(int pn) {
        if (pn == 0) {
            pn = 1;
        }
        Page<Articletype> articletypePage = articleTypeService.getArticleTypeByPn(pn);
        setSessionAttr("admin_articleType_pn",pn);
        setAttr("articleTypePage", articletypePage);
        render("admin/articleTypeList.html");
    }

    //删除标签操作
    @Before(CheckLogin_UserController_Interceptor.class)
    public void deleteArticleType(long id) {
        boolean result = articleTypeService.changeStatus(id, -1);
        if (result) {
            Page<Articletype> articletypePage = articleTypeService.getArticleTypeByPn(getSessionAttr("admin_articleType_pn"));
            setAttr("articleTypePage", articletypePage);
            render("admin/articleTypeList.html");
        } else {
            setAttr("articleType_error", "删除失败请刷新重试");
            render("admin/error/404.html");
        }
    }

    //恢复标签方法
    @Before(CheckLogin_UserController_Interceptor.class)
    public void huifuArticleType(long id) {
        boolean result = articleTypeService.changeStatus(id, 0);
        if (result) {
            Page<Articletype> articletypePage = articleTypeService.getArticleTypeByPn(getSessionAttr("admin_articleType_pn"));
            setAttr("articleTypePage", articletypePage);
            render("admin/articleTypeList.html");
        } else {
            setAttr("articleType_error", "恢复失败请刷新重试");
            render("admin/error/404.html");
        }
    }
}
