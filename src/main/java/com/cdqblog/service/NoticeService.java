package com.cdqblog.service;

import com.cdqblog.model.Notice;
import com.jfinal.plugin.activerecord.Page;

public interface NoticeService {

    //添加公告记录
    boolean addNotice(Notice notice);

    //修改状态属性值
    boolean changeStatus(long id,int status);

    //管理员获取notice记录
    Page<Notice> getNotice_admin(int pn);

    //普通用户获取notice记录
    Page<Notice> getNotice_user(int pn);

}
