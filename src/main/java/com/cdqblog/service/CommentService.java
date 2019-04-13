package com.cdqblog.service;

import com.cdqblog.model.Comment;
import com.jfinal.plugin.activerecord.Page;

public interface CommentService {

    //管理员获取comment
    Page<Comment> getComment_amdin(int pn);

    //普通用户获取comment
    Page<Comment> getComment_user(int pn,long article_id);

    //修改comment记录状态属性值
    boolean changeStatus(long id,int status);

    //添加comment记录
    boolean addComment(Comment comment);

}
