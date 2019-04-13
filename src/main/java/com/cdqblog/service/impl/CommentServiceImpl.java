package com.cdqblog.service.impl;

import com.cdqblog.dao.CommentDAO;
import com.cdqblog.model.Comment;
import com.cdqblog.service.CommentService;
import com.jfinal.plugin.activerecord.Page;

public class CommentServiceImpl implements CommentService {

    private CommentDAO commentDAO;

    public CommentServiceImpl() {
        this.commentDAO = new CommentDAO();
    }

    @Override
    public Page<Comment> getComment_amdin(int pn) {
        return commentDAO.getComment_admin(pn);
    }

    @Override
    public Page<Comment> getComment_user(int pn, long article_id) {
        return commentDAO.getComment_user(pn,article_id);
    }

    @Override
    public boolean changeStatus(long id, int status) {
        return commentDAO.changeStatus(id,status);
    }

    @Override
    public boolean addComment(Comment comment) {
        return commentDAO.addComment(comment);
    }
}
