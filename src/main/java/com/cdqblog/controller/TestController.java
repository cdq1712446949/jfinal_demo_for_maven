package com.cdqblog.controller;

import com.cdqblog.model.Articletype;
import com.cdqblog.model.Test;
import com.cdqblog.service.ArticleTypeService;
import com.cdqblog.service.TestService;
import com.cdqblog.service.impl.ArticleTypeServiceImpl;
import com.cdqblog.service.impl.TestServiceImpl;
import com.jfinal.aop.Inject;
import com.jfinal.core.Controller;

import java.util.List;

public class TestController extends Controller {

    @Inject(TestServiceImpl.class)
    private TestService testService;

    @Inject(ArticleTypeServiceImpl.class)
    private ArticleTypeService articleTypeService;

    public void getPage() {
        Test test = testService.getPage(1);
        setAttr("content", test.getContent());
        render("test.html");
    }

    public void test() {
        List<Articletype> list = articleTypeService.getAllArticleType();
        renderJson(list);

    }

}
