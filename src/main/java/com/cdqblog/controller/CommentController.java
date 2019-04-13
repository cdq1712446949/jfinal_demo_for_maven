package com.cdqblog.controller;

import com.cdqblog.model.Comment;
import com.cdqblog.service.CommentService;
import com.cdqblog.service.impl.CommentServiceImpl;
import com.jfinal.aop.Inject;
import com.jfinal.core.Controller;

import java.util.Date;

public class CommentController extends Controller {

    @Inject(CommentServiceImpl.class)
    private CommentService commentService;

    //用户发表评论
    public void addComment(String content, long user_id, long article_id) {
        Comment comment = new Comment();
        comment.setContent(content);
        comment.setCreatedDate(new Date());
        comment.setArticleId(article_id);
        comment.setUserId(user_id);
        commentService.addComment(comment);
        setAttr("article_id", article_id);
        render("comment_success.html");
    }

}
