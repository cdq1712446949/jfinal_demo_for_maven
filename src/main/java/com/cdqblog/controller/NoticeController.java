package com.cdqblog.controller;

import com.cdqblog.model.Notice;
import com.cdqblog.service.NoticeService;
import com.cdqblog.service.impl.NoticeServiceImpl;
import com.jfinal.aop.Inject;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Page;

public class NoticeController extends Controller {

    private final String NOTICELIST = "admin/noticeList.html";

    @Inject(NoticeServiceImpl.class)
    private NoticeService noticeService;

    public void getNotice(int pn) {
        if (pn == 0) {
            pn = 1;
        }
        Page<Notice> noticePage = noticeService.getNotice_admin(pn);
        setAttr("noticePage", noticePage);
        render(NOTICELIST);
    }

    public void deleteNotice(long id) {
        boolean result = noticeService.changeStatus(id, -1);
        if (result){

        }
    }

}
