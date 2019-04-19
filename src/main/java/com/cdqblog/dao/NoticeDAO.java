package com.cdqblog.dao;

import com.cdqblog.model.Notice;
import com.jfinal.plugin.activerecord.Page;

public class NoticeDAO {

    //用户获取notice列表
    public Page<Notice> getNoticeByPn_user(int pn){
        return Notice.dao.paginate(pn,5,"select * ","from notice where status=0");
    }

    //管理员获取notice列表
    public Page<Notice> getNoticeByPn_admin(int pn){
        return Notice.dao.paginate(pn,5,"select * ","from notice order by id");
    }

    //添加notice
    public boolean addNotice(Notice notice){
        return notice.save();
    }

    //修改notice状态属性值
    public boolean changeStatus(long id,int status){
        Notice notice=new Notice();
        notice.setId(id);
        notice.setStatus(status);
        return notice.update();
    }



}
