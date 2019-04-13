package com.cdqblog.controller;

import com.jfinal.core.Controller;

/**
 * @author cdq
 * 2019.3.12
 * 管理员编辑页面所有操作
 */

public class UEditerController extends Controller {

    //管理员才能进入uediter编辑文章页面并像数据库添加
    public void index() {
        render("index.html");
    }

}
