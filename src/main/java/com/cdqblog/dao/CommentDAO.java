package com.cdqblog.dao;

import com.cdqblog.model.Comment;
import com.jfinal.plugin.activerecord.Page;

public class CommentDAO {

    //获取所有评论
//    public List<>

    //管理员获取comment列表
    public Page<Comment> getComment_admin(int pn) {
        return Comment.dao.paginate(pn, 10, "select *", "from comment");
    }

    //普通用户获取comment记录
    public Page<Comment> getComment_user(int pn, long article_id) {
        return Comment.dao.paginate(pn,
                10,
                "select user.username,comment.article_id,comment.content,comment.createdDate",
                "from comment,user where comment.article_id=? and comment.status=? and user.id=comment.user_id",
                article_id, 0);
    }

    //修改comment记录状态属性值
    public boolean changeStatus(long id, int status) {
        Comment comment = new Comment();
        comment.setId(id);
        comment.setStatus(status);
        return comment.update();
    }

    //添加comment记录
    public boolean addComment(Comment comment) {
        return comment.save();
    }

}
