package com.cydeo.service;

import com.cydeo.model.Comment;
import com.cydeo.proxy.CommentNotificationProxy;
import com.cydeo.repository.CommentRepository;
import com.cydeo.repository.DBCommentRepository;
import org.springframework.stereotype.Component;

@Component
public class CommentService {

    //unique stuff , business logic
    private CommentRepository commentRepository; // Interface - loosely coupled

    private CommentNotificationProxy commentNotificationProxy; // Interface

    public CommentService(CommentRepository commentRepository, CommentNotificationProxy commentNotificationProxy) {
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
    }

    public void publishComment(Comment comment){

        //save in the DB
        commentRepository.storeComment(comment);
        // send email
        commentNotificationProxy.sendComment(comment);




    }

}
