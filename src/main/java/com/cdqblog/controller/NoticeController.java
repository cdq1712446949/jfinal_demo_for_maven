package com.cdqblog.controller;

import com.cdqblog.service.NoticeService;
import com.cdqblog.service.impl.NoticeServiceImpl;
import com.jfinal.aop.Inject;
import com.jfinal.core.Controller;

public class NoticeController extends Controller {

    @Inject(NoticeServiceImpl.class)
    private NoticeService noticeService;



}
