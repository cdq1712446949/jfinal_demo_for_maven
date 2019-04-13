package com.cdqblog.service.impl;

import com.cdqblog.dao.NoticeDAO;
import com.cdqblog.model.Notice;
import com.cdqblog.service.NoticeService;
import com.jfinal.plugin.activerecord.Page;

public class NoticeServiceImpl implements NoticeService {

    private NoticeDAO noticeDAO;

    public NoticeServiceImpl() {
        this.noticeDAO = new NoticeDAO();
    }

    @Override
    public boolean addNotice(Notice notice) {
        return noticeDAO.addNotice(notice);
    }

    @Override
    public boolean changeStatus(long id, int status) {
        return noticeDAO.changeStatus(id,status);
    }

    @Override
    public Page<Notice> getNotice_admin(int pn) {
        return noticeDAO.getNoticeByPn_admin(pn);
    }

    @Override
    public Page<Notice> getNotice_user(int pn) {
        return noticeDAO.getNoticeByPn_user(pn);
    }
}
