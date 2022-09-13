package com.cydeo.service;

import com.cydeo.model.Comment;
import com.cydeo.proxy.CommentNotificationProxy;
import com.cydeo.repository.CommentRepository;
import com.cydeo.repository.DBCommentRepository;

public class CommentService {

    private CommentRepository commentRepository; // Interface - loosely coupled

    private CommentNotificationProxy commentNotificationProxy; // Interface


    public void publishComment(Comment comment){

        //save in the DB
        commentRepository.storeComment(comment);

        // send email
        commentNotificationProxy.sendComment(comment);




    }

}
