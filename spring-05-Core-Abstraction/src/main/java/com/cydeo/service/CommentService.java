package com.cydeo.service;

import com.cydeo.model.Comment;
import com.cydeo.proxy.CommentNotificationProxy;
import com.cydeo.repository.CommentRepository;
import com.cydeo.repository.DBCommentRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CommentService {

    //unique stuff , business logic
    private final CommentRepository commentRepository; // Interface - loosely coupled

    private final CommentNotificationProxy commentNotificationProxy; // Interface

    //                                                                      default bean name
    public CommentService(CommentRepository commentRepository, @Qualifier("emailCommentNotificationProxy") CommentNotificationProxy commentNotificationProxy) {
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
